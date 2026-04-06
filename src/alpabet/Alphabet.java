package alpabet;
import java.util.*;

public class Alphabet {
    private final HashMap<Character, Integer> alphabet;
    private final HashMap<String, Integer> subsequences;

    public Alphabet() {
        alphabet = new HashMap<>();
        subsequences = new HashMap<>();
    }

    public void addCharacter(Character c, Integer value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be nonnegative.");
        }

        if (!alphabet.containsKey(c)) {
            alphabet.put(c, value);
            subsequences.put(String.valueOf(c), value);
        } else {
            throw new IllegalStateException(c + " is already in the alphabet.");
        }
    }

    public Integer getCharacterValue(Character c) {
        if (alphabet.containsKey(c)) {
            return alphabet.get(c);
        } else {
            throw new IllegalArgumentException(c + " is not in the alphabet.");
        }
    }

    public Integer getStringValue(String str) {
        if ((str == null) || str.isEmpty()) {
            return 0;
        }

        if (!subsequences.containsKey(str)) {
            //IO.println(str + " not found.  Calculating subsequence...");
            Integer strVal = getCharacterValue(str.charAt(0)) + getStringValue(str.substring(1));
            subsequences.put(str, strVal);
        }

        return subsequences.get(str);
    }

    public String findMaxSubstring(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return "";
        }

        if (s1.equals(s2)) {
            return s1;
        }

        Integer n = s1.length();
        Integer m = s2.length();

        String[][] cache = new String[n + 1][m + 1];

        // Initialize the cache.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cache[i][j] = "";
            }
        }

        for (int i = 0; i < n; i++) {
            Character c1 = s1.charAt(i);

            for (int j = 0; j < m; j++) {
                Character c2 = s2.charAt(j);

                String candidate = "";

                if (c1 == c2) {
                    candidate = cache[i][j] + c1;
                }

                if ((getStringValue(candidate) >= getStringValue(cache[i + 1][j])) &&
                        (getStringValue(candidate) >= getStringValue(cache[i][j + 1]))) {
                    cache[i + 1][j + 1] = candidate;
                } else if (getStringValue(cache[i][j + 1]) >= getStringValue(cache[i + 1][j])) {
                    cache[i + 1][j + 1] = cache[i][j + 1];
                } else {
                    cache[i + 1][j + 1] = cache[i + 1][j];
                }
            }
        }

        return cache[n][m];
    }

    public void print() {
        IO.println("===== ALPHABET ENTRIES =====");

        if (alphabet.isEmpty()) {
            IO.println("The alphabet is empty.");
            return;
        }

        for (var key : alphabet.keySet()) {
            IO.println(key + " : " + getCharacterValue(key));
        }
    }
}

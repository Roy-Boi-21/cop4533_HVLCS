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
            throw new IllegalArgumentException(c + " is already in the alphabet.");
        }
    }

    public Integer getCharacterValue(Character c) {
        if (alphabet.containsKey(c)) {
            return alphabet.get(c);
        } else {
            throw new IllegalStateException(c + " is not in the alphabet.");
        }
    }

    public Integer getStringValue(String str) {
        if (str.isEmpty()) {
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

        Integer maxValue = -1;
        String maxSubstring = s1;

        for (int i = 0; i < s1.length(); i++) {
            String substr1 = s1.substring(0, i) + s1.substring(i + 1);

            for (int j = 0; j < s2.length(); j++) {
                String substr2 = s2.substring(0, j) + s2.substring(j + 1);
                String commonSubstr = findMaxSubstring(substr1, substr2);
                Integer substrValue = getStringValue(commonSubstr);

                if (substrValue > maxValue) {
                    maxValue = substrValue;
                    maxSubstring = commonSubstr;
                }
            }
        }

        return maxSubstring;
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

package alpabet;
import java.util.*;

public class Alphabet {
    private final HashMap<Character, Integer> alphabet;

    public Alphabet() {
        alphabet = new HashMap<>();
    }

    public void addCharacter(Character c, Integer value) {
        if (!alphabet.containsKey(c)) {
            alphabet.put(c, value);
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
        Integer totalValue = 0;

        for (int i = 0; i < str.length(); i++) {
            totalValue += getCharacterValue(str.charAt(i));
        }

        return totalValue;
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

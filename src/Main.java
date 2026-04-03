import alpabet.Alphabet;

void main() {
    Alphabet alphabet = new Alphabet();

    alphabet.addCharacter('a', 2);
    alphabet.addCharacter('b', 4);
    alphabet.addCharacter('c', 5);

    alphabet.print();

    String strA = "caab";
    String strB = "aacb";

    // This first operation fills the alphabet with subsequence data.
    IO.println(alphabet.findMaxSubstring(strA, strB));
    IO.println();
    // This second operation will finish faster because the result has already been computed.
    IO.println(alphabet.findMaxSubstring(strA, strB));
}

import alpabet.Alphabet;

void main() {
    IO.println("Hello and welcome!");

    Alphabet alphabet = new Alphabet();

    alphabet.print();

    alphabet.addCharacter('m', 5);
    alphabet.addCharacter('a', 1);
    alphabet.addCharacter('j', 3);
    alphabet.addCharacter('i', 2);


    alphabet.print();

    IO.println(alphabet.getStringValue("jijimama"));
}

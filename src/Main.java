import alpabet.Alphabet;
import input.FileReader;
import input.InputData;

void main() {
    // Collect the input.
    IO.println("Welcome to the Highest Value Largest Common Subsequence Algorithm!");

    Scanner userInput = new Scanner(System.in);
    InputData data = null;

    while (data == null) {
        IO.println("Please enter the name of the file to read.");
        String filename = userInput.nextLine();
        data = FileReader.ReadFile("tests/" + filename);
    }

    // Calculate the optimal substring.

    Alphabet alphabet = new Alphabet();

    for (Character c : data.alphabet.keySet()) {
        alphabet.addCharacter(c, data.alphabet.get(c));
    }

    String strA = data.strA;
    String strB = data.strB;

    String optimal = alphabet.findMaxSubstring(strA, strB);

    IO.println(alphabet.getStringValue(optimal));
    IO.println(optimal);
}

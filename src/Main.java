import alpabet.Alphabet;
import input.InputReader;
import input.InputData;

void main() {
    // Collect the input.
    IO.println("=== Welcome to the Highest Value Largest Common Subsequence Algorithm! ===");

    Scanner userInput = new Scanner(System.in);
    InputData data = null;
    String inputChoice;

    while (true) {
        IO.println("How would you like to enter the data?");
        IO.println("1. Input manually.");
        IO.println("2. Read from file.");
        IO.println("3. Randomly generate data.");

        inputChoice = userInput.nextLine();

        if (Objects.equals(inputChoice, "1") ||
                Objects.equals(inputChoice, "2") ||
                Objects.equals(inputChoice, "3")) {
            break;
        } else {
            IO.println("Please type an integer between 1 and 3.");
        }
    }

    while (data == null) {
        switch (inputChoice) {
            case "1":
                data = InputReader.ReadManually();
                break;
            case "2":
                IO.println("Please enter the name of the file to read.");
                String filename = userInput.nextLine();
                data = InputReader.ReadFile("tests/" + filename);
                break;
            case "3":
                data = InputReader.GenerateData();
                break;
        }
    }

    // Calculate the optimal substring.

    Alphabet alphabet = new Alphabet();

    for (Character c : data.alphabet.keySet()) {
        alphabet.addCharacter(c, data.alphabet.get(c));
    }

    String strA = data.strA;
    String strB = data.strB;

    alphabet.print();
    IO.println(strA);
    IO.println(strB);

    String optimal = alphabet.findMaxSubstring(strA, strB);

    IO.println(alphabet.getStringValue(optimal));
    IO.println(optimal);
}

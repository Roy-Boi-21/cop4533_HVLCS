package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class InputReader {
    public static InputData ReadManually() {
        InputData data = new InputData();

        Scanner dataReader = new Scanner(System.in);

        data.alphabetSize = -1;

        while (data.alphabetSize < 0) {
            IO.println("How many characters are in the alphabet?");
            try {
                data.alphabetSize = dataReader.nextInt();

                if (data.alphabetSize < 0) {
                    IO.println("Please enter a nonnegative integer.");
                }
            } catch (InputMismatchException e) {
                IO.println("Please enter a nonnegative integer.");
            }
        }

        for (int i = 0; i < data.alphabetSize; i++) {
            Character c = '\0';
            Integer value = -1;

            while (c == '\0') {
                IO.println("Enter a character.  (" + (i + 1) + "/" + data.alphabetSize + ")");

                try {
                    c = dataReader.next().charAt(0);
                } catch (InputMismatchException e) {
                    IO.println("Invalid input.  Expected character.");
                }
            }

            while (value < 0) {
                IO.println("Enter that character's value.  (" + (i + 1) + "/" + data.alphabetSize + ")");

                try {
                    value = dataReader.nextInt();

                    if (value < 0) {
                        IO.println("Invalid input.  Value most be nonnegative.");
                    }
                } catch (InputMismatchException e) {
                    IO.println("Invalid input.  Expected integer.");
                }
            }

            data.alphabet.put(c, value);
        }

        // Discard the newline character.
        dataReader.nextLine();

        IO.println("Enter the first string.");
        data.strA = dataReader.nextLine();

        IO.println("Enter the second string.");
        data.strB = dataReader.nextLine();

        return data;
    }

    public static InputData ReadFile(String filename) {
        InputData data = new InputData();

        File dataFile = new File(filename);

        try (Scanner dataReader = new Scanner(dataFile)) {
            data.alphabetSize = dataReader.nextInt();

            for (int i = 0; i < data.alphabetSize; i++) {
                Character newCharacter = dataReader.next().charAt(0);
                Integer newValue = dataReader.nextInt();

                data.alphabet.put(newCharacter, newValue);
            }

            // Discard the empty line.
            dataReader.nextLine();

            data.strA = dataReader.nextLine();
            data.strB = dataReader.nextLine();

            return data;
        } catch (FileNotFoundException e) {
            IO.println("File not found.");
            return null;
        } catch (InputMismatchException e) {
            IO.println("Invalid file format.");
            return null;
        }
    }

    public static InputData GenerateData() {
        InputData data = new InputData();

        Scanner dataReader = new Scanner(System.in);

        data.alphabetSize = -1;

        while (data.alphabetSize < 0) {
            IO.println("How many characters are in the alphabet?");
            try {
                data.alphabetSize = dataReader.nextInt();

                if (data.alphabetSize < 0) {
                    IO.println("Please enter a nonnegative integer.");
                }
            } catch (InputMismatchException e) {
                IO.println("Please enter a nonnegative integer.");
            }
        }

        Integer lowerBound = -1;
        Integer upperBound = -1;

        while (lowerBound < 0) {
            IO.println("What is the lower bound of the alphabet?");
            try {
                lowerBound = dataReader.nextInt();

                if (lowerBound < 0) {
                    IO.println("Please enter a nonnegative integer.");
                }
            } catch (InputMismatchException e) {
                IO.println("Please enter a nonnegative integer.");
            }
        }

        while (upperBound < lowerBound) {
            IO.println("What is the upper bound of the alphabet?");
            try {
                upperBound = dataReader.nextInt();

                if (upperBound < 0) {
                    IO.println("Please enter a nonnegative integer.");
                } else if (upperBound < lowerBound) {
                    IO.println("The upper bound must be greater than the lower bound.");
                }
            } catch (InputMismatchException e) {
                IO.println("Please enter a nonnegative integer.");
            }
        }

        Random rng = new Random();
        for (char c = 'A'; c < ('A' + data.alphabetSize); c++) {
            data.alphabet.put(c, rng.nextInt(upperBound - lowerBound) + lowerBound);
        }

        int stringLength = -1;

        while (stringLength < 0) {
            IO.println("How many characters long are the two input strings?");
            try {
                stringLength = dataReader.nextInt();

                if (stringLength < 0) {
                    IO.println("Please enter a nonnegative integer.");
                }
            } catch (InputMismatchException e) {
                IO.println("Please enter a nonnegative integer.");
            }
        }

        data.strA = "";
        data.strB = "";
        for (int i = 0; i < stringLength; i++) {
            data.strA += (char)('A' + rng.nextInt(data.alphabetSize));
            data.strB += (char)('A' + rng.nextInt(data.alphabetSize));
        }

        return data;
    }
}

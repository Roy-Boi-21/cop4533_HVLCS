package input;
import input.InputData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileReader {
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
}

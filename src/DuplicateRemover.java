package Eliminate;
import java.util.*;
import java.io.*;


public class DuplicateRemover {

    public static void main(String[] args) throws IOException {
        HashSet<String> uniqueWords = new HashSet<String>();
        ArrayList<String> outputLines = new ArrayList<String>();

        Scanner dataFile = new Scanner(new FileReader("problem1.txt"));
        while (dataFile.hasNextLine()) {

            // Split a line into an array of words.
            String[] words = dataFile.nextLine().split(" ");
            String edited = "";
            for (int i = 0; i < words.length; i++) {

                // If the word is already in the set, remove it.
                if (uniqueWords.add(words[i])) {
                    edited += words[i] + " ";
                }
            }

            edited = edited.strip();  // Remove excess whitespace.

            // Add the final line to our output array.
            if (!edited.equals("")) {
                outputLines.add(edited);
            }
        }

        // Write the output array to specified file.
        String outputFile = "unique_words.txt";
        BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
        output.write(String.join("\n", outputLines));
        output.close();
        System.out.println("File '" + outputFile + "' created!");
    }

}

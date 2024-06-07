import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCounter {
	public static void main(String[] args) {
        // Change the file path to your text file
        String filePath = "C:\\Users\\user\\eclipse-workspace\\WordCount\\src\\word.txt";

        // Create a Map to store word counts
        Map<String, Integer> wordCounts = new HashMap<>();

        // Read the file and count the occurrences of each word
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                // Remove punctuation
                word = word.replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            return;
        }

        // Create a TreeMap to sort the word counts alphabetically
        Map<String, Integer> sortedWordCounts = new TreeMap<>(wordCounts);

        // Display the word count for each unique word in alphabetical order
        for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

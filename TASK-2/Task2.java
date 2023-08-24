import java.io.*;
import java.util.*;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to Word Counter!");
        System.out.print("Enter 'text' to input text, or 'file' to input from a file: ");
        String choice = scanner.nextLine().trim().toLowerCase();
        
        String text = "";
        
        if (choice.equals("text")) {
            System.out.print("Enter your text: ");
            text = scanner.nextLine();
        } else if (choice.equals("file")) {
            System.out.print("Enter the file name (with extension): ");
            String fileName = scanner.nextLine();
            try {
                text = readFile(fileName);
            } catch (IOException e) {
                System.out.println("Error reading the file.");
                return;
            }
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        
        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = words.length;
        
        // Additional feature: Ignoring common words or stop words
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "and", "is", "in", "to", "of"));
        for (String word : words) {
            if (stopWords.contains(word.toLowerCase())) {
                wordCount--;
            }
        }
        
        System.out.println("Total word count: " + wordCount);
        
        // Additional feature: Number of unique words
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));
        System.out.println("Number of unique words: " + uniqueWords.size());
        
        // Additional feature: Frequency of each word
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        System.out.println("Word frequency: " + wordFrequency);
    }
    
    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }
}
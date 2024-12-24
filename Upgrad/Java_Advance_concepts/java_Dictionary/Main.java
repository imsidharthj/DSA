import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// stores word definitions. Implement a Dictionary class that uses a Map to store word-to-definition mappings
public class Main {
    static class Dictionary {
        private Map<String, String> wordDefinitions;

        public Dictionary() {
            this.wordDefinitions = new HashMap<>();
        }

        public void addWordDefinition(String word, String definition) {
            wordDefinitions.put(word, definition);
        }

        public String getWordDefinition(String word) {
            return wordDefinitions.get(word);
        }

        public boolean hasWord(String word) {
            return wordDefinitions.containsKey(word);
        }
    }

	public static void main(String args[] ) throws Exception {
		Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();
        dictionary.addWordDefinition("Java", "A high-level programming language.");
        dictionary.addWordDefinition("Algorithm", "A step-by-step procedure for solving a problem.");
        dictionary.addWordDefinition("Class", "A blueprint for creating objects that encapsulates data and behavior.");
        System.out.print("Enter a word to get its definition: ");
        String wordToDefine = scanner.nextLine();
        String definition = dictionary.getWordDefinition(wordToDefine);
        if (definition != null) {
            System.out.println("Definition of \"" + wordToDefine + "\": " + definition);
        } else {
            System.out.println("Definition of \"" + wordToDefine + "\": null");
        }
        System.out.print("Enter a word to check if it exists: ");
        String wordToCheck = scanner.nextLine();
        boolean exists = dictionary.hasWord(wordToCheck);
        System.out.println("Has \"" + wordToCheck + "\"? " + exists);
        scanner.close();
	}
}
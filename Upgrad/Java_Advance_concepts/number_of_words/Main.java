import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main { // implement a WordCounter class to count occurrences of specific words in a text
	public static void main(String args[] ) throws Exception {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = scanner.nextLine();

        System.out.println("Enter the word to count occurrences:");
        String word = scanner.nextLine();

        int occurrences = countWordOccurrences(text, word);
        System.out.println("Occurrences of \"" + word + "\": " + occurrences);

        String longestWord = findLongestWord(text);
        System.out.println("Longest word: " + longestWord);

        String textWithoutVowels = removeVowels(text);
        System.out.println("Text without vowels: " + textWithoutVowels);
        scanner.close();
	}
	
	public static int countWordOccurrences(String text, String word) {
        String[] words = text.split("\\s+");
        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        return count;
    }

    public static String findLongestWord(String text) {
        String[] words = text.split("\\s+");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public static String removeVowels(String text) {
        return text.replaceAll("[aeiouAEIOU]", "");
    }
}
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Map;
import java.util.HashMap;

public class Main { // Implement a TextValidator class
	public static void main(String args[] ) throws Exception {
		String email = "user@example.com";
        String wordToRemoveDuplicates = "programming";
        String textToReplaceWords = "Java is a popular programming language.";

        Map<String, String> wordMap = new HashMap<>();
        wordMap.put("Java", "Python");
        wordMap.put("programming", "coding");
        wordMap.put("React", "Angular");
        wordMap.put("code", "framework");

        boolean isValid = isValidEmail(email);
        System.out.println("Is email valid? " + isValid);

        String textWithoutDuplicates = removeDuplicateCharacters(wordToRemoveDuplicates);
        System.out.println("After removing duplicates: " + textWithoutDuplicates);

        String replacedText = replaceWords(textToReplaceWords, wordMap);
        System.out.println("Replaced text: " + replacedText);
	}
	
	public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|org|net|edu)$";
        return email.matches(emailRegex);
    }

    public static String removeDuplicateCharacters(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (result.indexOf(String.valueOf(text.charAt(i))) == -1) {
                result.append(text.charAt(i));
            }
        }
        return result.toString();
    }

    public static String replaceWords(String text, Map<String, String> wordMap) {
        for (Map.Entry<String, String> entry : wordMap.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }
        return text;
    }

}
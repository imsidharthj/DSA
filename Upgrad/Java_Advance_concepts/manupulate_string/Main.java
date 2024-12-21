import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main { // manipulate strings count, reverse, palindrom check, caplitalize
    public static void main(String[] args) {
    
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println("Word count: " + StringUtils.countWords(input));
        System.out.println("Reversed string: " + StringUtils.reverseString(input));
        System.out.println("Is palindrome: " + StringUtils.isPalindrome(input));
        System.out.println("Capitalized words: " + StringUtils.capitalizeWords(input));
   }
}

class StringUtils {

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static String reverseString(String text) {
        if (text == null) {
            return "";
        }
        return new StringBuilder(text).reverse().toString();
    }

    public static boolean isPalindrome(String text) {
        if (text == null) {
            return false;
        }
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();
        String reversedText = new StringBuilder(cleanedText).reverse().toString();
        return cleanedText.equals(reversedText);
    }

    public static String capitalizeWords(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        String[] words = text.split(" ");
        StringBuilder capitalizedText = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalizedText.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
            }
        }
        return capitalizedText.toString().trim();
    }
}
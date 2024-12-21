import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// substring into the original string at the specified position using a StringBuilder.
public class Main { // concatenate an array of strings using a StringBuilder and return the resulting string.
    public static String concatenateStrings(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static String insertSubstring(String original, String substring, int position) {
        StringBuilder sb = new StringBuilder(original);
        sb.insert(position, substring);
        return sb.toString();
    }
    
	public static void main(String args[] ) throws Exception {
		Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); 
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = scanner.nextLine();
        }
        String substring = scanner.nextLine();
        int position = scanner.nextInt();
        String concatenatedResult = concatenateStrings(strings);
        System.out.println("Concatenated: " + concatenatedResult);
        String insertedResult = insertSubstring(concatenatedResult, substring, position);
        System.out.println("Inserted: " + insertedResult);
        scanner.close();
	}
}
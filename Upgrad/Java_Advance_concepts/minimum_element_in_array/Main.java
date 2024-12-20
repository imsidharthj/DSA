import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// Class name should be "Source",
// otherwise solution won't be accepted
public class Main {
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        String[] strArray = new String[m];
        for (int i = 0; i < m; i++) {
            strArray[i] = scanner.next();
        }

        Integer minInteger = GenericMinFinder.findMin(intArray);
        String minString = GenericMinFinder.findMin(strArray);

        System.out.println("Minimum integer: " + minInteger);
        System.out.println("Minimum string: " + minString);
	}
}

class GenericMinFinder {
    public static <T extends Comparable<T>> T findMin(T[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        T min = array[0];
        for (T element : array) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }
}
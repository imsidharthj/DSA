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
		Pair<Integer> integerPair = new Pair<>(10, 20);
        Pair<String> stringPair = new Pair<>("Hello", "World");

        System.out.println("Integer Pair: " + integerPair.getFirst() + ", " + integerPair.getSecond());
        System.out.println("String Pair: " + stringPair.getFirst() + ", " + stringPair.getSecond());

        integerPair.setFirst(30);
        stringPair.setSecond("Java");

        System.out.println("Updated Integer Pair: " + integerPair.getFirst() + ", " + integerPair.getSecond());
        System.out.println("Updated String Pair: " + stringPair.getFirst() + ", " + stringPair.getSecond());
	}
}

class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
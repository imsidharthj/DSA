import java.util.Scanner;
import java.util.*;

public class Main{
    public static void main(String arg[]) {
        Stack<Character> s = new Stack<Character>();
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        for( char c : data.toCharArray()){
            s.push(c);
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()){
            result.append(s.pop());
        }
        System.out.println(result.toString());
    }
}

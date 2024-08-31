import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static void plusMinus(List<Integer> arr) {
    // Write your code here
    int positive = 0;
    int negative = 0;
    int zero = 0;
        for (int i=0; i<arr.size(); i++){
            if(arr.get(i)>0){
                positive++;
            } else if(arr.get(i)<0){
                negative++;
            } else{
                zero++;
            }
        }
    System.out.printf("%.6f%n", (double) positive/arr.size());
    System.out.printf("%.6f%n", (double) negative/arr.size());
    System.out.printf("%.6f%n", (double) zero/arr.size());
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

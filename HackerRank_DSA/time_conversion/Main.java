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

    public static String timeConversion(String s) {
    String [] time = s.substring(0, s.length()-2).split(":");
    String unit = s.substring(s.length()-2);
    
    int hour = Integer.parseInt(time[0]);
    int minutes = Integer.parseInt(time[1]);
    int seconds = Integer.parseInt(time[2]);
    if (unit.equals("PM") && hour != 12) {
        hour += 12;
    } else if (unit.equals("AM") && hour == 12) {
        hour = 0;
    }
    return String.format("%02d:%02d:%02d", hour, minutes, seconds);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

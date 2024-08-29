// #!/bin/python3

// import math
// import os
// import random
// import re
// import sys

// #
// # Complete the 'compareTriplets' function below.
// #
// # The function is expected to return an INTEGER_ARRAY.
// # The function accepts following parameters:
// #  1. INTEGER_ARRAY a
// #  2. INTEGER_ARRAY b
// #

// def compareTriplets(a, b):
//     # Write your code here
//     alice = 0
//     bob = 0
//     for i in range(3):
//         if a[i] > b[i]:
//             alice += 1
//         elif a[i] < b[i]:
//             bob += 1
//     return [alice, bob]
    

// if __name__ == '__main__':
//     fptr = open(os.environ['OUTPUT_PATH'], 'w')

//     a = list(map(int, input().rstrip().split()))

//     b = list(map(int, input().rstrip().split()))

//     result = compareTriplets(a, b)

//     fptr.write(' '.join(map(str, result)))
//     fptr.write('\n')

//     fptr.close()
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int alice = 0;
    int bob = 0;
    for (int i = 0; i < 3; i++){
        if (a.get(i) > b.get(i)){
            alice += 1;
        } else if (a.get(i) < b.get(i)){
            bob += 1;
        }
    }
    return Arrays.asList(alice, bob);
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        String[] bTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bTemp[i]);
            b.add(bItem);
        }

        List<Integer> result = Result.compareTriplets(a, b);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

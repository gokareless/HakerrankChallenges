package org.gokareless.hakerrank.alg;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SolutionCountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valleysCount = 0;
        int currentPosition = 0;
        int nextPosition = 0;
        char[] path = s.toCharArray();
        for (char character : path) {
            currentPosition = nextPosition;
            if (character == 'D') {
                nextPosition--;
            }
            if (character == 'U') {
                nextPosition++;
            }
            if (currentPosition == 0 && nextPosition == -1) {
                valleysCount++;
            }
        }
        return valleysCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}


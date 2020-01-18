package org.gokareless.hakerrank.alg;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class SolutionRepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String string, long number) {
        char[] chars = string.toCharArray();
        long aCount = countA(chars);
        long amount = number / string.length();
        aCount*= amount;
        int lastSize = (int) (number % string.length());
        char[] lastChars = string.substring(0, lastSize).toCharArray();
        aCount+= countA(lastChars);
        return aCount;
    }

    private static long countA(char[] chars) {
        long count = 0;
        for (char character : chars) {
            if (character == 'a') {
                count++;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}

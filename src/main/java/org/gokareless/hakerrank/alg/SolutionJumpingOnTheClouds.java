package org.gokareless.hakerrank.alg;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SolutionJumpingOnTheClouds {

    public static final int THUNDERSTORM = 1;
    public static final int CUMULATIVE = 0;

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] clouds) {
        // first jump already done
        int jumps = 1;
        if (clouds.length == 2) {
            return jumps;
        }
        int lastCloud = clouds.length - 1;
        int beforeLastCloud = clouds[lastCloud - 2] == 0 ? lastCloud - 2 : lastCloud - 1;
        int secondCloud = clouds[1] == 0 ? 1 : 2;

        for (int cloud = secondCloud; cloud <= beforeLastCloud; cloud+= 2) {
            if (cloud == beforeLastCloud) {
                jumps++;
                break;
            }
            if (cloud != secondCloud && clouds[cloud + 2] == THUNDERSTORM) {
                cloud--;
            }
            jumps++;
        }

        return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}

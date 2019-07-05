package org.gokareless.hakerrank.alg;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SolutionSockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] socks) {
        int pairs = 0;
        List<Integer> paired = new ArrayList<>();
        for (int firstSockId = 0; firstSockId < socks.length; firstSockId++) {
            if (paired.contains(firstSockId)) {
                continue;
            }
            int firstSock = socks[firstSockId];
            for (int secondSockId = 0; secondSockId < socks.length; secondSockId++) {
                if (firstSockId == secondSockId) {
                    continue;
                }
                if (paired.contains(secondSockId)) {
                    continue;
                }
                int secondSock = socks[secondSockId];
                if (firstSock == secondSock) {
                    pairs++;
                    paired.add(firstSockId);
                    paired.add(secondSockId);
                    break;
                }
            }
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

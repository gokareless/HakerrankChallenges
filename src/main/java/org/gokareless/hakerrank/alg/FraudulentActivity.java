package org.gokareless.hakerrank.alg;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudulentActivity {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int days) {
        int count = 0;
        List<Integer> trail = createTrail(expenditure, days);
        Collections.sort(trail);
        for (int start = 0, current = start + days; current < expenditure.length; start++, current++) {
            float median = getMedian(trail, days);
            int startElement = expenditure[start];
            int currentElement = expenditure[current];
            if (median * 2 <= currentElement) {
                count++;
            }
            updateTrail(trail, startElement, currentElement);
        }
        return count;
    }

    static List<Integer> createTrail(int[] expenditure, int days) {
        List<Integer> trail = new ArrayList<>(days);
        for (int i = 0; i < days; i++)
            trail.add(expenditure[i]);
        return trail;
    }

    static void updateTrail(List<Integer> trail, int oldEl, int newEl) {
        if (oldEl == newEl)
            return;
        int oldIndex = Collections.binarySearch(trail, oldEl);
        trail.remove(oldIndex);
        int newIndex = Collections.binarySearch(trail, newEl);
        if (newIndex < 0) {
            newIndex = Math.abs(newIndex) - 1;
        }
        trail.add(newIndex, newEl);
    }

    static float getMedian(List<Integer> trail, int period) {
        float median;
        if (period % 2 == 0) {
            median = (float) (trail.get(period / 2) + trail.get((period / 2) - 1)) / 2;
        } else {
            median = trail.get(period / 2);
        }
        return median;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

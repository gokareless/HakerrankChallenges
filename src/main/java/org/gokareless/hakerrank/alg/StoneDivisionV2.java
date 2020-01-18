package org.gokareless.hakerrank.alg;

import java.io.IOException;
import java.util.*;

public class StoneDivisionV2 {

    // Complete the stoneDivision function below.
    static long stoneDivision(long pile, long[] array) {
        Arrays.sort(array);
        // assume that all indexes are factors
        int index = findLastDivisibleIndex(pile, array, array.length - 1);
        long moves = 0;
        long piles = pile / array[index];
        if (piles >= 2) {
            moves += 1;
        }
        return countMoves(array[index], array, index, moves, piles);
    }

    static long countMoves(long pile, long[] array, int index, long moves, long piles) {
        if (index == 0) {
            return moves;
        }
        index = findLastDivisibleIndex(pile, array, index);
        moves += piles;
        piles *= pile / array[index];
        return countMoves(array[index], array, index, moves, piles);
    }

    static int findLastDivisibleIndex(long element, long[] array, int lastIndex) {
        if (array[lastIndex] == element) {
            lastIndex--;
        }
        if (lastIndex == 0) {
            return lastIndex;
        }
        int beforeLastIndex = lastIndex - 1;
        int searchIndex = lastIndex;
        while (beforeLastIndex >= 0
                && array[beforeLastIndex] >= Math.sqrt(element)
                && array[lastIndex] / array[beforeLastIndex] < 2) {
            searchIndex = beforeLastIndex;
            beforeLastIndex--;
        }
        return searchIndex;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        long n = Long.parseLong(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] s = new long[m];

        String[] sItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long sItem = Long.parseLong(sItems[i]);
            s[i] = sItem;
        }

        long result = stoneDivision(n, s);
        System.out.println(result);

        scanner.close();
    }
}
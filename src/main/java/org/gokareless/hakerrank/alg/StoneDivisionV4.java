package org.gokareless.hakerrank.alg;

import java.io.IOException;
import java.util.*;

public class StoneDivisionV4 {

    // Complete the stoneDivision function below.
    static long stoneDivision(long pile, long[] array) {
        return countMoves(pile, array, new HashMap<>());
    }

    private static long countMoves(long pile, long[] array, Map<Long, Long> map) {
        if (pile == 0 || pile == 1) {
            return 0;
        }
        if (map.containsKey(pile)) {
            return map.get(pile);
        }
        long maxMoves = 0;
        for (long element : array) {
            long moves = 0;
            if (pile % element != 0 || pile == element) {
                continue;
            }
            long piles = pile / element;
            moves += countMoves(element, array, map) * piles;
            moves += 1;
            maxMoves = Math.max(maxMoves, moves);
        }
        map.put(pile, maxMoves);
        return maxMoves;
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
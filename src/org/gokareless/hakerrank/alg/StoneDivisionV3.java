package org.gokareless.hakerrank.alg;

import java.io.IOException;
import java.util.*;

public class StoneDivisionV3 {

    // Complete the stoneDivision function below.
    static long stoneDivision(long pile, long[] array) {
        List<Long> list = toList(array);
        Collections.sort(list);
        // assume that all indexes are factors
        long piles = 1;
        long maxMoves = 0;
        maxMoves = countMoves(pile, list, piles, maxMoves);
        return maxMoves;
    }

    private static long countMoves(long pile, List<Long> list, long piles, long maxMoves) {
        for (long element : list) {
            long moves = moves(pile, element, list, piles);
            if (moves > maxMoves) {
                maxMoves = moves;
            }
        }
        return maxMoves;
    }

    private static long moves(long pile, long element, List<Long> list, long piles) {
        if (list.isEmpty()) {
            return 0;
        }
        List<Long> sublist = new ArrayList<>(list);
        if (pile % element == 0 && pile != element) {
            sublist.remove(element);
            return piles + moves(element, list.get(list.size() - 1), sublist, piles * pile / element);
        } else {
            sublist.remove(element);
            return moves(pile, list.get(list.size() - 1), sublist, piles);
        }
    }

    static List<Long> toList(long[] array) {
        List<Long> list = new ArrayList<>();
        for (long element : array)
            list.add(element);
        return list;
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
package org.gokareless.hakerrank.alg;

import java.io.*;
import java.util.*;

public class StoneDivision {

    // Complete the stoneDivision function below.
    static long stoneDivision(long pile, long[] array) {
        List<Long> list = toList(array);
        Collections.sort(list);
        int index = list.size() - 1;
        long moves = 0;
        long piles = 1;
        while (index > 0) {
            long root = (long) Math.sqrt(pile);
            long factor = findFactor(pile, list, index, root, pile / pile, list.get(index));
            moves += piles;
            piles *= pile / factor;
            pile = factor;
            index--;
        }
        return moves;
    }

    static long findFactor(long pile, List<Long> list, int index, long root, long factor, long element) {
        long otherElement = list.get(index--);
        if (otherElement >= root) {
            if (pile % otherElement == 0 && pile / otherElement > factor) {
                element = otherElement;
            }
            return findFactor(pile, list, index, root, factor, element);
        }
        list.retainAll(list.subList(0, list.indexOf(element) + 1));
        return element;
    }

    static long countMoves(long pile, List<Long> list, long moves, long piles) {
        int lastIndex = list.size() - 1;
        if (lastIndex < 0) {
            return moves;
        }
        long element = list.get(lastIndex);
        if (pile == element || pile % element != 0) {
            list.remove(element);
            return countMoves(pile, list, moves, piles);
        } else {
            moves += piles;
            piles *= pile / element;
            list.remove(element);
            return countMoves(element, list, moves, piles);
        }
    }

    static List<Long> toList(long[] array) {
        List<Long> list = new ArrayList<>();
        for (long element : array)
            list.add(element);
        return list;
    }

    static Set<Long> findDivisors(long number) {
        Set<Long> divisors = new HashSet<>();
        for (long digit = 1; digit <= Math.sqrt(number); digit++) {
            if (number % digit == 0) {
                divisors.add(digit);
                divisors.add(number / digit);
            }
        }
        return divisors;
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
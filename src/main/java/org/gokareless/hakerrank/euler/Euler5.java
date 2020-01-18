package org.gokareless.hakerrank.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Euler5 {

    public static void main(String[] args) {
        long number = 20;
        System.out.println(lcd(number));
    }

    private static long lcd(long border) {
        long product = 1;
        Map<Long, Long> factors = new HashMap<>();
        for (long number = 2; number <= border; number++) {
            FactorPair pair = findLargestPrimeFactorPair(number);
            if (!factors.containsKey(number) || factors.get(number) < pair.count) {
                factors.put(pair.number, pair.count);
            }
        }
        List<Long> factorList = new ArrayList<>();
        for (Map.Entry<Long, Long> entry : factors.entrySet()) {
            if (!factorList.contains(entry.getValue())) {
                factorList.add(entry.getKey());
                factorList.add(entry.getValue());
            } else {
                factorList.add(entry.getKey());
            }
        }
       for (Long factor : factorList) {
           product *= factor;
       }

        return product;
    }

    private static FactorPair findLargestPrimeFactorPair(long number) {
        FactorPair factorPair = new FactorPair();
        long factor = (long) Math.sqrt(number);
        while (factor >= 2) {
            if (number % factor == 0) {
                factorPair.number = number = number / factor;
                factorPair.count += factor;
                factor = (long) Math.sqrt(number);
            } else {
                factor -= 1;
            }
        }
        if (factorPair.number == 0) factorPair.number = number;
        if (factorPair.count == 0) factorPair.count = 1;
        return factorPair;
    }

    static class FactorPair {
        long number;
        long count;
    }

}

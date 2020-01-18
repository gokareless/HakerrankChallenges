package org.gokareless.hakerrank.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Euler5_2C {

    public static void main(String[] args) {
        long number = 20;
        System.out.println(lcd(number));
    }

    private static long lcd(long border) {
        Map<Long, List<Long>> numberToFactors = new HashMap<>();
        for (long number = 2; number <= border; number++) {
            numberToFactors.put(number, findFactors(number));
        }
        Map<Long, Long> allFactorsToCounts = new HashMap<>();
        for (List<Long> factors : numberToFactors.values()) {
            Map<Long, Long> factorsToCounts = new HashMap<>();
            for (long factor : factors) {
                if (factorsToCounts.containsKey(factor)) {
                    factorsToCounts.put(factor, factorsToCounts.get(factor) + 1);
                } else {
                    factorsToCounts.put(factor, 1L);
                }
            }
            for (long factor : factorsToCounts.keySet()) {
                if (allFactorsToCounts.containsKey(factor)) {
                    if (allFactorsToCounts.get(factor) < factorsToCounts.get(factor)) {
                        allFactorsToCounts.put(factor, factorsToCounts.get(factor));
                    }
                } else {
                    allFactorsToCounts.put(factor, factorsToCounts.get(factor));
                }
            }
        }
        long product = 1;
        for (Map.Entry<Long, Long> entry : allFactorsToCounts.entrySet()) {
            product *= Math.pow(entry.getKey(), entry.getValue());
        }
        return product;
    }

    private static List<Long> findFactors(long number) {
        List<Long> factors = new ArrayList<>();
        long factor = 2;
        while (number >= factor) {
            if (number % factor == 0) {
                factors.add(factor);
                number = number / factor;
            } else {
                factor++;
            }
        }
        return factors;
    }

}

package org.gokareless.hakerrank.inter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IceCreamParlor3 {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        IceCreamParlor3 ic = new IceCreamParlor3();
        List<Integer> costs = ic.calculateCosts(cost, money);
        System.out.println(costs.get(0) + " " + costs.get(1));
    }

    Map<Long, Tuple> cache = new HashMap<>();

    public List<Integer> calculateCosts(int[] cost, int money) {
        cache.clear();
        Set<Tuple> tuples = calculateSums(cost, money);
        Tuple maxTuple = tuples.stream()
            .max((f, s) -> 
                f.sum - s.sum >= 0
                    ? f.sum - s.sum == 0
                        ? 0 : 1
                    : -1
            )
            .get();
        return Arrays.asList(maxTuple.firstFlavorId, maxTuple.secondFlavorId);
    }

    public Set<Tuple> calculateSums(int[] cost, int money) {
        Set<Tuple> tuples = new HashSet<>();
        int firstElementId = 1;
        for (int i = 0; i < cost.length; i++) {
            Integer firstElement = cost[i];
            if (firstElement > money) {
                firstElementId++;
                continue;
            }
            int secondElementId = firstElementId + 1;
            for (int j = i + 1; j < cost.length; j++) {
                Integer secondElement = cost[j];
                long sum = firstElement + secondElement;
                if (secondElement > money || sum > money || cache.containsKey(sum)) {
                    secondElementId++;
                    continue;
                }
                Tuple tuple = Tuple.of(firstElementId, secondElementId, sum);
                tuples.add(tuple);
                if (sum == money) {
                    return tuples;
                }
                cache.put(sum, tuple);
                secondElementId++;
            }
            firstElementId++;
        }
        return tuples;
    }

    static class Tuple {
        private int firstFlavorId;
        private int secondFlavorId;
        private long sum;

        private Tuple(int firstFlavorId, int secondFlavorId, long sum) {
            this.firstFlavorId = firstFlavorId;
            this.secondFlavorId = secondFlavorId;
            this.sum = sum;
        }

        public static Tuple of(int firstFlavorId, int secondFlavorId, long sum) {
            return new Tuple(firstFlavorId, secondFlavorId, sum);
        }

        @Override
        public boolean equals(Object object) {
            Tuple tuple = (Tuple) object;
            return this.firstFlavorId == tuple.firstFlavorId
                    && this.secondFlavorId == tuple.secondFlavorId
                    && this.sum == tuple.sum;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + (int) firstFlavorId;
            hash = 31 * hash + (int) secondFlavorId;
            hash = 31 * hash + (int) sum;
            return hash;
        }

        @Override
        public String toString() {
            return "" + 
            firstFlavorId + " " +
            secondFlavorId + " " +
            sum;
        }
    }
}

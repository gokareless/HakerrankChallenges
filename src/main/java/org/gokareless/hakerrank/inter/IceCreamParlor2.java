package org.gokareless.hakerrank.inter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class IceCreamParlor2 {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        List<Integer> costs = calculateCosts(cost, money);
        System.out.println(costs.get(0) + " " + costs.get(1));
    }

    public static List<Integer> calculateCosts(int[] cost, int money) {
        List<Tuple> tuples = calculateSums(cost, money);
        Tuple maxTuple = tuples.stream()
            .max((f, s) -> f.sum - s.sum)
            .get();
        return Arrays.asList(maxTuple.firstFlavorId, maxTuple.secondFlavorId);
    }

    public static List<Tuple> calculateSums(int[] cost, int money) {
        List<Tuple> tuples = new ArrayList<>();
        List<Integer> list = Arrays.stream(cost).boxed().collect(Collectors.toList());
        Queue<Integer> queue = new LinkedList<>(list);
        int firstElementId = 1;
        while (!queue.isEmpty()) {
            Integer firstElement = queue.poll();
            if (firstElement > money) {
                firstElementId++;
                continue;
            }
            int secondElementId = firstElementId + 1;
            Queue<Integer> smallQueue = new LinkedList<>(queue);
            while (!smallQueue.isEmpty()) {
                Integer secondElement = smallQueue.poll();
                if (secondElement > money || firstElement + secondElement > money) {
                    secondElementId++;
                    continue;
                }
                Tuple tuple = Tuple.of(firstElementId, secondElementId, firstElement + secondElement);
                tuples.add(tuple);
                secondElementId++;
            }
            firstElementId++;
        }
        return tuples;
    }

    static class Tuple {
        private int firstFlavorId;
        private int secondFlavorId;
        private int sum;

        private Tuple(int firstFlavorId, int secondFlavorId, int sum) {
            this.firstFlavorId = firstFlavorId;
            this.secondFlavorId = secondFlavorId;
            this.sum = sum;
        }

        public static Tuple of(int firstFlavorId, int secondFlavorId, int sum) {
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

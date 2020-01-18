package org.gokareless.hakerrank.inter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IceCreamParlor5 {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        IceCreamParlor3 ic = new IceCreamParlor3();
        List<Integer> costs = ic.calculateCosts(cost, money);
        System.out.println(costs.get(0) + " " + costs.get(1));
    }

    public List<Integer> calculateCosts(int[] cost, int money) {
        int maxSum = 0;
        int firstId = 1;
        int secondId = 2;
        boolean found = false;
        List<Integer> processedFlavors = new ArrayList<>();
        for (int i = 0; i < cost.length; i++) {
            int firstFlavor = cost[i];
            if (processedFlavors.contains(firstFlavor) || firstFlavor >= money) {
                continue;
            }
            for (int j = i + 1; j < cost.length; j++) {
                int secondFlavor = cost[j];
                if (secondFlavor >= money) {
                    continue;
                }
                int sum = firstFlavor + secondFlavor;
                if (sum > money) {
                    continue;
                }
                firstId = i + 1;
                secondId = j + 1;
                if (sum == money) {
                    found = true;
                    break;
                } else if (maxSum < sum) {
                    maxSum = sum;
                }
            }
            if (found == true) {
                break;
            }
            processedFlavors.add(firstFlavor);
        }
        return Arrays.asList(firstId, secondId);
    }

}

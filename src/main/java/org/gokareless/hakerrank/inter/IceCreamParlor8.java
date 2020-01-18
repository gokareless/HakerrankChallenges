package org.gokareless.hakerrank.inter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IceCreamParlor8 {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        IceCreamParlor3 ic = new IceCreamParlor3();
        List<Integer> costs = ic.calculateCosts(cost, money);
        System.out.println(costs.get(0) + " " + costs.get(1));
    }

    public List<Integer> calculateCosts(int[] cost, int money) {
        int[] costCopy = new int[cost.length];
        System.arraycopy(cost, 0, costCopy, 0, cost.length);
        Arrays.sort(costCopy);
        int max = money - 1;
        int min = 1;
        while (max >= min) {
            int maxId = Arrays.binarySearch(costCopy, max);
            int minId = Arrays.binarySearch(costCopy, min);
            if (maxId >= 0 && minId >= 0) {
                break;
            }
            max--;
            min++;
        }
        int firstId = 1;
        int secondId = 2;
        boolean ffound = false;
        boolean sfound = false;
        for (int j = 0; j < cost.length; j++) {
            if (cost[j] == max) {
                firstId = j + 1;
                ffound = true;
                if (sfound)
                    break;
            }
            if (cost[j] == min) {
                secondId = j + 1;
                sfound = true;
                if (ffound && max != min)
                    break;
                else
                    continue;
            }
        }

        List<Integer> result = Arrays.asList(firstId, secondId);
        Collections.sort(result);
        return result;
    }

}

package org.gokareless.hakerrank.inter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IceCreamParlor7 {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        IceCreamParlor3 ic = new IceCreamParlor3();
        List<Integer> costs = ic.calculateCosts(cost, money);
        System.out.println(costs.get(0) + " " + costs.get(1));
    }

    public List<Integer> calculateCosts(int[] cost, int money) {
        int firstId = 1;
        int secondId = 2;
        boolean found = false;
        int max = money - 1;
        int min = 1;
        while (max >= min) {
            List<Integer> processed = new ArrayList<>();
            for (int i = 0; i < cost.length; i++) {
                if (processed.contains(cost[i])) {
                    continue;
                }
                if (cost[i] == min) {
                    for (int j = 0; j < cost.length; j++) {
                        if (i == j) {
                            continue;
                        }
                        if (cost[j] == max) {
                            firstId = i + 1;
                            secondId = j + 1;
                            found = true;
                            break;
                        }
                    }
                }
                if (found) {
                    break;
                }
                processed.add(cost[i]);
            }
            if (found) {
                break;
            } else {
                max--;
                min++;
            }
        }
        List<Integer> result = Arrays.asList(firstId, secondId);
        Collections.sort(result);
        return result;
    }

}

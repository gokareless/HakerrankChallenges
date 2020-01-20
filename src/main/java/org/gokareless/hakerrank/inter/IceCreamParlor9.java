package org.gokareless.hakerrank.inter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IceCreamParlor9 {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        IceCreamParlor9 ic = new IceCreamParlor9();
        List<Integer> costs = ic.calculateCosts(cost, money);
        System.out.println(costs.get(0) + " " + costs.get(1));
    }

    public List<Integer> calculateCosts(int[] cost, int money) {
        // sort array
        int[] costCopy = new int[cost.length];
        System.arraycopy(cost, 0, costCopy, 0, cost.length);
        Arrays.sort(costCopy);
        // max and min flavor costs
        int max = money - 1;
        int min = 1;
        // finding potential flavor ids in sorted array
        int maxId = Arrays.binarySearch(costCopy, max);
        int minId = Arrays.binarySearch(costCopy, min);
        // adjust ids if they not in array
        if (maxId < 0) {
            maxId = Math.abs(maxId + 2);
            max = costCopy[maxId];
        }
        if (minId < 0) {
            minId = 0;
            min = costCopy[minId];
        }
        // searching case where both flavor cost equals to money
        while (max + min != money) {
            while (max + min > money) {
                max = costCopy[--maxId];
            } 
            while (max + min < money) {
                min = costCopy[++minId];
            }              
        }   
        // find flavor ids in real array
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

    public static void main(String[] args) {
        int t = 1;

        for (int tItr = 0; tItr < t; tItr++) {
            int money = 901048554;
            int n = 7158;
            int[] cost = new int[n];

            String content = read("/home/myan/Documents/Study/data/hakerrank/ice_cream_parlor.txt");
            content = content.replace("\n", "");
            content = content.replace("\r", "");
            String[] costItems = content.split(" ");
 
            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }
    }
       
    private static String read(String filePath) {
        String content = "";
        try {
            content = new String (Files.readAllBytes(Paths.get(filePath) ) );
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}

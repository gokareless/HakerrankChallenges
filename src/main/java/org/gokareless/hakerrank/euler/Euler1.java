package org.gokareless.hakerrank.euler;

import java.util.Scanner;

public class Euler1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            process(n);
        }
    }

    static void process(int number) {
        int sum = 0;
        int firstDivisor = findTopDivisor(number, 5);
        int secondDivisor = findTopDivisor(number, 3);
        int multiplyDivisor = findTopDivisor(number, 3 * 5);

        int firstCount = firstDivisor / 5;
        int secondCount = secondDivisor / 3;
        int multiplyCount = multiplyDivisor / (3 * 5);

        sum += (firstCount * (firstDivisor + 5)) / 2;
        sum += (secondCount * (secondDivisor + 3)) / 2;
        sum -= (multiplyCount * (multiplyDivisor + 3 * 5)) / 2;

        System.out.println(sum);
    }

    static int findTopDivisor(int number, int division) {
        if (number % division == 0)
            return findTopDivisor(number - 1, division);
        return number - number % division;
    }

}

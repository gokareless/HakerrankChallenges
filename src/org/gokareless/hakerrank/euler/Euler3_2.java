package org.gokareless.hakerrank.euler;

public class Euler3_2 {

    public static void main(String[] args) {
        long number = 10;
        System.out.println(findPrimeFactor(number));
    }

    private static long findPrimeFactor(long number) {
        long factor = (long) Math.sqrt(number);
        while (factor >= 2) {
            if (number % factor == 0) {
                number = number / factor;
                factor = (long) Math.sqrt(number);
            } else {
                factor -= 1;
            }
        }
        return number;
    }

}

package org.gokareless.hakerrank.euler;

public class Euler3C {

    public static void main(String[] args) {
        long number = 600851475143L;
        System.out.println(findPrimeFactor(number));
    }

    private static long findPrimeFactor(long number) {
        long prime = number;
        long divisible, divisor;
        divisible = divisor = (long) Math.sqrt(number);
        for (;divisible >= 2;
             divisible = number / divisor,
             divisor++) {
            if (isDivisible(number, divisor)) {
                prime = divisor;
            }
        }
        return prime;
    }

    private static boolean isDivisible(long number, long divisison) {
        return number % divisison == 0;
    }

}

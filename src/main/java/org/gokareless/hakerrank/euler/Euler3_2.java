package org.gokareless.hakerrank.euler;

public class Euler3_2 {

    public static void main(String[] args) {
        long number = 600851475143L;
        System.out.println(findPrimeFactor(number));
    }

    private static long findPrimeFactor(long number) {
        long factor = 2;
        long root = (long) Math.sqrt(number);
        while (factor <= root) {
            if (number % factor == 0) {
                number = number / factor;
                factor = 2;
                root = (long) Math.sqrt(number);
            } else {
                factor += 1;
            }
        }
        return number;
    }

}

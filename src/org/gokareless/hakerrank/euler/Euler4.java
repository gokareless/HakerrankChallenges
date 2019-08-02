package org.gokareless.hakerrank.euler;

public class Euler4 {

    public static void main(String[] args) {
        int number = 800000;
        System.out.println(findNumber(number));
    }

    private static long findNumber(long number) {
        // should be less then given
        number--;
        while (!isPalindrome(number) || !isProductOf3DigitFactors(number)) {
            number--;
        }
        return number;
    }

    private static boolean isPalindrome(long number) {
        String string = String.valueOf(number);
        boolean isPalindrome = true;
        int lastIndex = string.length() - 1;
        for (int index = 0; index < string.length() / 2; index++) {
            isPalindrome = string.charAt(index) == string.charAt(lastIndex - index);
            if(!isPalindrome) {
                break;
            }
        }
        return isPalindrome;
    }

    private static boolean isProductOf3DigitFactors(long number) {
        long factor1 = 999;
        while (factor1 >= 100) {
            if (number % factor1 == 0) {
                long factor2 = number / factor1;
                if (is3Digit(factor2)) {
                    return true;
                }
            }
            factor1 -= 1;
        }
        return false;
    }

    private static boolean is3Digit(long number) {
        return number / 100 >= 1 && number / 1000 < 1;
    }

}

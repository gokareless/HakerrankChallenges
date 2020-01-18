package org.gokareless.hakerrank.java;

public class Palindrome {

    public static void main(String[] args) {
        String string = "aabbbbaa";
        char[] array = string.toCharArray();
        int middle = array.length / 2;
        int i = middle;
        int j = middle;
        if (array.length % 2 == 0)
            i = middle - 1;
        boolean palindrome = true;
        while (i > 0 && j < array.length) {
            if (array[--i] != array[++j]) {
                palindrome = false;
                break;
            }
        }
        String result = palindrome ? "Yes" : "No";
        System.out.println(result);
    }
}

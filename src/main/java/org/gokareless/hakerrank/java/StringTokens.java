package org.gokareless.hakerrank.java;

import java.util.Scanner;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();

        String[] array = !string.trim().isEmpty()
                ? string.trim().split("[\\W|\\s|_]+")
                : new String[0];
        System.out.println(array.length);
        for (String token : array) {
            System.out.println(token);
        }
        scan.close();
    }
}

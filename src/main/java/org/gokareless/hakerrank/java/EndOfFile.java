package org.gokareless.hakerrank.java;

import java.util.Scanner;

public class EndOfFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 1;
        while (sc.hasNext())
            System.out.println(index++ + " " + sc.nextLine());
    }
}


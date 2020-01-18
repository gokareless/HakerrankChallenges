package org.gokareless.hakerrank.java;

import java.util.Scanner;

public class OutputFormat {

    public static void main(String[] args) {
        String str1 = "java";
        int int1 = 50;
        String str2 = "cpp 65";
        String str3 = "python 50";
        System.out.println(String.format("%-15s%03d", str1, int1));
        System.out.println(String.format("%d x %d = %d", 1 , 1, 1));
    }
}

class Solution{
    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");
                if(x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE)
                    System.out.println("* byte");
                if(x >= Short.MIN_VALUE && x <= Short.MAX_VALUE)
                    System.out.println("* short");
                if(x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE)
                    System.out.println("* int");
                System.out.println("* long");
            }
            catch(Exception e) {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }
    }
}
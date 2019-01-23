package org.gokareless.hakerrank.java;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution2 {

    static int B;
    static int H;
    static boolean flag = false;

    static {
        try {
            Scanner sc = new Scanner(System.in);
            B = sc.nextInt();
            H = sc.nextInt();
            if (B <= 0 || H <= 0)
                throw new Exception(": Breadth and height must be positive");
            flag = true;
        } catch (Exception e) {
            System.out.print(e.getClass().getName() + e.getMessage());
        }
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class


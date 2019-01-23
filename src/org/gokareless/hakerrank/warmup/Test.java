package org.gokareless.hakerrank.warmup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Test {

    public static void main(String args[]) {
        int i = (int) Math.ceil(Math.sqrt(8));
        System.out.println(i);
        List<Long> list = Arrays.asList(1l, 2l, 5l);
        System.out.println(Collections.binarySearch(list, 4l));
        System.out.println(Collections.binarySearch(list, 6l));
    }
}

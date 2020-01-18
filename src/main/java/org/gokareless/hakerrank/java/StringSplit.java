package org.gokareless.hakerrank.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSplit {

    public static void main(String[] args) {
        String string = "ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs";
        String[] array = new String[string.length() - 2];
        for (int i = 0; i < array.length; i++) {
            array[i] = string.substring(i, i + 3);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (j != i && array[j].compareTo(array[i]) > 0) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (String str : array)
            System.out.print(str + ", ");
    }
}

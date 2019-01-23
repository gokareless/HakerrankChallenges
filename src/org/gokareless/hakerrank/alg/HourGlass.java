package org.gokareless.hakerrank.alg;

public class HourGlass {

    public static void main(String[] args) {

        int[][] array = {{-1, -1, 0, -9, -2, -2,},
                        {-2, -1, -6, -8, -2, -5},
                        {-1, -1, -1, -2, -3, -4},
                        {-1, -9, -2, -4, -4, -5},
                        {-7, -3, -3, -2, -9, -9},
                        {-1, -3, -1, -2, -4, -5}};
        int result = hourglassSum(array);
        System.out.println(result);
    }
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] array) {
        int maxSum = Integer.MIN_VALUE;
        int right = 6, bottom = 6;
        for (int i = 0; i < right - 2; i++)
            for (int j = 0; j < bottom - 2; j++) {
                int sum = array[i][j] + array[i][j + 1] + array[i][j + 2] +
                        array[i + 1][j + 1] +
                        array[i + 2][j] + array[i + 2][j + 1] + array[i + 2][j + 2];

                maxSum = Math.max(maxSum, sum);
            }
        return maxSum;
    }
}

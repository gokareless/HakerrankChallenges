package org.gokareless.hakerrank.alg;
import java.io.*;
import java.util.*;

public class CountingInversions {

    static long countInversions(int[] array) {
        return mergeSort(array, array.length);
    }

    static long mergeSort(int array[], int size) {
        int temp[] = new int[size];
        return mergeSort(array, temp, 0, size - 1);
    }

    static long mergeSort(int[] array, int[] temp, int left, int right) {
        long swapCount = 0;
        if (right > left) {
            int mid = (right + left) / 2;
            swapCount = mergeSort(array, temp, left, mid);
            swapCount += mergeSort(array, temp, mid + 1, right);
            swapCount += merge(array, temp, left, mid + 1, right);
        }
        return swapCount;
    }

    static long merge(int[] array, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;
        long swapCount = 0;
        while ((i <= mid - 1) && (j <= right)) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            }
            else {
                temp[k++] = array[j++];
                swapCount = swapCount + (mid - i);
            }
        }
        while (i <= mid - 1)
            temp[k++] = array[i++];
        while (j <= right)
            temp[k++] = array[j++];
        for (i = left; i <= right; i++)
            array[i] = temp[i];
        return swapCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        long result = countInversions(arr);
        System.out.println(result);
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }
}
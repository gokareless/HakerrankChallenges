package org.gokareless.hakerrank.alg;

public class MatrixProcessing {
    int[][] input1 = {
            {3, 2, 3, 0},
            {2, 0, 1, 0},
            {4, 9, 1, 1},
            {0, 2, 1, -44}
    };
    int[][] input2 = {
            {3, 2, 1, 0},
            {2, 0, 9, 0},
            {4, 9, 1, 1},
            {9, 2, 3, -44}
    };
    int[][] input3 = {
            {3, 2, 1, 0},
            {2, 0, 10, 0},
            {4, 1, 1, 1},
            {0, 2, 3, -44}
    };
    int[][] input4 = {
            {3, 2, 1, 0},
            {2, 3, 1, 0},
            {4, 9, 3, 1},
            {0, 2, 2, -44}
    };
    int[][] input5 = {
            {3, 2, 3, 3},
            {1, 1, 10, 10},
            {4, 9, 1, 1},
            {0, 2, 3, -44}
    };
    int[][] input6 = {
            {3, 2, 1, 0},
            {2, 0, 1, 0},
            {4, 9, 2, 1},
            {0, 2, 2, -44}
    };

    public static void main(String[] args) {
        MatrixProcessing mp = new MatrixProcessing();
        System.out.println(analyzeMatrix(mp.input1));
        System.out.println(analyzeMatrix(mp.input2));
        System.out.println(analyzeMatrix(mp.input3));
        System.out.println(analyzeMatrix(mp.input4));
        System.out.println(analyzeMatrix(mp.input5));
        System.out.println(analyzeMatrix(mp.input6));
    }

    public static boolean analyzeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int element = matrix[i][j];
                if (hasMatches(matrix, element, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasMatches(int[][] matrix, int element, int eli, int elj) {
        return hasRowMatch(matrix, element, eli, elj)
                || hasColumnMatch(matrix, element, eli, elj)
                || hasDiagonalMatch(matrix, element, eli, elj);
    }
    private static boolean hasRowMatch(int[][] matrix, int element, int eli, int elj) {
        return (eli + 2 < matrix.length
                && matrix[eli + 1][elj] == element
                && matrix[eli + 2][elj] == element);
    }
    private static boolean hasColumnMatch(int[][] matrix, int element, int eli, int elj) {
        return (elj + 2 < matrix.length
                && matrix[eli][elj + 1] == element
                && matrix[eli][elj + 2] == element);
    }
    private static boolean hasDiagonalMatch(int[][] matrix, int element, int eli, int elj) {
        return (eli + 2 < matrix.length && elj + 2 < matrix.length
                && matrix[eli + 1][elj + 1] == element
                && matrix[eli + 2][elj + 2] == element)
                ||
                (elj - 2 >= 0 && eli + 2 < matrix.length
                && matrix[eli + 1][elj - 1] == element
                && matrix[eli + 2][elj - 2] == element);
    }
}

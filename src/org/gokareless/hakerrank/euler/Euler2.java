package org.gokareless.hakerrank.euler;

public class Euler2 {

    public static void main(String[] args) {
        long topBorder = 100;
        long sum = findFibonacciEvenNumbersSum(topBorder);
        System.out.println(sum);
    }

    private static long findFibonacciEvenNumbersSum(long border) {
        Pair pair = findFibonacciTopPair(border);
        if (isEven(pair.getLeft())) {
            pair.fincrement(1);
            return pair.getRight() / 2;
        } else if (isEven(pair.getRight())) {
            pair.fincrement(2);
            return pair.getRight() / 2;
        } else {
            return pair.getRight() / 2;
        }
    }

    private static Pair findFibonacciTopPair(long border) {
        Pair pair = Pair.of(1, 1);
        while (pair.fincrement(border)) ;
        return pair;
    }

    static boolean isEven(long number) {
        return number % 2 == 0;
    }

    static class Pair {
        long left;
        long right;
        long sum;

        private Pair(long left, long right) {
            this.left = left;
            this.right = right;
            this.sum = left + right;
        }

        static Pair of(long left, long right) {
            return new Pair(left, right);
        }

        boolean fincrement(long border) {
            if (left + right <= border) {
                fincrement();
                return true;
            }
            return false;
        }

        void fincrement(int times) {
            for (int i = 0; i < times; i++)
                fincrement();
        }

        private void fincrement() {
            this.left = right;
            this.right = sum;
            this.sum = left + right;
        }


        long getLeft() {
            return this.left;
        }

        long getRight() {
            return this.right;
        }
    }
}

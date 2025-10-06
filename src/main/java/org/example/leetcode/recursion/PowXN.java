package org.example.leetcode.recursion;

public class PowXN {

//    public double myPow(double x, int n) {
//        if (n == 0) return 1;
//        double absX = Math.abs(x);
//        if (absX == 1d) return x > 0 || n % 2 == 0 ? absX : x;
//        if (n == Integer.MIN_VALUE) return 0;
//        double r = 1;
//        boolean inf = false;
//        int rightStop = absX > 1 && n > 0 || absX < 1 && n < 0 ? 10000 : 100000;
//        for (int i = 0; i < Math.abs(n); i++) {
//            if (r > rightStop || r < -rightStop || r * 100000 == 0) {
//                inf = true;
//                break;
//            }
//            r *= x;
//        }
//        if (inf) return 0;
//        return n < 0 ? 1 / r : r;
//    }

    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }

    private double binaryExp(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1.0 / binaryExp(x, -n);
        }
        if (n % 2 == 1) {
            return x * binaryExp(x * x, (n - 1) / 2);
        } else {
            return binaryExp(x * x, n / 2);
        }
    }

}

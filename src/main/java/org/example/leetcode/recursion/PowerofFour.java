package org.example.leetcode.recursion;

public class PowerofFour {

    public boolean isPowerOfFour(int n) {
        return n == 1 || n != 0 && n % 4 == 0 && (n / 4 == 1 || isPowerOfFour(n / 4));
    }

}

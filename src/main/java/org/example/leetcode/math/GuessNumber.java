package org.example.leetcode.math;

public class GuessNumber {

    public static void main(String[] args) {
        System.out.println(guessNumber(2126753390));
    }

    public static int guessNumber(int n) {
        int leftN = 1, rightN = n, peekNum;
        while (leftN <= rightN) {
            peekNum = Long.valueOf(((long) rightN + (long) leftN) / 2).intValue();
            int guess = guess(peekNum);
            if (guess == 0) return peekNum;
            else if (guess > 0) {
                leftN = peekNum + 1;
            } else if (guess < 0) {
                rightN = peekNum - 1;
            }
        }
        throw new IllegalArgumentException();
    }

    private static int guess(int num) {
        return Integer.compare(1702766719, num);
    }


}

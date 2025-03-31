package org.example.leetcode.math;

import java.util.Stack;

public class BasicCalculatorII {

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(new BasicCalculatorII().calculate(s));
    }

    public int calculate(String s) {
        int number = 0;
        char operator = ' ';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isSpaceChar(c) && i != s.length() - 1) continue;

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
                if (i != s.length() - 1) continue;
            }

            switch (operator) {
                case '-' -> stack.push(-number);
                case '*' -> stack.push(stack.pop() * number);
                case '/' -> stack.push(stack.pop() / number);
                default -> stack.push(number);
            }
            operator = c;
            number = 0;
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

}

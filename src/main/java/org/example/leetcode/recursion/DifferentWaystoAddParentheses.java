package org.example.leetcode.recursion;

import java.util.LinkedList;
import java.util.List;

public class DifferentWaystoAddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> r = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char opCh = expression.charAt(i);
            if (opCh != '-' && opCh != '*' && opCh != '+') {
                continue;
            }
            String partLeft = expression.substring(0, i);
            String partRight = expression.substring(i + 1);
            List<Integer> partLeftR = diffWaysToCompute(partLeft);
            List<Integer> partRightR = diffWaysToCompute(partRight);
            for (Integer p1 : partLeftR) {
                for (Integer p2 : partRightR) {
                    int c = switch (opCh) {
                        case '+' -> p1 + p2;
                        case '-' -> p1 - p2;
                        case '*' -> p1 * p2;
                        default -> 0;
                    };
                    r.add(c);
                }
            }
        }
        if (r.isEmpty()) {
            r.add(Integer.valueOf(expression));
        }
        return r;
    }


}

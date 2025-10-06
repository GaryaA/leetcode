package org.example.leetcode.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DifferentWaystoAddParenthesesTest {

    private DifferentWaystoAddParentheses obj = new DifferentWaystoAddParentheses();

    @Test
    void diffWaysToCompute() {
        Assertions.assertEquals(List.of(0, 2), obj.diffWaysToCompute("2-1-1").stream().sorted().toList());
    }

    @Test
    void diffWaysToCompute1() {
        Assertions.assertEquals(List.of(-34, -14, -10, -10, 10), obj.diffWaysToCompute("2*3-4*5").stream().sorted().toList());
    }

}
package org.example.leetcode.recursion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CountGoodNumbersTest {

    private CountGoodNumbers obj = new CountGoodNumbers();

    @Test
    void countGoodNumbers() {
        Assertions.assertThat(obj.countGoodNumbers(1)).isEqualTo(5);
    }

    @Test
    void countGoodNumbers1() {
        Assertions.assertThat(obj.countGoodNumbers(4)).isEqualTo(400);
    }

    @Test
    void countGoodNumbers2() {
        Assertions.assertThat(obj.countGoodNumbers(50)).isEqualTo(564908303);
    }
}
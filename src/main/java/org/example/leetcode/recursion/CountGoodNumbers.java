package org.example.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class CountGoodNumbers {

    private final static int[] EVEN_DIGITS = {0, 2, 4, 6, 8};
    private final static int[] PRIME_DIGITS = {2, 3, 5, 7};

    private Map<Long, Integer> cache = new HashMap<>();

    public int countGoodNumbers(long n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 1) {
            return 5;
        }
        if (n == 2) {
            return 20;
        }
        int count = 1;
        for (long i = 3; i <= n; i++) {
            count *= countGoodNumbers(i - 1) * (i % 2 == 0 ? 5 : 4);
            cache.put(i - 1, count);
        }
        return count;

    }

}

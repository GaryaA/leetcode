package org.example.leetcode.slidingwindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] nums = {2147483647, 1, 2, 3, 4, 5, 6, 7, 2147483647};
        int k = 2;

        System.out.println(Arrays.toString(new SlidingWindowMedian().medianSlidingWindow(nums, k)));
    }

    private final TreeSet<Holder> leftSet = new TreeSet<>(
            Comparator.<Holder>comparingInt(h -> h.value)
                    .reversed()
                    .thenComparing(h -> h.idx)
    );
    private final TreeSet<Holder> rightSet = new TreeSet<>(
            Comparator.<Holder>comparingInt(h -> h.value)
                    .thenComparing(h -> h.idx)
    );

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            pushMedian(new Holder(nums[i], i));
        }
        result[0] = peekMedian(k);

        int windowEnd = k, j = 1;
        for (; windowEnd < nums.length; windowEnd++) {
            pushMedian(new Holder(nums[windowEnd], windowEnd));
            removeOutOfWindowElem(new Holder(nums[windowEnd - k], windowEnd - k));
            result[j++] = peekMedian(k);
        }
        return result;
    }

    private void removeOutOfWindowElem(Holder e) {
        if (!leftSet.remove(e)) rightSet.remove(e);
        rebalance();
    }

    private void pushMedian(Holder h) {
        if (leftSet.isEmpty()) {
            leftSet.add(h);
            return;
        }
        if (rightSet.isEmpty()) {
            if (h.value > leftSet.first().value) {
                rightSet.add(h);
            } else {
                rightSet.add(leftSet.pollFirst());
                leftSet.add(h);
            }
            return;
        }
        if ((long) h.value < (long) leftSet.first().value) {
            leftSet.add(h);
        } else if ((long) h.value > (long) rightSet.first().value) {
            rightSet.add(h);
        } else {
            leftSet.add(h);
        }
        rebalance();
    }

    private void rebalance() {
        while (leftSet.size() > rightSet.size() + 1) {
            rightSet.add(leftSet.pollFirst());
        }
        while (rightSet.size() > leftSet.size()) {
            leftSet.add(rightSet.pollFirst());
        }
    }

    private double peekMedian(int k) {
        return k % 2 != 0 ?
                leftSet.first().value :
                ((long) rightSet.first().value + (long) leftSet.first().value) / 2.0;
    }

    private record Holder(int value, int idx) {
    }

}

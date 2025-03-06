package slidingwindow;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 2, 3, 1, 4, 2};
        int k = 3;

        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }

    private static final Queue<Holder> qDesc = new PriorityQueue<>(Comparator.<Holder>comparingInt(a -> a.value).reversed());
    private static final Queue<Holder> qAsc = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
    private static Integer countOutElemsQDesc = 0;
    private static Integer countOutElemsQAsc = 0;

    public static double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            pushMedian(new Holder(nums[i], i));
        }
        result[0] = peekMedian(k);

        int windowEnd = k, j = 1;
        for (; windowEnd < nums.length; windowEnd++) {
            removeOutOfWindowElem(new Holder(nums[windowEnd - k], windowEnd - k));
            pushMedian(new Holder(nums[windowEnd], windowEnd));
            result[j++] = peekMedian(k);
        }
        return result;
    }

    private static void removeOutOfWindowElem(Holder e) {
        boolean removed = false;

        while (!qDesc.isEmpty() && qDesc.peek().idx <= e.idx) {

            if (qDesc.peek().idx != e.idx) countOutElemsQDesc--;
            else removed = true;

            qDesc.poll();
        }
        while (!qAsc.isEmpty() && qAsc.peek().idx <= e.idx) {

            if (qAsc.peek().idx != e.idx) countOutElemsQAsc--;
            else removed = true;

            qAsc.poll();
        }
        rebalanceQ();

        if (!removed) {
            if (e.value < qDesc.peek().value) countOutElemsQDesc++;
            else if (e.value > qAsc.peek().value) countOutElemsQAsc++;
        }
    }

    private static void pushMedian(Holder h) {
        if (qDesc.isEmpty()) {
            qDesc.add(h);
            return;
        }
        if (qAsc.isEmpty()) {
            qAsc.add(h);
            return;
        }
        if (h.value < qDesc.peek().value) {
            qDesc.add(h);
        } else if (h.value > qAsc.peek().value) {
            qAsc.add(h);
        } else {
            qDesc.add(h);
        }
        rebalanceQ();
    }

    private static void rebalanceQ() {
        while (qDesc.size() > qAsc.size() + 1) {
            qAsc.add(qDesc.poll());
        }
        while (qAsc.size() > qDesc.size()) {
            qDesc.add(qAsc.poll());
        }
    }

    private static double peekMedian(int k) {
        return k % 2 != 0 ?
                countOutElemsQDesc > countOutElemsQAsc ?
                        qAsc.peek().value :
                        qDesc.peek().value : (qAsc.peek().value + qDesc.peek().value) / 2.0;
    }

    private static class Holder {
        int value;
        int idx;

        public Holder(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

}

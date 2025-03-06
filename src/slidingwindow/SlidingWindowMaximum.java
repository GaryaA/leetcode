package slidingwindow;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {

    public static void main(String[] args) throws Exception {
        {
            String arrStr = Files.readAllLines(Path.of(SlidingWindowMaximum.class.getResource("/slidingwindowsmaxnums.txt").toURI())).get(0);
            arrStr = arrStr.replace("[", "").replace("]", "");
            int[] nums = Arrays.stream(arrStr.split(",")).mapToInt(Integer::parseInt).toArray();
            int k = 50000;
            long start = System.currentTimeMillis();
            maxSlidingWindow(nums, k);
            System.out.println(System.currentTimeMillis() - start + "ms");
        }
        {
            int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
            int k = 5;
            System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        Queue<Holder> pq = new PriorityQueue<>(Comparator.<Holder>comparingInt(h -> h.value).reversed());

        for (int i = 0; i < k; i++) {
            pq.add(new Holder(nums[i], i));
        }
        result[0] = pq.peek().value;

        for (int windowStart = k, windowEnd = k, j = 1; windowEnd < nums.length; windowEnd++) {
            pq.add(new Holder(nums[windowEnd], windowEnd));
            while (pq.peek().idx <= windowEnd - k) {
                pq.poll();
            }
            result[j++] = pq.peek().value;
        }
        return result;

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

package slidingwindow;

public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {

        int[] nums = {0, 0, 0, 0};
        int k = 0;

        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        int maxCount = 0;
        int countOnes = 0;
        int windowStart = 0;
        int windowEnd = 0;

        for (; windowEnd < nums.length; windowEnd++) {
            int num = nums[windowEnd];
            if (num == 1) {
                countOnes++;
                maxCount = Math.max(maxCount, countOnes);
            }
            if (windowEnd - windowStart + 1 > k + maxCount) {
                if (nums[windowStart] == 1) countOnes--;
                windowStart++;
            }
        }
        return windowEnd - windowStart;
    }

}

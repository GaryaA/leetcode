package arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 5};
        int target = 5;
        System.out.println(search(nums, target));

    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, peekId;
        while (left <= right) {
            peekId = (right + left) / 2;
            if (nums[peekId] > target) {
                right = peekId - 1;
            } else if (nums[peekId] < target) {
                left = peekId + 1;
            } else {
                return peekId;
            }

        }
        return -1;
    }

}

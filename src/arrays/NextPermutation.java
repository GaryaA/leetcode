package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static utils.Utils.switchElems;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        boolean permuted = false;
        LinkedList<Integer> sortedList = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums.length - 2; i >= 0; i--) {
            map.put(nums[i + 1], i + 1);
            insertToSortedArray(sortedList, nums[i + 1]);

            if (nums[i] < nums[i + 1]) {
                int insertIdx = insertToSortedArray(sortedList, nums[i]);
                switchElems(nums, i, map.getOrDefault(sortedList.get(insertIdx + 1), i + 1));
                Arrays.sort(nums, i + 1, nums.length);
                permuted = true;
                break;
            }
        }
        if (!permuted) {
            Arrays.sort(nums, 0, nums.length);
        }
    }

    public static int insertToSortedArray(LinkedList<Integer> sortedList, int target) {
        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i) > target) {
                sortedList.add(i, target);
                return i;
            }
        }
        sortedList.add(target);
        return sortedList.size() - 1;
    }


}

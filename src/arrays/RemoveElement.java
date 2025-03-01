package arrays;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(Arrays.toString(nums));
        System.out.println(removeElement1(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int[] rArr = new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                rArr[k++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(rArr));
        return k;
    }

    public static int removeElement1(int[] nums, int val) {
        for (int i = 1, j = 1; i < nums.length; i++) {
            if (nums[i - j] == val) {
                if (nums[i] != val) {
                    int temp = nums[i - j];
                    nums[i - j] = nums[i];
                    nums[i] = temp;
                } else {
                    j++;
                }
            } else {
                j = 1;
            }
        }
        int k = 0;
        for (; k < nums.length; k++) {
            if (nums[k] == val) {
                break;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

}

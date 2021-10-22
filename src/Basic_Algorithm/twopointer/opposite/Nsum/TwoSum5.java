package Basic_Algorithm.twopointer.opposite.Nsum;

import java.util.Arrays;

public class TwoSum5 {
    /*
    * Given an integer array, find pairs # whose sum <= target
    * 两数和-小于或等于目标值
    * Solution 1: Brute force find all combination
    * Solution 2: Sort + two pointers -> if left + right < target then [left, right] will all < target
    * 2 7 11 15
    * ^       ^
    * */
    public int twoSum5(int[] nums, int target) {
        if(nums==null || nums.length<2) {
            return 0;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int pairsCount = 0;

        while(left < right) {
            if(nums[left] + nums[right] <= target) {
                left++;
                pairsCount += right - left;
            } else {
                right--;
            }
        }

        return pairsCount;

    }


    public static void main(String[] args) {

    }
}

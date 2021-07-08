package twopointer.opposite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    /*
    * Find two number sum == target in a unsorted array
    * Solution 1: Time O(n), Space O(n) : Hash Map -> Two Sum, Key: Target - Number; Value: Number
    * Solution 2: Time O(nlogn), Space O(1) : Sort + two pointer -> 不能返回index可以O(1)但是如果返回index，那需要把index和数组一起排序
    * !!! if unsorted two sum, Solution 1 is the best solution
    * */

    public int[] twoSum(int[] numbers, int target){
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        for(int idx=0; idx<numbers.length; idx++) {
            if(sumMap.containsKey(numbers[idx])) {
                int[] result = new int[] {sumMap.get(numbers[idx]), idx};
                return result;
            }
            sumMap.put(target-numbers[idx], idx);
        }
        return new int[] {};
    }

    public int[] twoSumTwoPointers(int[] numbers, int target) {
        if(numbers==null || numbers.length<2) {
            return new int[] {};
        }

        int left = 0;
        int right = numbers.length;
        Arrays.sort(numbers);

        while(left < right) {
            if(numbers[left] + numbers[right] < target) {
                left++;
            } else if(numbers[left] + numbers[right] > target) {
                right--;
            } else {
                return new int[] {left, right};
            }
        }

        return new int[] {};
        }


}

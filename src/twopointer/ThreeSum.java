package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(numbers==null && numbers.length<3) {
            return list;
        }
        Arrays.sort(numbers);
        // to avoid duplicate result, element behind will never use element in front
        // so last scan element index should be nums.length-3
        for(int i=0; i<numbers.length-2;i++) {
            if(i-1>=0 && numbers[i]==numbers[i-1]) {
                continue;
            }

            int target = -numbers[i];
            find_two_sum(numbers, i+1, target, list);

        }
        System.out.println(list);
        return list;

    }

    public void find_two_sum(int[] nums, int pin, int target ,List<List<Integer>> list) {
        int left = pin;
        int right = nums.length - 1;

        while(left<right) {
            if(nums[left]+nums[right]==target) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[left]);
                result.add(nums[right]);
                result.add(-target);
                list.add(result);
                left++;
                right--;

                //ignore duplicate
                while(left<right && nums[left]==nums[left-1]) {
                    left++;
                }

                while(left<right && nums[right]==nums[right+1]) {
                    right--;
                }
            } else if(nums[left]+nums[right]>target) {
                right--;
            } else left++;
        }
    }

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        int[] nums= {-1,1,0};
        obj.threeSum(nums);

    }
}

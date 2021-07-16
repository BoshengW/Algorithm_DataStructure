package binary_search;

public class BinarySearchTemplate {

    public int binarySearch(int[] nums, int target) {
        if(nums==null || nums.length==0) {
            return -1;
        }

        int start = 0, end = nums.length-1;

        while(start + 1<end) {
            int mid = start + (end - start)/2; // avoid start + end -> exceed int bit limit

            // this part need to adjust based on different questions
            if(nums[mid]<target) {
                start = mid;
            } else if(nums[mid]>target) {
                end = mid;
            } else {
                end = mid;
            }
        }

        /*
        * Below part also need to adjust for choose start or end
        * */
        if(nums[start] == target) {
            return start;
        }

        if(nums[end] == target) {
            return end;
        }

        return -1;
    }
}

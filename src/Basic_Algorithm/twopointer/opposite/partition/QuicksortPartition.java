package Basic_Algorithm.twopointer.opposite.partition;

public class QuicksortPartition {
    /**
     * This class shows partition template for quick Basic_Algorithm.sort
     * */
    public void partitonTemplate(int[] unsortArray, int pivot) {
        int left = 0;
        int right = unsortArray.length-1;
        /**
         * Why we need left<=right
         * since if you break when left == right, you need to check nums[left]>=pivot or <pivot to make sure start index for next partition
         * if not to do this, will cause stackoverflow, so left<=right will be more safe
         * */
        /**
         * when left>right 有两种情况
         * 1.  i j  -> j i => j = i-1
         *     | |
         * 2.  i * j ->  j+1 = i-1 => j = i-2
         * */
        while(left<=right) {
            while(left<=right && unsortArray[left]<pivot) {
                left++;
            }

            while(left<=right && unsortArray[right]>=pivot) {
                right--;
            }
            if(left<=right) {
                int temp = unsortArray[left];
                unsortArray[left] = unsortArray[right];
                unsortArray[right] = temp;
                left++;
                right--;
            }

        }
    }
}

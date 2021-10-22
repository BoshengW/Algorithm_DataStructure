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

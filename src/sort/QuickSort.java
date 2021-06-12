package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    /*
    * Time Complexity: 平均时间复杂度O(nlogn), Worst Complexity: O(n^2) (each partition only split 1 element in one side)
    * Space Complexity: O(logn), if using recursion for stack, but logn space is very small.
    * 不稳定排序，无法保证原先顺序 1，1，2，2*， 先整体有序再局部有序，通过pivot将整体分成相对有序的两部分再分治来是两边有序
    * How to get a pivot from array
    * 1. always use the first element
    * 2. always use the last element
    * 3. use random index
    * 4. use median index
    * */
    private Random rand = new Random();

    public int[] getPartitionIndex(int[] temp, int start, int end, int pivot) {

        int left = start;
        int right = end;

        while(left<=right) {

            while(left<=right && temp[left] < pivot) {
                left++;
            }

            while(left<=right && temp[right] > pivot) {
                right--;
            }

            if(left<=right) {
                int _temp = temp[left];
                temp[left] = temp[right];
                temp[right] = _temp;

                left++;
                right--;
            }
        }

        /*
        * !!! after while loop, left will > right index, which mean left, right must swap after partition
        *
        * o o o o o
        *   |   |
        * left right
        * */

        int[] indexPair = {left, right};
        return indexPair;

    }

    private void partition(int[] temp, int start, int end) {

        if(start >= end) {
            return;
        }

        // get a random index
        int randIdx = rand.nextInt(end-start+1) + start;

        int[] indexPair = getPartitionIndex(temp, start, end, temp[randIdx]);

        int left = indexPair[1]; // prev-right index swap to new left index
        int right = indexPair[0]; // prev-left index swap to new right index

        partition(temp, start, left);
        partition(temp, right, end);
    }

    public void quickSort(int[] target) {
        partition(target, 0, target.length-1);

    }


    public static void main(String[] args) {
        int[] target = {5,1,12,-5,16};

        QuickSort obj = new QuickSort();
        obj.quickSort(target);
        System.out.println(Arrays.toString(target));
    }

}

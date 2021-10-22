package Basic_Algorithm.sort;

import java.util.Arrays;

public class MergeSort {
    /*
    * Merge Sort Best & Worse Time Complexity: O(nlogn) - Space Complexity: O(n)
    * 稳定排序 - 先局部有序然后整体有序 - 把局部序列排序最后是全局有序
    * */


    public int[] mergeSort(int[] target) {

        int[] temp = new int[target.length];
        mergetSorthelper(temp, target, 0, target.length-1);

        return temp;
    }

    private void mergetSorthelper(int[] temp, int[] target, int start, int end) {


        if(start>=end) {
            return;
        }
        int mid = (end + start)/2;
        mergetSorthelper(temp, target, start, mid);
        mergetSorthelper(temp, target, mid+1, end);
        merge(temp, start, mid, end, target);

    }

    private void merge(int[] temp, int start, int mid, int end, int[] target) {

        int idx1 = start;
        int idx2 = mid+1;
        int idx3 = start;

        while(idx1 <= mid && idx2 <= end) {
            if(target[idx1] <= target[idx2]) {
                temp[idx3] = target[idx1];
                idx1++;
            } else {
                temp[idx3] = target[idx2];
                idx2++;
            }
            idx3++;

        }
        // if idx1 or idx2 not reach the end, then put all element in last of temp

        while(idx1 <= mid) {
            temp[idx3] = target[idx1];
            idx1++;
            idx3++;
        }

        while(idx2 <= end) {
            temp[idx3] = target[idx2];
            idx2++;
            idx3++;
        }

    }


    public static void main(String[] args) {

        int[] a = {1,2,3,4};
        int[] b = {2,4,5,6};

        int[] target = {5,1,12,-5,16};


        MergeSort obj = new MergeSort();
        int[] c = obj.mergeSort(target);
        System.out.println(Arrays.toString(c));
    }
}

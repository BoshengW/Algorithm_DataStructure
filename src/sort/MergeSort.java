package sort;

import java.util.Arrays;

public class MergeSort {

    public int[] merge2SortArrays(int[] array1, int[] array2) {
        int length_arr1 = array1.length;
        int length_arr2 = array2.length;

        int[] arr_merge = new int[length_arr1 + length_arr2];

        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        while(idx1 < length_arr1 && idx2 < length_arr2) {
            if (array1[idx1] <= array2[idx2]) {
                arr_merge[idx3] = array1[idx1];
                idx1++;
            } else {
                arr_merge[idx3] = array2[idx2];
                idx2++;
            }
            idx3++;
        }

        if(idx1<length_arr1) {
            for(int i=idx1; i<length_arr1; i++) {
                arr_merge[idx3] = array1[i];
                idx3++;
            }
            return arr_merge;
        }


        if(idx2<length_arr1) {
            for(int i=idx2; i<length_arr2; i++) {
                arr_merge[idx3] = array2[i];
                idx3++;
            }
            return arr_merge;
        }

        return arr_merge;
    }


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

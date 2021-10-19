package sort;

import java.util.Arrays;

public class QuickSortTemplate {

    private void quicksort(int[] A, int l, int r) {
        if(l>=r) return;

        // find pivot and clean the array
        // left <= pivot, right >= pivot
        int pivot = A[l + (r - l>>1)];
        int i=l, j=r;
        while(i<=j) {
            // find idx from left - >=pivot (points should belong to right)
            while(i<=j && A[i]<pivot) i++;
            while(i<=j && A[j]>pivot) j--;
            if(i<=j) {
                // if still l<=r which mean find the issue point -> swap
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++; j--;
            }
        }
        // outside the loop i -> in right side, j-> left side
        // if we end loop when i==j, sometime will face dead loop issue
        quicksort(A, l, j);
        quicksort(A, i, r);
    }

    public static void main(String[] args) {
        int[] testcase = {5,4,1,2,3};
        QuickSortTemplate obj = new QuickSortTemplate();
        obj.quicksort(testcase, 0, testcase.length-1);
        System.out.println(Arrays.toString(testcase));

    }
}

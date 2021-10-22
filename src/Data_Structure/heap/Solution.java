package Data_Structure.heap;

import java.util.Arrays;

public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    // 利用堆排序
    public void sortIntegers2(int[] A) {
        // write your code here
//        for(int i=(A.length-1)/2; i>=0; i--) {
//            shiftdown(A, i);
//        }

        for(int i=0; i<A.length; i++) {
            shiftup(A, i);
        }
    }

    private void shiftup(int[] A, int k) {
        while(k!=0) {
            int i = (k-1)/2;
            if(A[i]>A[k]) {
                int temp = A[i];
                A[i] = A[k];
                A[k] = temp;
            }
            k = i;
        }
    }

    private void shiftdown(int[] A, int k) {
        while(k*2+1<A.length) {
            int son = k*2+1;

            if(son+1<A.length && A[son+1]<A[son]) {
                son = son + 1; // 右边若更小切换到右边
            }

            if(A[son]>A[k]) {
                //最小的比k大则不换
                break;
            }

            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }

    public static void main(String[] args) {
        int[] testcase = {3,2,1,4};
        Solution obj = new Solution();
        obj.sortIntegers2(testcase);

        System.out.println(Arrays.toString(testcase));
    }
}
package sort;

import java.util.Arrays;

/**
 * this heapsort is ascending order - maxHeap
 * if descending order need to make it as minHeap
 * */
public class HeapSort {

    private void heapSort(int[] A) {
        //heapify
        heapify(A);

        // loop max Heap put curr Max into end of array
        for(int i=A.length-1; i>=0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            shiftdown(A, 0, i);
        }
    }

    private void heapify(int[] A) {
        for(int i=(A.length-1)/2; i>=0; i--) {
            // 从倒数第二层开始，每一个节点向下比较找到其相对位置
            shiftdown(A, i, A.length);
        }
    }

    private void shiftdown(int[] A, int l, int r) {
        // shift current node with it down stream
        while(l*2 + 1 < r) {
            int son = l*2+1;
            if(l*2+2<r && A[l*2+2]>A[son]) {
                // max heap check with max of children
                son = l*2 + 2;
            }

            if(A[son] < A[l]) {
                // even max of children is smaller than parent then no need to check return
                break;
            }

            // if son is larger than parent then switch
            int temp = A[l];
            A[l] = A[son];
            A[son] = temp;
            l = son;
        }
    }

    public static void main(String[] args) {
        int[] testcase = {5,4,1,2,3};
        HeapSort obj = new HeapSort();
        obj.heapSort(testcase);

        System.out.println(Arrays.toString(testcase));
    }
}

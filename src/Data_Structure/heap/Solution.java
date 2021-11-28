package Data_Structure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

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

    class Sample {
        int val;
        int time;

        public int getVal(){
            return this.val;
        }
    }

    public static void main(String[] args) {
        // Default heap - min Heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(10);
        heap.add(5);
        heap.add(-1);
        System.out.println(heap.peek());

        // make a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (x, y) -> {return y-x;}
        );

        // make a max heap
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>(
                (x, y) -> y.compareTo(x)
        );

        maxHeap2.add(10);
        maxHeap2.add(5);
        maxHeap2.add(-1);
        System.out.println(maxHeap2.peek());

        PriorityQueue<Sample> heap3 = new PriorityQueue<>(
                (Sample x, Sample y) -> y.val - x.val
        );
    }
}
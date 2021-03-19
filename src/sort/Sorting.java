package sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Sorting {

    public void bubbleSort(int[] target){

        int length = target.length;
        boolean sorted_flag = true;
        int i = 0;

        while(sorted_flag) {
            sorted_flag = false;

            // every loop put maximum into last index
            for(int j=0; j<length-i-1;j++) {
                // if current element large swap
                if(target[j] > target[j+1]) {
                    int temp = target[j];
                    target[j] = target[j+1];
                    target[j+1] = temp;

                    // Optimization: if we can check if array is sorted then
                    sorted_flag = true; // if sort operation happen in this loop, then change sorted_flag = true
                }
            }
            i++;
        }



    }

    public void insertSort(int[] target) {
        int length = target.length;

        // each loop add new element into sort array
        for(int i=0; i<length; i++) {
            for(int j=i; j>0; j--) {
                // check new element with sort array, and insert from end to head one by one.
                if(target[j-1] > target[j]) {
                    int temp = target[j];
                    target[j] = target[j-1];
                    target[j-1] = temp;
                }
            }
        }

    }

    public void selectSort(int[] target) {
        // each loop find minimum value in sub-array, and swap position
        int length = target.length;

        for(int i=0; i<length; i++) {
            int miniIndex = i;

            for(int j=i; j<length; j++) {
                if(target[j] < target[miniIndex]) {
                    miniIndex = j;
                }
            }

            int temp = target[miniIndex];
            target[miniIndex] = target[i];
            target[i] = temp;

        }

    }

    public void mergesort(int[] target) {

    }


    public static void main(String[] args) {

        Sorting obj = new Sorting();
        int[] target = {5,1,12,-5,16};

        System.out.println(Arrays.toString(target));
        obj.selectSort(target);
        System.out.println(Arrays.toString(target));

    }
}

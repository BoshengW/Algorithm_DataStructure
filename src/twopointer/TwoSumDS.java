package twopointer;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSumDS {
    /*
    * Design a Two Sum data structure
    * Operation:
    *   1. add() -> add element into list
    *   2. find(int target) -> find if any two element sum exists
    * Solution:
    *  1. Add with List + find with two pointers
    *  2. Add with Hashmap(num, freq) + find with Hashmap
    *
    *
    */
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;

    public TwoSumDS() {
        this.list = new ArrayList<Integer>();
        this.map = new HashMap<>();
    }

    public void addByList(int val) {
        this.list.add(val);
        int index = this.list.size() - 1;
        // swap val into right location - scending order
        while(index>0 && this.list.get(index) < this.list.get(index-1)) {
            int temp = list.get(index);
            list.set(index, this.list.get(index-1));
            list.set(index-1, temp);

            index--;
        }

    }

    public boolean findByTwoPointers(int target) {
        int start = 0, end = this.list.size()-1;
        while(start<=end) {
            if(this.list.get(start) + this.list.get(end) < target) {
                start++;
            } else if(this.list.get(start) + this.list.get(end) > target) {
                end--;
            } else {
                return true;
            }
        }
        return false;
    }

    public void addByHashmap(int number) {
        this.map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean findByHashmap(int value) {
        for(Integer key: this.map.keySet()) {
            int rest = value - key;
            if(rest == key && this.map.get(rest)>=2) {
                return true;
            }

            if(rest!=key && this.map.containsKey(rest)) {
                return true;
            }
        }
        return false;
    }

}

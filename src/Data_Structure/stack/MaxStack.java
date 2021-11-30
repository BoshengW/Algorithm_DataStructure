package Data_Structure.stack;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

public class MaxStack {
    PriorityQueue<Integer> heap;
    Stack<Integer> stk;
    HashSet<Integer> set;
    public MaxStack() {
        // do intialization if necessary
        // max heap
        heap = new PriorityQueue<>((x,y) -> y-x);
        stk = new Stack<>();
        set = new HashSet<>();

    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int x) {
        // write your code here
        stk.push(x);
        heap.add(x);
    }

    public int pop() {
        // write your code here
        // heap save global max not need to pop
        while(set.contains(stk.peek())) {
            stk.pop();
        }

        set.add(stk.peek());
        return stk.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        while(set.contains(stk.peek())) {
            stk.pop();
        }
        return stk.peek();
    }

    /*
     * @return: An integer
     */
    public int peekMax() {
        // write your code here
        while(set.contains(heap.peek())) {
            heap.poll();
        }
        return heap.peek();
    }

    /*
     * @return: An integer
     */
    public int popMax() {
        // write your code here
        while(set.contains(heap.peek())) {
            heap.poll();
        }

        set.add(heap.peek());
        return heap.poll();

    }

    public static void main(String[] args) {
        MaxStack obj = new MaxStack();
        obj.push(5);
        obj.push(1);
        obj.push(5);
        obj.top();
        obj.popMax();
        obj.top();
        obj.peekMax();
        obj.pop();
        obj.top();
    }
}

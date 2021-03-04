package stack;

import java.util.ArrayList;
import java.util.List;

public class StackByArray<T> {
    private List<T> list;

    public StackByArray() {
        this.list = new ArrayList<T>();
    }

    public T top() {
        // O(1)
        int size = this.list.size();
        return this.list.get(size-1);
    }

    public void push(T element) {
        // if don't consider extend array capactiy O(1), if not O(n)
        this.list.add(element);
    }

    public void pop() {
        // O(1)
        int size = this.list.size();
        this.list.remove(size-1);

    }

    public boolean isEmpty() {

        return this.list.isEmpty();
    }

    public void printStack() {
        int size = this.list.size();
        for(int i=0;i<size;i++) {
            System.out.println(this.list.get(i));
        }
    }

    public static void main(String[] args) {
        StackByArray<Integer> obj = new StackByArray<Integer>();

        obj.push(1);
        obj.push(2);
        System.out.println(obj.top());
        obj.pop();
        System.out.println(obj.top());


    }
}

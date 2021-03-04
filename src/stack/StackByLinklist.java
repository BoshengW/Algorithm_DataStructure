package stack;
import java.util.ArrayList;
import java.util.List;

class LinkNode<T> {
    T val;
    LinkNode next;

    public LinkNode(T val) {
        this.val = val;
        // default next = null;
    }
}

public class StackByLinklist<T> {

    LinkNode<T> dummy;
    LinkNode<T> head;
    int length;

    // 实现思路: 利用single-linkedlist 头插入和删除都是O(1)来保证push,pop 都是严格O(1)
    /*
    * 基本思路：
    *       1. 建立一个哨兵节点
    *       2. 把每一次新堆入的元素放在linkedlist头部
    *       3. 每一次pop元素就从头部把后入的元素剔除
    * */

    public StackByLinklist() {
        this.dummy = new LinkNode(-1);

        this.head = this.dummy;

        this.length = 0;
    }

    public void push(T val) {

        LinkNode<T> newNode = new LinkNode<T>(val);

        newNode.next = this.head.next;
        this.head.next = newNode;

        this.length+=1;

    }

    public void pop() {
        this.head.next = this.head.next.next;
        this.length-=1;
    }

    public boolean isEmpty() {
        return this.length==0;
    }

    public T top() {
        return (T)this.head.next.val;
    }

    public void printStack() {
        LinkNode<T> pre = this.head;
        for(int i=0; i<this.length; i++) {
            pre = pre.next;
            System.out.println(pre.val);
        }
    }

    public static void main(String[] args) {
        StackByLinklist<Integer> obj = new StackByLinklist<Integer>();
        obj.push(1);
        obj.push(2);

        obj.printStack();

        obj.pop();
        obj.printStack();
    }


}

package linkedlist;

import sun.awt.image.ImageWatched;

import javax.swing.*;

class LinkNode {
    public int val;
    public LinkNode next; // default is a null pointer

    public LinkNode(int val) {
        this.val = val;
    }
}

public class SingleLinkList {

    /*
    * Linked list 杀手锏，引入dummy node哨兵节点
      作用，是每一个元素都有前驱节点
     */
    private LinkNode dummy;
    private int length;

    public SingleLinkList() {
        this.dummy = new LinkNode(-1);
        this.length = 0;
        //dummy.next=null
    }

    public int getLength() {
        return this.length;
    }

    public int get(int index) {
        if(this.length<index-1) {
            System.out.println("index out of range");

            return -1;
        } else {
            // 保留dummy的位置否则在node一直遍历后之前的LinkNode会丢失
            LinkNode curr = this.dummy;
            for(int i=0; i<index-1; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

    }

    public boolean contains(int val) {
        LinkNode curr = this.dummy;
        while(curr.next != null) {
            curr = curr.next;
            if(curr.val == val) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int val) {
        // this is the most challenge one in linkedlist
        // we need to re-refer new linknode which means breaking old linknode
        if(this.length<index) {
            System.out.println("index out of range");
        } else {

            LinkNode pre = this.dummy;
            for(int i=0; i<index; i++) {
                pre = pre.next;
            }
            LinkNode newNode = new LinkNode(val);
            // Note: you cannot change the order
            /*
             * process ：
             * dummy -> 1 -> 2 ->3
             * For example: if i insert val=4 in index 2
             * 1. set new node (val) point to pre.next
             * 2. point pre.next to new node , then old link will break
             *
             * Note: you cannot change above step
             * if you create new Node and let pre.next = new Node first
             * then the old linkNode (3)'s link will break and new Node cannot find the object anymore.
             * */
            newNode.next = pre.next;
            pre.next = newNode;
            this.length+=1;

        }

    }

    public void delete(int index) {
        if(this.length<=index) {
            System.out.println("index out of range");
        } else {

            LinkNode pre = this.dummy;
            for(int i=0; i<index; i++) {
                pre = pre.next;
            }

            pre.next = pre.next.next;
            this.length -= 1;

        }
    }

    public void printLinkList() {
        LinkNode pre = this.dummy;
        while(pre.next!=null) {
            pre = pre.next;
            System.out.println(pre.val);
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        SingleLinkList obj = new SingleLinkList();
        obj.add(0,2);
        obj.add(1,3);
        obj.add(2,4);
        obj.add(3,5);
        obj.add(4,6);

        obj.delete(2);


        obj.printLinkList();
        System.out.println(obj.contains(2));


    }
}

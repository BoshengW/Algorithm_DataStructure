package Code_Interview.data_structure;

import java.util.HashMap;

class Node {
    int val;
    int key;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
public class LRUCache {
    /*
     * @param capacity: An integer
     */
    // every get and set will make key more recently
    // 应答 :  - get/set key O(1) - HashMap; -update key order - recent -> head, remove old one - 插头，去尾 - Linkedlist
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int cap;
    int size;

    public LRUCache(int capacity) {
        // do intialization if necessary
        cap = capacity;
        size = 0;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = head;

    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        int res = -1;
        if(map.containsKey(key)) {
            res = map.get(key).val;
            update(map.get(key));
        }
        return res;
    }

    private void update(Node node) {
        // make sure node is not current head
        Node currHead = head.next;
        Node currTail = tail;

        if(node.key==currHead.key) {
            return;
        } else if(node.key==currTail.key) {
            // node is tail
            tail = tail.prev;
            node.prev.next = null;

            // 往后挪
            head.next = node;
            node.next = currHead;
            node.prev = head;
            currHead.prev = node;
        } else {
            // 孤立node
            node.prev.next = node.next;
            node.next.prev = node.prev;

            // 往后挪
            head.next = node;
            node.next = currHead;
            node.prev = head;
            currHead.prev = node;
        }

        System.out.println(head.next.key);

    }

    private void addNew(Node node) {
        Node currHead = head.next;

        // if this is first element
        if(currHead==null) {
            head.next = node;

            node.prev = head;
            tail = node;
        } else {
            // old node 往后挪
            head.next = node;
            node.next = currHead;
            node.prev = head;
            currHead.prev = node;
        }

        System.out.println(head.next.key);
    }

    private void pop() {
        // remove last element
        // System.out.println(head.next.key);

        tail = tail.prev;
        tail.next = null;

        // System.out.println(head.next.key);

    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).val = value; // update new value
            update(map.get(key));
            // size not change
        } else {
            // new node
            Node node = new Node(key, value);
            addNew(node);
            map.put(key, node);

            if(++size>cap) {
                System.out.println(head.next.key);
                map.remove(tail.key);
                pop();
                size--;
            }
        }

    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.set(2, 1);
        obj.set(1, 1);
        obj.get(2);
        obj.set(4, 1);
        obj.get(1);
        obj.get(2);

    }
}
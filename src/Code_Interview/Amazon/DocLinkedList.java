package Code_Interview.Amazon;

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class DocLinkedList {
    /**
     * https://www.1point3acres.com/bbs/thread-800401-1-1.html
     * 题目一个单链表 - 每次将首尾node相加 求最大值
     * 1. 暴力解法 O(N^2)
     * 2. 快慢针找到中点，然后将后面的点方向reverse
     * */
    public int maximumPage(Node head) {
        // 找到中点
        Node fast = head;
        Node slow = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 将slow之后的点方向reverse
        Node curr = slow.next;
        Node next = curr.next;

        curr.next = slow;
        slow = curr;
        while(next!=null) {
            curr = next;
            next = curr.next;

            curr.next = slow;
            slow = curr;
        }

        // curr is last
        Node l = head, r=curr;
        int res = 0;
        while(l.next!=r && r.next!=l) {
            res = Math.max(res, l.val+r.val);
            l = l.next;
            r = r.next;
        }
        res = Math.max(res, l.val + r.val);

        return res;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node t1 = new Node(1);
        Node t2 = new Node(1);
        Node t3 = new Node(3);
//        Node t4 = new Node(1);
//        Node t5 = new Node(3);
        head.next = t1;
        t1.next = t2;
        t2.next = t3;
//        t3.next = t4;
//        t4.next = t5;

        DocLinkedList obj = new DocLinkedList();
        System.out.println(obj.maximumPage(head));
    }
}

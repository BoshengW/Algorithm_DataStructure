package Code_Interview.Amazon;

import java.util.Arrays;
import java.util.HashMap;

class Item {
    String name;
    Item next;
    Item prev;

    public Item(String name) {
        this.name = name;
    }
}

public class RecentViewItem {
    /**
     * https://www.1point3acres.com/bbs/thread-816549-1-1.html
     * 题目描述: 建立一个最近访问页面 类似LRU只是没有删除操作
     * 思路 HashMap(查找) + LinkedList(排队)
     */
    Item head = null;
    Item tail = null;
    HashMap<String, Item> map = null;
    int len;

    public RecentViewItem() {
        map = new HashMap<>();
        head = new Item("top");
        tail = head;
    }
    // O(N)
    public String[] recentItem(String[] items) {
        for(String i: items) {
            if(!map.containsKey(i)) {
                // item not exist
                Item newItem = new Item(i);

                newItem.next = head.next;
                newItem.prev = head;

                if(len!=0) {
                    head.next.prev = newItem;
                }
                head.next = newItem;
                map.put(i, newItem);
                len++;
            } else {
                Item t = map.get(i);
                if(t.next==null) {
                    // is tail
                    t.prev.next = t.next;
                } else {
                    // 断开之前连接
                    t.prev.next = t.next;
                    t.next.prev = t.prev;
                }
//                // 断开之前连接
//                t.prev.next = t.next;
//                t.next.prev = t.prev;

                // 连接到头部
                t.next = head.next;
                t.prev = head;
                head.next.prev = t;
                head.next = t;


            }
        }

        // print
        String[] res = new String[len];
        Item dum = head;
        int idx = 0;
        while(dum.next!=null) {
            dum = dum.next;
            res[idx++] = dum.name;
        }

        return res;


    }


    public static void main(String[] args) {
        RecentViewItem obj = new RecentViewItem();
        String[] t = {"phone", "tv", "tv","phone","shirt","tv"};
        System.out.println(Arrays.toString(obj.recentItem(t)));
    }
}

package Code_Interview.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CouponValid {
    /**
     * https://www.1point3acres.com/bbs/thread-816549-1-1.html
     * 题目: 确定一个字符串是否是合理的coupon
     * abba -> 合理 abc-> 不合理 daabbd-> 合理
     * */

    public int[] checkCoupon(List<String> list) {
        int[] res = new int[list.size()];
        int idx = 0;
        for(String s: list) {
            if(helper(s)) res[idx++] = 1;
            else res[idx++]=0;
        }

        return res;
    }

    private boolean helper(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char t = s.charAt(i);
            if(stk.size()>0 && stk.peek()==t) {
                stk.pop();
                continue;
            }
            stk.push(t);
        }

        return stk.size()==0;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("aabb");
        list.add("dabbad");

        CouponValid obj = new CouponValid();
        System.out.println(Arrays.toString(obj.checkCoupon(list)));
    }
}

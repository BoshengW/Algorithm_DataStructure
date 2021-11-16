package Data_Structure.stack.mono_stack;

import java.util.Arrays;
import java.util.Stack;

public class MonoStack {

    public int[] asc(int[] n) {
        // find pre-last val <= current value
        // 栈内维护递增
        int tt=0;
        int[] ans = new int[n.length];
        ans[tt] = -1;
        for(int i=0; i<n.length; i++) {
            while(tt!=0 && ans[tt]>=n[i]) tt--; //前面栈比他大
            if(tt!=0) System.out.println(ans[tt]);
            else System.out.println(-1);

            ans[++tt] = n[i];
            System.out.println("tt: " + tt);
            System.out.println(Arrays.toString(ans));

        }
        return ans;
    }

    public int[] dec(int[] n) {
        // find pre-last val <= current value
        // 栈内维护递减
        int tt=0;
        int[] ans = new int[n.length];
        ans[tt] = -1;
        for(int i=0; i<n.length; i++) {
            while(tt!=0 && ans[tt]<=n[i]) tt--; //前面栈比他大
            if(tt!=0) System.out.println(ans[tt]);
            else System.out.println(-1);

            ans[++tt] = n[i];
            System.out.println("tt: " + tt);
            System.out.println(Arrays.toString(ans));

        }
        return ans;
    }
    public static void main(String[] args) {
        int[] t = {3, 12, 1, 7, 9};
        MonoStack obj = new MonoStack();
        System.out.println(Arrays.toString(obj.asc(t)));
    }
}

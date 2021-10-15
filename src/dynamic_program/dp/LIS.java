package dynamic_program.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LIS {
    // 求最长上升子序列的最优解方案

    public static void main(String[] args) {
        int[] testcase = {4,2,4,5,3,7,1};

        // state
        int[] dp = new int[testcase.length];
        // another array store idx of best LIS index
        int[] prev = new int[testcase.length];
        Arrays.fill(prev, -1);

        // init
        Arrays.fill(dp, 1);
        int longest = Integer.MIN_VALUE;
        int last = -1;
        for(int i=0; i<testcase.length; i++) {
            for(int j=0; j<i; j++) {
                if(testcase[j]>=testcase[i]){
                    continue;
                }

                if(dp[i]<dp[j]+1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }

                if(longest<dp[i]) {
                    longest = dp[i];
                    last = i;
                }
            }
        }
        List<Integer> res = new LinkedList<>();
        System.out.println(Arrays.toString(prev));
        while(last!=-1) {
            res.add(0, testcase[last]);
            last = prev[last];
        }

        res.forEach(x -> System.out.println(x));
    }
}

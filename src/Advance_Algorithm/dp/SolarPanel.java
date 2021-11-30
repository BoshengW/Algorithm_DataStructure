package Advance_Algorithm.dp;

import java.util.Arrays;

/**
 * N houses each house cost A[K] energy
 * have solar panel installation -
 * 1: cost X -> set A[k] = 0
 * 2. cost Y -> set A[k] = -A[k]
 * 3. no cost -> A[k]
 * find minimum cost which can make total energy = 0
 * **/
public class SolarPanel {

    public static int dp(int[] A, int X, int Y) {
        // 类似01背包问题
        // 可以看成 cost X -> A[k], cost Y -> 0, no cost -> 2A[k] 然后找总和<=Sum A的最小cost
        // state
        int sum = 0;
        for(int i: A) sum+=i;
        // dp[i][j] 前i个房子总限能为j安装所需要的最小cost
        int[][] dp = new int[A.length+1][sum+1];
        for(int i=1; i<dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // init
        // dp[0] = 0;
        /**
         *
         * dp[i][j] 来源
         * 1. 选 X - dp[i-1][j-A[k]] + X
         * 2. 选 Y - dp[i-1][j] + Y
         * 3. 不选 - dp[i-1][j-2*A[k]]
         */
        for(int i=1; i<=A.length; i++) {
            for(int j=0; j<=sum; j++) {
                if(j-2*A[i-1]<0) {
                    if(j-A[i-1]<0) {
                        // 不能 （不选或选X）
                        dp[i][j] = dp[i-1][j] + Y;
                    } else {
                        //可以选X,Y
                        dp[i][j] = Math.min(dp[i-1][j] + Y, dp[i-1][j-A[i-1]] + X);
                    }
                } else {
                    dp[i][j] = Math.min(dp[i-1][j]+Y, Math.min(dp[i-1][j-A[i-1]]+X, dp[i-1][j-2*A[i-1]]));
                }
            }
        }

        return dp[A.length][sum];
    }

    public static void main(String[] args) {
        int[] test = {2, 2, 1, 2, 2};
        System.out.println(SolarPanel.dp(test, 2, 3));
    }
}

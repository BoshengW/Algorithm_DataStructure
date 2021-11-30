package Advance_Algorithm.dp;

import java.util.Arrays;

public class Solution {
    // 坐标型DP
    // top down
    public int shortestPath2(boolean[][] grid) {
        // write your code here
        if(grid==null || grid.length==0) return -1;

        // 1. DP状态
        int row = grid.length;
        int col = grid[0].length;
        // dp[i][j] 从0,0 到 i,j能否到达
        int[][] dp = new int[row][col];
        int[] x = {1, -1, 2, -2};
        int[] y = {2, 2, 1, 1};
        // 2. DP初始化
        for(int i=0; i<row; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        // grid[*][0] 第一列不可能到达全部false
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                // check all possible directions
                if(grid[i][j]) {
                    continue;
                }
                for(int w=0; w<4; w++) {
                    // i,j 前一个状态有四个，选择没越界的
                    if(j-x[w]>=0 && j-x[w]<col && i-y[w]>=0 && i-y[w]<row && dp[i-y[w]][j-x[w]]!=Integer.MAX_VALUE) {
                        System.out.println("x:" + (i-y[w]) + ",y:" + (j-x[w]) + ",val:" + dp[i-y[w]][j-x[w]]);
                        dp[i][j] = Math.min(dp[i][j], dp[i-y[w]][j-x[w]]+1);
                    }
                }
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        boolean[][] testcase = {{false, false, false, false}, {false, false, false, false}, {false, false, false, false}};
        Solution obj = new Solution();
        obj.shortestPath2(testcase);
    }
}

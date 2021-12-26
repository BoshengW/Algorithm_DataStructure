### 区间型DP
- 解决一些求字符串或者数组subarray/subsequence可行性，方案总数，单一方案问题
#### 特点
- 状态定义
    - dp[i][j] 面对子序列[i,...,j] 时的最优性质(最优值，可行性，方案总数)
- 区间DP特点
    - 大区间依赖于小区间[i, j] 依赖 [i, k] + [k+1, j] - 将问题区间分割为两部分，两部分的整合结果就是当前问题最优解
    - !!!重点
        - 因此注意在区间循环时要理清先后顺序不能小的依赖大的
        - 通常循环区间长度和起终点 - 从小更新大
- 状态方程
    - 按照区间长度从小到大遍历 r
        - 这样可以保证在算大区间时，小区间所有情况已经计算完成

#### 模板

```
int[][] dp = new int[n][n];
// dp[i][j] -> 表示[i,j]区间内的最优解

---- init -----
进行相应初始化通常[i,i], [i][i+1]
----- 转移方程 -----
for(int len=2; len<=n; len++) {
    for(int start=0; start<n-len+1; start++) {
        int end = start+len-1;
        // 确定完start 和 end 之后遍历k来划分[start, end]成为两个部分
        for(int k = start; k<end; k++) {
            dp[start][end] = Func(dp[start][k], dp[k+1][end], dp[start][end]);


            // 举例 求max cost
            - dp[start][end] = Math.max(dp[start][k] + dp[k+1][end] + cost(k), dp[start][end]);
        
        }
    }
}

return dp[0][n-1];

```

### 区间DP习题
- !!!一定要确定区间依赖关系，通常大的依赖小的
#### 最长回文子串
- 建立区间DP

```
// 区间 DP - O(N^2)
public String longestPalindrome(String s) {
    // write your code here
    // [i, j] -> [i+1, j-1] && s[i] == s[j]
    // 状态 - dp[i][j] 区间[i,j]是否是回文 - 
    if(s==null || s.length()<=1) return s;
    int n = s.length();
    boolean[][] dp = new boolean[n][n];

    // 初始化 [i, i] -> true 单一字符， [i, i+1] -> 双字符
    int maxL = 1;
    int left = 0;
    int right = 1;
    for(int i=0; i<n; i++) {
        dp[i][i] = true;
        if(i<n-1) {
            dp[i][i+1] = s.charAt(i)==s.charAt(i+1);
            if(dp[i][i+1] && maxL<2) {
                maxL = 2;
                left = i;
                right = i+1;
            }  
        }
            
    }

    // 转移方程
    for(int l=3; l<=n; l++) {
        for(int st=n-l; st>=0; st--) {
            int ed = st+l-1;
            dp[st][ed] = dp[st+1][ed-1] && s.charAt(st)==s.charAt(ed);
            // System.out.println("st: " + st + ",ed: " + ed + ", pali: " + dp[st][ed]);
            if(dp[st][ed] && l>maxL) {
                maxL = l;
                left = st;
                right = ed;
            }
        }
    }

    return s.substring(left,right+1);
}
```

#### Stone Game 石子归并问题

#### Burst Balloon 吹气球问题 - Hard
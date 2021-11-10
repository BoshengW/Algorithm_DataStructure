### 前缀和 
- 前置思想：滑动窗口
- https://lucifer.ren/leetcode/thinkings/prefix.html 

#### 1D 前缀和
```
array: a = [a1, a2, a3, ..., an]

prefix Sum s = [s0, s1, s2, ..., sn]

si = si-1 + ai
```
- 这种前缀和计算有什么作用
    - 可以通过两个前缀和的差来表示这个数组任何一个区间的和

#### 2D 前缀和
```
array: a = [a11, a12, ..., amn]

prefix Sum s = [s00, s01, ..., smn]

s[m][n] = s[m-1][n] + s[m][n-1] - s[m-1][n-1] + a[m][n]

```
- 2D的前缀和可以通过球差的方式得到任何一个区间内部的sum


#### 字符串哈希前缀和
- 字符串哈希解决的问题
    - 如果我们有所有字符串前缀和数组，那么当问询两个字符串[l,r]区间是否相等时，可以优化到O(1)
        - 暴力则是需要O(r-l)

```
1. 前缀hash
    long p = 131;
    long hash[N+1], pow[N+1];
    pow[0] = 1;
    hash[0] = 0;  
    for(int i=1; i<=str.length(); i++) {
        hash[i] = hash[i-1] * P  + str.charAt(i-1);
        pow[i] = pow[i-1] * P;
    }

    // [l,r] substring hash value
    hashLR = hash[r] - hash[l-1]*pow[r-l+1];
    
2. 后缀hash
    
    abc
    c N
    cb N-1
    cba N-2

    long p = 131;
    long hash[N+1], pow[N+1];
    pow[0] = 1;
    hash[N] = 0;
    for(int i=str.length()-1; i>=0; i--) {
       hash[i] = hash[i+1] * P + str.charAt(i);
       pow[N-i] = pow[N-i-1] * P; 
    } 
    
    // [l, r] 后缀hash值
    hashLR = hash[l] - hash[r+1]*pow[r-l+1];
```

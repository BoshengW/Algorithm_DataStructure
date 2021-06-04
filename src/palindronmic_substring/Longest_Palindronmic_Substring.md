###最长回文子串 - Longest Palindronmic Substring
#### Question Overview
- Substring(连续):
    - abcd -> ab, bc, cd
    - (n) Length String how many substring: O(n^2)
- Subsequence(非连续):
    - abcd -> ac, bd
    - (n) Length String how many subsequence: O(2^n)
        - each element has option choose or not, so 2^n

#### Find all SubString
- Solution1(Brute Force):
    - 双指针算法
```
for(start-point):
    for(end-point):
        checkPalindronmic(Substring[start: end])
```
- Solution2 (中心线枚举-Enumeration)
    - 以每一个字符为中心向两边扩展，每一次检测中轴线相对的两个字符直到出现不想等字符为止
    - 以中心线为轴做扩展窗
  
```
x a |b b| a c -> 偶数长度为中心
x  a |b| a c -> 奇数长度为中心

odd - 
```

- Solution3 (Dynamic Programming)

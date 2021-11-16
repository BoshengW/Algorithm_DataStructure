### 字符串类问题

#### 名词解释
- subarray: 连续
- subsequence: 可以不连续, 相对顺序一致

#### 常见问题
- 字符串匹配
    - 回文subarray
    - 回文subsequence

- 字符串查找
    - subarray存在
    - subsequence存在
    
- 字典树-前缀查找


#### 常用思路
- Bad! 暴力搜索
- 连续字符查找匹配优化：Robin-Karp
- 前缀查找优化: Trie
- 区间动态规划
- KMP
- 自动机

#### LintCode & Leetcode题目
- StrStr() 在Source中找与target匹配的第一个位置
- Longest能够组成的回文串
- Longest Palidrome 找最长回文子串 - subarray
    - two pointer
    - 区间型DP
    - Manacher
    - Robin-Karp + 二分
- 最长回文子序列 - longest subsequence 
    - 区间DP
- 两个字符是否是Anagram - 变种Robin-Karp

#### 字符串常见操作
```
// convert String into char array
char[] a = str.toCharArray()

// calculate letter freq of one string
int[] a = new int[26];
for(char i: charArrayOfString) {
    a[i - 'a'] += 1;
}

// 
```

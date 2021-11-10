## 双指针算法
### 相向双指针
```aidl
 |->  <-|
```
- Tips: 双指针优点可以不需要开辟新空间
- Reverse型:
    - 翻转字符串
    - 判断回文串

- Two sum型
    - TwoSum: LintCode 56, 607
        - 统计所有<=target or >=target 配对数
    - ThreeSum: LintCode 57, 382
    - 4Sum: LintCode 58, 
    - KSum: 需要使用DP或者DFS求解 - LintCode KSum
    - Triangle Count: LintCode 382

- Partition型 - 分区算法
    - 快速排序
        - LintCode 31: Partition Array  
    - 颜色排序
        - LintCode 148: Sort Colors (3 colors)
        - LintCode 143: Sort Colors II (n colors)
    - 正负数交错-无序版
        - LintCode 144 Interleaving Positive and Negative Numbers
    - LintCode 539 Move Zeros
    
    
  


### 背向双指针
```aidl
 <-| |->
```
- 题型 - 出现题型较少
   - 最长回文子序列
   - find K closest values

### 同向双指针
```aidl
|-> |-> 
```
- 题型
    - 排序数组中寻找最接近的K个数

### 数据结构设计题目
- 通常题目要求
1. 设计一个存储结构
2. 设计几种方法对数据结构里的数据进行增删改查(CRUD)

- 常见速度权衡问题
    - 首先应该确定该数据结构CRUD的频率，哪种operation做的比较多
  
  | 哪个方案好 | add | find |
  | :-----| ----: | :----: |
  | 方案A | O(1) | O(N) |
  | 方案B | O(logN) | O(logN) |

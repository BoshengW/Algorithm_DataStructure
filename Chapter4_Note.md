## Chapter 4
#### Time Complexity 
- Complexity
    - Time Complexity - 主要考察
        - 可以衡量，无需死磕最优解
    - Space Complexity - 次要考察
    - Coding Complexity - 能看的懂
        - 以增加一些时间复杂度为代价，是代码可读性增高
    - Logic Complexity - 能想得出
- Tips:
    - 利用时间复杂度来推断算法，比如一般O(logN)的算法可以确定是二分法
- Question
    - O(n+m), O(max(n,m)) -> 相等
    
#### O(n) 算法常见有哪些
- 双指针
- 打擂台算法(找最大枚举)
- 单调栈和单调队列

### Chapter 4.1. 双指针算法
- 相向双指针(判断回文串)
- 背向双指针(找最长子串) - 出现较低题比较少
- 同向双指针

##### 相向双指针
- Tips: 双指针优点可以不需要开辟新空间
- Reverse型
    - 翻转字符串
    - 判断回文串
    
- Two sum型
    - 两数之和
    - 三数之和
    
- Partition型
    - 快速排序
    - 颜色排序

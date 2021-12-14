### Amazon OA 面经

1. Leetcode 1151 - minimum swap 1
2. Valid Coupon
3. Recent item page - LRU simple
4. Single LinkedList, A customer will read first & last each day - 求最大和
- 对于找中点相关链表题目 - 可以使用快慢双指针
```

```
5. Leetcode 828
6. 寻找连续单调递减的组合数
- https://www.1point3acres.com/bbs/thread-804327-1-1.html
- 一段连续递减的数组 - 连续递减子数组的个数=1+2+..+N
- 举例 
```
[9, 8, 7, 6] -> 4 + 3 + 2 + 1 = 10
``` 
- 基本思路: 遍历一遍每一次没有一个连续递减就+长度

7. Leetcode 1846 - 
- 基本思想: 最后序列最大值一定是递增排序后序列的最大值
    - 遍历数组，如果数组当前值比prev+1大则降至prev+1
8. Leetcode 1492 分解质因数
9. leetcode 907 
10. leetcode 926
11. leetcode 1109 - 航空schedule booking - 差分数组扫描线
12. Prime Air time
- 描述
```
两个Array - 给一个target找到最接近target的两个数组和的ids
- arr1: [[1, 100], [2, 100], [3,200]]
- arr2: [[1, 300], [2, 500]]
target: 750 - [3,2]

``` 
13. vowel password - 元音密码
- 描述
```
将一个字符串分割成至少一个元音至少一个辅音最多能分多少份
```

14. leetcode 315 - 归并排序思想 - 寻找逆序对
#### 电面
1. n个k面色子 输出每种和的概率数组 比如2个2面色子 输出 [0.25, 0.5, 0.25]
  -	DFS 组合问题
  - https://www.1point3acres.com/bbs/thread-825475-1-1.html
2. 猜词游戏 - secrets + guess -> output (int a, int b)
- https://www.1point3acres.com/bbs/thread-825315-1-1.html
    - a 有几个字母完全猜对 - 
    - b 有几个字母猜对了但是位置不对

```
Examples: secret / guess
    BAT / CAT -> 2 (A, T), 0 (B != C)
    BAT / TAB -> 1 (A), 2 (B, T)
    AAB / CCA -> 0, 1 (one A in the guess)  
    CAC / AAB -> 1, 0 (one A in the guess)
    CCA / AAB -> 0, 1
    AABB / CCAA -> 0, 2 (two As in both words)
```
    
3. 一个餐厅经理要设置菜单，有很多recipe，和 one set of raw ingredients，问当天能上什么菜
- https://www.1point3acres.com/bbs/thread-825191-1-1.html
```
recipe 的例子：
    1）hamburger
    intermediate ingredient: bread
    raw ingredient: vegetable, meat
    
    2）bread
    intermediate ingrediant: none
    raw ingredient: flour, water
    
    如果有 raw ingredients：vegetable, meat, flour, water的话，就能做 hamburger‍‌‍‌‌‍‍‍‌‍‍‍‌‌‌‌‍‍‍‌ 和 bread
    如果有 raw ingredients：vegetable, meat, water的话，就什么都不能做
```
图 - bfs
4. 输入两个string s1和s2，如果s1加一个字母后任意排列可以变成s2，返回true，否则false。
- https://www.1point3acres.com/bbs/thread-825057-1-1.html
```
input: ["ABC", "ACDB"], output: true,
input: ["ABC", "BZAXT"], output: false

把上面的函数叫func(s1, s2)，输入两个list of strings， l1，l2，对于l2中每一个string s2，
如果l1中存在s1，使得 func(s1,s2) 返回true，将s2加入结果list。
input: ["ABC","DEF", "FOO"], ["ABCT","DEFG","BAR"], output: ["ABCT","DEFG"]
```

5. 给一个str, 如果所有substring（substring的定义是按照str顺序，可以不连续，且长度大于等于3）都是真实存在的单词，返回true，否则false
- https://www.1point3acres.com/bbs/thread-824912-1-1.html
- combination
```
eg1: neat ---True  因为nea net nat eat 都是word
eg2: hello -False 因为l‍‌‍‌‌‍‍‍‌‍‍‍‌‌‌‌‍‍‍‌lo不是word
```

6. Given an Unfair coin, 如何生成fair probability (50%). 假设这个coin生成head概率为p, 
可以考虑生成（tail, head）or (head, tail) 因为他们的概率 都是p（1-p）,如果得到(tail, tail) 
或者（head,head）重新生成一个pair就好了。

7. 第一题不知道有没有利口，是一个string of English letters，要求返回index如果当前的字母比原来的排序低。比如ABCZD就返回D的index。Followup返回总的count。再Followup如果要从前后同时搜索，2pointer应该就行了吧。

8. 第二‍‌‍‌‌‍‍‍‌‍‍‍‌‌‌‌‍‍‍‌题貌似在地里见过，是一个logger系统。和利口伞舞酒不是完全一样但是相似。Followup要improve time complexity楼主可能没答好，用Hash Table可以O(1)。

9. encode/decode graph with integer list, 是我從來都沒有看過, graph本身是directed, 有可能存在環,
   原本以為是297. Serialize and Deserialize Binary Tree, 擴展到n-ary但是，因為有環所以不成立
   - https://www.1point3acres.com/bbs/thread-823946-1-1.html
   
10. 高速路有check采集实时信息，如何计算每辆车的收费打电话通知要加面一轮，不知道是不是理解错了，面试官没提OOD，所以把重点都放在怎么设计算法计算收费了，简单的写了几个function

11.  給兩個strings, 第二個string跟第一個string相比只能多一個character (都是uppercase)
    string內的排序不一樣沒關係 只要出現次‍‌‍‌‌‍‍‍‌‍‍‍‌‌‌‌‍‍‍‌數一樣即可，但有個字母次數會多一次
    
12. 给了一个array 每个元素全是string
    string 由符号分割 分别是 品牌:类别:材料:商品名 e.g. ikea:furtiniture:wood:xxxxx
```
1. 找到所有的 brand 可重复
2. 找到所有的 brand 不重复
3. 如果优化这个array
4. 在所有的元素里search string
5. 使用js prototype创建class 如果快速查找某个关键词 可能是品牌 类别材料 商品名的任‍‌‍‌‌‍‍‍‌‍‍‍‌‌‌‌‍‍‍‌一 或多个
```

13. merge sorted list 变种

14. Leetcode 1197

15. 一颗二叉树，边都有大于零的weight。现在要砍掉一些边使得所有叶子都和root不相连。求砍掉的边的weight总和最小值。followup 如果有负边怎么办。
- https://www.1point3acres.com/bbs/thread-820549-1-1.html

16. 一个n by n matrix, sliding window w by w, 返回每个window 最小值
    leetcode最接近的是sliding window maximum(hard), 
17. Calculate the sums of sqrt of the odd and even entries of the sequence range(1,100)
18. 一个log files的题，相当于meeting room II的变形，
19. 无向图，从A到B的最短距离（边长都为1）
    follow up: 还是一样的无向图，开车从A到B，油箱容量K有限（加满油只能走K步），部分节点是加油站（到该节点可以加满油）。问从A到B的最短路程

20. 给了一个interface要计算一个服务器的latency。有两个methods。一个用来加入input, 一个用来算mean. Impletment自己的class.
    Follow-up: 用mean好不好，那我们如果算median怎么样，写写看怎么算median.
    Follow-up2: 如果有多台servers要算median怎搞。
   -https://www.1point3acres.com/bbs/thread-820070-1-1.html


21.
```
有一个二维矩阵，每个cell表示海拔高度，给你两个城市的坐标，问最高在哪里建water tower可以确保水留到两个城市 举个列子，两个城市的点在（0，1），（1，0）
5 2
2 3
我们可以在（‍‌‍‌‌‍‍‍‌‍‍‍‌‌‌‌‍‍‍‌0，0）和（1，1）建，但（0，0）比（1，1）高，所以答案是（0，0）
``` 

22. 
```
coding题，生成binomial distribution的一个matrix，取每一列的和做分母，让每一列的和为1. 我用的python，答：
  import numpy as np
  k = 10
  p = 0.5
  n = 10
  a = np.random.binomial(k, p, (n, n))
  sum = np.sum(a, axis = 1)
  print(a/sum)
```

23. 写代码，length of longest continuous increasing subarray, 
扩展：允许一次violoation, 就是允许array里面有下降的情况，怎么修改
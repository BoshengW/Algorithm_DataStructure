## 递归 recursion - 通常指递归函数

- 递归函数：程序一种实现方式，即函数自己调用自己
- 递归算法：即大问题结果依赖于小问题结果，于是先用递归函数求解小问题


### Content Overview
- T function - Calculate time complexity
    - Example: Calculate Binary Search Time Complex
```
T(n) = T(n/2) + O(1) 
    -> mean use O(1) time complex to reduce scale(n) problem into scale(n/2)
T(n/2) = T(n/4) + O(1)
...
T(n) = T(n/2) + T(n/4) + ... + T(1) + logn * O(1) = O(logn)    
``` 
- Recursion
    - Three Components to build a recursion
    - Recursion Depth
        - Fibonarcci -> O(n)
        - Binary Search -> O(logn)
- StackOverflow Issue
    - if Recursion Depth too deep will cause StackOverflow
    - Stack Space + Heap Space
- To avoid StackOverflow -> optimize by Tail Call Recursion
    - Java, Python cannot use but C++ can do it.
    
    

### Recursion 
- Three Steps to build a recursion
    - Entry: what input param need to feed
    - Exit: which condition will end the recursion
    - Split: how to split T(n) into T(n/2)
- Tail Call Recursion (Python, Java Cannot work, C++ works)
```
// Normal Recursion
def recsum(x):
    if x == 1:
        return x;
    else:
        return x + recsum(x-1)
---------------------------- Running--------------
recsum(5)
5 + recsum(4)
5 + (4 + recsum(3))
5 + (4 + (3 + recsum(2)))
5 + (4 + (3 + (2 + recsum(1))))
5 + (4 + (3 + (2 + 1)))
5 + (4 + (3 + 3))
5 + (4 + 6)
5 + 10
15

--------------------------------------------------
// Tail Call
def tailrecsum(x, running_total=0):
    if x==0:
        return running_total;
    else:
        return tailrecsum(x-1, running_total + x)
-------------------------------Running------------
tailrecsum(5, 0)
tailrecsum(4, 5)
tailrecsum(3, 9)
tailrecsum(2, 12)
tailrecsum(1, 14)
tailrecsum(0, 15)
15
--------------------------------------------------
```

### 通过递归实现的搜索方法 - DFS深度优先搜索
### 递归实现的另一种算法 - 回溯 back-tracking



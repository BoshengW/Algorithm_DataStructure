#### Chapter 5

#### Content Overview
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
    - 
    
    


##### Recursion 
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
- Binary Search Template
```
## which part you should
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        // 要点1: start + 1 < end
        while (start + 1 < end) {
     // 要点2：start + (end - start) / 2
            int mid = start + (end - start) / 2;
            // 要点3：=, <, > 分开讨论，mid 不+1也不-1
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // 要点4: 循环结束后，单独处理start和end
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}

```


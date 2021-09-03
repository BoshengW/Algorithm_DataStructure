## 二分法 - Binary Searh
### What is Binary Search, How it used for?
- 二分法又叫二分查找(折半查找) - 一种高效查找算法
    - 通常用于有序数据上寻找某个目标
- 时间复杂度 O(logN), 空间复杂度 O(1)
- 注：二分法利用了减治(Decrease and Conquer)的算法思想，不属于分治(Divide and Conquer)思想
    - 什么是算法思想： 常见的Brute Force，Dynamic Programming，
    - 减治：将大任务分解成两个小任务，保留其中哪个满足条件的任务，从而实现减小任务规模
    - 分治：将大任务分解成两个小任务，解决自问题从而最终解决大问题
  
### 什么时候使用二分
- array + sort + target
    - Note: 二分法并不一定要搜索出最后位置，可能会搜索出一个范围(两个点)，最后在两个点里选出最后解
        - 养成思维 - 在二分的中间不返回结果，二分只用来缩减范围
### 二分法4 Levels
- Level 1: 会写二分法模版
  - 写出不会死循环的二分法
  - 递归和非递归的权衡
  - 二分的三大痛点？？
      - 循环的结束结果，怎样避免死循环, -> start+1<end
  - 通用二分模版
  - 题型：
    - Lintcode 457 经典二分查找
  
- Level 2：
  - 问题关键词：array, sorted, target, equal or close to
    - 排序数组做二分通常满足XXOO模型，左右有明显差异，这样我们就可以进行减治选取有解的一部分
  - 在排序数据集上进行二分
  - 找到满足某个条件的第一个位置或者最后一个位置
    - OOOOOOO|OX|XXXXX ->这也就是为什么我们二分模板最后返回两个index
  - 题型：
    - find target in sorted array/peak array/rotate sorted array
    - Sorted Array
        - LintCode 447 Find target in Big array
        - LintCode 460 Find K closest
    - Peak Sorted Array 
        - LintCode 585 Maximum Number in Mountain Sequence
    - Rotated Sorted Array
        - LintCode 159 Find Minimum in Rotated Sorted Array
        - LintCode 62 Search in Rotated Sorted Array
        
  
- Level 3：
  - 如果没有排序，也可以先排序在求解
    - 但是如果数组不满足XXOO模型，也就是找不到一个固定XX|XO|OO模型
        - 可能是XXOOXXOOXX,...等其他形式，需要对二分模板进行更改
        - 这时通常会存在多个解但只需要返回一个
            - 如果需要返回所有解，我们如何求解，还能使用二分查找吗？？？
  - 在未排序的数据集上进行二分
  - 保留有解的一半，或者去掉无解的一半
  - 题型：
    - find target in peaks array/
    - Multiple Peaks Array
        - LintCode 75 Find Peak Element
- Level 4：
  - 在答案集上进行二分
    - 这类题较难，通常这种题型直观上不是一个二分题目，但是当底层求解需要使用二分法
  - 二分答案并验证答案偏大还是偏小
  - 题型：
    - LintCode 183： Wood Cut
  
### 倍增思维 Exponential BackOff
不同于折半思路，倍增通常用来估计当数组长度未知的情况，在未知长度中寻找目标大致范围
- 使用倍增思维的场景 
  - 动态数组 ArrayList, python list
      - 每一次扩容是2*n 
  - 网络重试
      - 1s 请求server如果不行那么2s, 4s, ... 来发送请求
  
- 参考题目 Lintcode447
  
- 具体思路

### 二分法模板

```
//Binary Search Template

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
        // 这样避免死循环 -> 对于有重复元素的数组二分时 如果使用 start<end
        // find first position -> 不会出现死循环
        // find last position -> 会出现死循环 -> 例子nums=[1,1] target=1 
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
  

### 常见二分法问题


    
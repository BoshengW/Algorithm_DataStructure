### 单调栈、最大栈、最小栈- Monotonic Stack
#### 定义
- 找到左边或右边离该位置最近且比他小/大的数

#### 经典题型
- leetcode: next great element/ 

#### 单调递增栈实现方法 - 类似双指针 
- 利用栈来保存i之前满足一下性质的数
    - index: j<i; value: A[j]<A[i]
   
```
-   [3,  4,  2,  7,  5]
ans: -1   3   -1  2   2    
```

#### 最小栈
- 特点
- 应答功能
    - push/pop - O(1)
    - min - O(1)
    - popMin
- 实现方法
    - 两个stack一个保存所有值，一个保存当前最值，一个hashset(标记曾经最值位置)

#### 最大栈
- 特点
- 应答功能
    - push/pop - O(1)
    - peekMax - O(1)
    - popMax(难点)
- 实现方法

#### 单调栈
- 模板三步走
1. 每一个元素下一个比它小的值
```
int[] res = new int[nums.length];
Stack<Integer> stack = new Stack<>();
// 单调增栈 - 栈中元素保持递增
for(int i = nums.length-1; i>=0; i--) {
    //当下一个元素插入之前不能保证
    while(!stack.isEmpty() && stack.peek()>nums[i]) stack.pop();
    res[i] = stack.isEmpty()? -1: stack.peek();
    stack.push(nums[i]);    
}

// 举例
[2, 1, 2, 4, 3]
stack - [3] -> [3, 4] -> [2] -> [1] -> [2]

```
2. 每一个元素上一个比他小的值
```
int[] res = new int[nums.length];
Stack<Integer> stack = new Stack<>();
// 单调递增栈 - 栈中元素单调递增
for(int i=0; i<nums.length; i++) {
    // 当下一个元素比栈顶大时往前面找有没有比这个元素大的
    while(!stack.isEmpty() && nums[i]<stack.peek()) stack.pop();
    res[i] = stack.isEmpty()? -1: stack.peek();
    stack.push(nums[i]);
} 
```
### Tree 

#### 二叉树迭代器 - iterator
- 什么是迭代器
    - next() -> return next minimum element in the Data_Structure.tree
    - hasNext() -> boolean check if still has element in the Data_Structure.tree
- 如果不使用系统自带stack存放tree node - 难点
    - stack结构来实现回溯

##### 二叉树迭代器实现方法
- Stack模拟递归
    - Time: O(N), Space: O(N)
- Morris遍历 - 线索树
    - Time: O(N) 但是常数大，比较慢 Space: O(1)
- 递归实现    
```
void dfs(Node v){
    if(v==null) return;
    dfs(v.left);
    <do something>
    dfs(v.right);
}
```    

```
// stack栈顶 存放当前节点

```

#### 二叉树 DFS和分治
- DFS是通过深度优先遍历所有节点
- 分治是通过孩子的结果来解决parent的问题
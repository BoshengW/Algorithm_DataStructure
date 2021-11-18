### Tree 
- 图论中的树可分为两种
    - 无根树，没有一个固定根节点，每一个节点都可以作为根
    - 有根树，存在一个固定的根节点
#### 本章内容 - 有根树 - 有根二叉树

#### 二叉树的基本定义
- 根节点: 树中最上面那个点
- 父亲节点(parent): 从该节点到根路径上的第二个节点
    - 根节点没有父亲节点
- 祖先(ancestor): 一个结点到根路径上，除它本身外前面的节点集合
    - 根节点没有祖先 
- 后代(descendant):子节点和子节点的后代
- 叶子节点: 没有子节点的节点
- 树高
- 前驱节点
- 后继节点

#### 常见二叉树
- BST: 中序遍历有序的二叉树
- 完整二叉树:每个节点的子节点只能0/2
- 完全二叉树:只有最下层两层节点度数可以<=2 
- 平衡二叉树
- 完美二叉树(满二叉树):所有叶子节点深度均相等的二叉树

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
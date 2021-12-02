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

#### 二叉树问题求解思路 - DFS和分治

##### 二叉树DFS通常可以用分治递归进行处理
- DFS在二叉树中通常解决一些搜索(最值，路径)问题
- 分治在二叉树通常解决一些结构更新(判断BST,flattern, invert, rotate)从子树更新更为简单易懂
Note:
    - 两种算法思想不同
        - 分治依赖子问题返回的结果
        - DFS只是单纯递归可以无返回值
```
//分治
private <Object> dc(TreeNode root) {
    <Object> res = new <Object>;
    if(root==null) return res;

    <Object> l = dc(root.left);
    <Object> r = dc(root.right);

    <一系列操作整合子问题到res>
    
    return res; 
}
```

```
//DFS
private void dfs(TreeNode root) {
    if(root==null) return;
    
    <保存当前结果 或者 做某些操作>
    dfs(root.left)
    dfs(root.right)
}
```

#### 二叉树序列化
- 序列化
    - 序列化: Object -> String(byte)
    - 反序列化: String -> Object
- 为什么需要序列化:
    - 可持久化保存，内存中的Object断电会消失
        - 需要通过序列化将内存中的Object保存到硬盘或者其他地方
    - 网络或者数据传输时
        - 不能将Java语言Object进行传输 - 对方无法识别
        - 只能通过序列化成字符串数据流

#####常见序列化方式
- 数组 -> "[1,2,3]"
- 链表 -> "1->2->3"
- HashMap -> "{\"key\": \"value\" }"
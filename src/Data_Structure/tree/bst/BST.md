#### Binary Search Tree
- 要点
    - LeftNode.val < root.val ; RightNode.val >= root.val
        - Note: 相等情况左右都可以，根据需求来确定
    - 中序遍历有序 -左根右
- 查看BST高度时间复杂度
    - 最坏O(n) - 链式树结构
    - 最好O(logn) - 只有平衡二叉树是这个 BBST
 
 
##### Balanced Binary Search Tree
- 定义：
    - 比较平衡的二叉树: 左右高度差<=1
    - 空树也是平衡二叉树
    
##### BST基本操作
- Build - LintCode 1359
- Insert - LintCode 85
- Search - LintCode 1524
- Delete - LintCode 701
- Iterate - LintCode 86

#### BBST 应用 - 红黑树 Red-Black Tree
- 红黑树是一种BBST
    - Java -> TreeMap, TreeSet底层红黑树
        - Java 1.8 HashMap实现用到了TreeMap和LinkedList
    - Python 标准库没有用到，第三方有
- Time Complex
    - O(logN) - 增删改查
    - O(logN) - 实现找最大找最小
    - O(logN) - 实现找比某个数小的最大值或比某个数大的最小值
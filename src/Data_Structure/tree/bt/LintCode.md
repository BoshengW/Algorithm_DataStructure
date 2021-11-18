### 二叉树题目
#### 寻找前驱节点
- inorder

- iterator
    - with stack
        - Time: O(N), Space: O(N)
```
public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
    // write your code here
    Stack<TreeNode> stack = new Stack<>();
    while(root!=null) {
        stack.push(root);
        root = root.left;
    }
    TreeNode pre = null;
    while(!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if(node.val==p.val) return pre;
        else {
            pre = node;
            node = node.right;
            while(node!=null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
    return null;
}
```
- recursion

```

```

#### 寻找后继节点
```

```

#### 前序遍历
- 递归

- 迭代器
    - 前序遍历每一次pop 根节点时将左右儿子放入stack(先右再左 - 因为LIFO)
    - Time: O(#Node), Space: O(#Node) 
```
private TreeNode next() {
    TreeNode node = stack.pop();
    if(node.right!=null) stack.add(node.right);
    if(node.left!=null) stack.add(node.left);
    return node;
}
```

#### 中序遍历
- 递归

- 迭代器
    - 中序遍历先将最左节点路径加入，然后依次pop
        - 如果pop的节点是一个中节点(根节点) - (假如有右儿子) 则将右儿子左子树路径加入
        - 如果pop节点是叶子节点，直接pop即可
    - Time: O(#Node), Space: O(#Node)
```
public TreeNode next() {
    // write your code here
    TreeNode res = stack.pop();
    TreeNode node = res;
    if(node.right!=null) {
        node = node.right;
        while(node!=null) {
            stack.add(node);
            node = node.left;
        }                         
    }
    return res;
}
```

#### 后序遍历
- 递归

- 迭代器 - 难点
    - 因为后序是左右根顺序，那么每一次如果pop根节点时
        需要考虑左右子树是不是已经访问过了，如果没有就需要将左右子树加入
    - 需要保存一些记忆性信息 - prev/visited
    - Time: 
```

```

#### Morris算法 - 线索树

#### 层序遍历
- BFS层级遍历
```
public List<List<Integer>> levelOrder(TreeNode root) {
    // write your code here

    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();
    if(root==null) return res;

    // init
    queue.offer(root);
    
    while(!queue.isEmpty()) {
        int size = queue.size(); // current level nodes size
        List<Integer> tmp = new ArrayList<>();
        for(int i=0; i<size; i++) {
            TreeNode node = queue.poll();
            tmp.add(node.val);
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right); 
        }
        res.add(tmp);
    }

    return res;

}
```
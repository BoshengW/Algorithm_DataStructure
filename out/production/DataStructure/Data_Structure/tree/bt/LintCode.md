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
#### 寻找后继节点


#### 前序遍历
- 递归

- 迭代器
    - 前序遍历每一次pop 根节点时将左右儿子放入stack(先右再左 - 因为LIFO)
    - Time: O(#Node), Space: O(h) 
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
    - Time: O(#Node), Space: O(h)
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

#### Zigzag Level Order Traversal
- BFS层级遍历
```
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    // write your code here
    Stack<TreeNode> stack =  new Stack<>();
    Deque<TreeNode> queue = new ArrayDeque<>();
    boolean re = false; // reverse direction

    List<List<Integer>> res = new ArrayList<>();
    if(root==null) return res;

    queue.offer(root);
    // stack.push(root);
    while(!queue.isEmpty() || !stack.isEmpty()) {
        List<Integer> level = new ArrayList<>();

        if(!re) {
            // general direction 
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = queue.poll(); // LILO
                level.add(curr.val);
                // System.out.print(" " + curr.val);
                if(curr.left!=null) stack.push(curr.left);
                if(curr.right!=null) stack.push(curr.right);
            }
            res.add(level);
            re = true; // next level reverse
        } else {
            int size = stack.size();
            for(int i=0; i<size; i++) {
                TreeNode curr = stack.pop(); // LIFO
                level.add(curr.val);
                // System.out.print(" " + curr.val);
                if(curr.right!=null) queue.addFirst(curr.right);
                if(curr.left!=null) queue.addFirst(curr.left);
            }
            res.add(level);
            re = false; // next level general
        }
    }

    return res;
}
```

#### 寻找所有路径
- Divide & Conquer
    - 从后往前添加节点
- Time: O(N + N/2 + N/4 + ...) = O(N)
- Space: O(N^2) + O(N)栈空间
```
public List<String> binaryTreePaths(TreeNode root) {
    // write your code here
    List<String> res = new ArrayList<>();
    res = dq(root);
    return res;

}

private List<String> dq(TreeNode root) {
    List<String> res = new ArrayList<>();
    if(root==null) {
        return res;
    }
    if(root.left==null && root.right==null) {
        res.add(root.val+"");
        return res;
    }

    List<String> leftPaths = dq(root.left);
    List<String> rightPaths = dq(root.right);
    
    for(String path: leftPaths) {
        res.add(root.val + "->" + path);
    }

    for(String path: rightPaths) {
        res.add(root.val + "->" + path);
    }

    return res;
}
```

- DFS
    - 从前往后添加节点
- Time: O(N) 每一个节点遍历了一次
- Space: O(N) 最坏情况 如果平衡二叉树 O(logN)
```
public List<String> binaryTreePaths(TreeNode root) {
    // write your code here
    List<String> paths = new ArrayList<>();
    dfs(root, "", paths);
    return paths;
}

private void dfs(TreeNode root, String path, List<String> paths) {
    if(root==null) return;
    if(root.left==null && root.right==null) {
        path = path + root.val + "->";
        // System.out.println(path);
        paths.add(path.substring(0,path.length()-2));
        return;
    }

    path = path + root.val + "->";
    if(root.left!=null) dfs(root.left, path, paths);
    if(root.right!=null) dfs(root.right, path, paths);
}
```

#### 判断平衡二叉树
- 分治思想，从下到上检测左右子树是否平衡 & diff(左,右)<=1
    - 建立Object记录max heigt & isBalanced
    - Note: 为什么不用存储 min height? 有没有可能 max height - min height > 1 但是 max height - max height <=1 
        - 如果左右子树都是平衡的话，那么不可能存在这种情况
        推导: 如果一个树平衡 max - min <=1, max = min or max = min+1
            -  如果 max1 - min2 > 1 => max1 - (max2) > 1 或者 max1 - max2 + 1 > 1 
            -  max1 - max2<=1 
            
#### 判断BST
- 分治
            


#### 检测二叉树最大深度
- 分治思想，从下往上找最大深度
- Time: O(N) 每一个节点遍历一遍, Space: O(N)
```
private int dq(TreeNode root) {
    if(root==null) return 0;

    int lh = dq(root.left);
    int rh = dq(root.right);

    return Math.max(lh, rh) + 1;
}
```
####二叉树中最接近target的节点
- 分治法
    - Time: O(N), Space: O(N)

```
private int dq(TreeNode root, double target) {
    if(root==null) return Integer.MIN_VALUE;

    int l = dq(root.left, target);
    int r = dq(root.right, target);

    int res = root.val;
    
    if(l!=Integer.MIN_VALUE && Math.abs(res-target)>Math.abs(l-target)) res = l;
    if(r!=Integer.MIN_VALUE && Math.abs(res-target)>Math.abs(r-target)) res = r;

    return res;
}
```
- DFS 遍历所有节点找最接近的
- 最优解 BST二分寻找上下边界 - 前驱后驱背向双指针
    - Time: 普通BST O(h) 树高, 平衡二叉树 O(logN)
    
#### Flatten Binary Tree to Linked List
- 分治思想: 从叶子节点先flatten 左右叶子,将生成的局部链表的最后一个节点返回给上面(最后一个节点用来拼接左右分支)
    - Time: O(N), Space: O(N)
```
private TreeNode dq(TreeNode root) {
    if(root==null) return null;

    TreeNode l = dq(root.left);
    TreeNode r = dq(root.right);

    // root
    if(root.left==null) {
        // 没有左节点，直接将右节点末尾返回
        return r==null? root.right: r;
    } else {
        // 有左节点
        TreeNode node = root.left;
        if(l==null) {
            // node是左边唯一一个节点
            TreeNode last = r==null? (root.right==null? node: root.right): r;
            node.right = root.right;
            root.right = node;
            root.left=null;
            return last;
        } else {
            // node不是左边唯一一个点
            TreeNode last = r==null? (root.right==null? l: root.right): r;
            l.right = root.right;
            root.right = node;
            root.left = null;
            return last;
        }
    }
}
```
#### Find Kth smallest in BST (在BST高频变化的情况下，如何优化)
- in-order 迭代器
    - Time: O(k), Space: O(N)
```
public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    while(root!=null) {
        stack.push(root);
        root = root.left;
    }
    int res = -1;
    while(k>0) {
        TreeNode curr = stack.pop();
        res = curr.val;
        if(curr.right!=null) {
            curr = curr.right;
            while(curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }
        } 
        k--;
    }   
    return res;
}
```

#### 进阶: Closest Binary Search Tree Value II


#### LCA of Binary Tree
- 分治思想
    - 左右分治汇总，那边找到返回那边给上面，如果两边都找到返回当前节点(就是LCA)
- Time: O(N), Space: O(h)
```
private TreeNode dq(TreeNode root, TreeNode A, TreeNode B) {
    if(root==null) return null;

    TreeNode l = dq(root.left, A, B);
    TreeNode r = dq(root.right, A, B);

    // root is A/B return
    if(root.val==A.val || root.val==B.val) {
        return root;
    }
    // 左右都找到了
    if(l!=null && r!=null) {
        return root;
    }

    // 只有左边找到了(或者左边两个都找到了)
    //只有右边找到了(或者右边两个都找到了)
    return l!=null? l: (r!=null? r: null);
}
```

#### Find larget sum/avg subtree
- 分治思想
    - 建立一个object保存sum/avg 然后分治打擂台


#### Invert Binary Tree
- 分治思想
    - 从下到上依次左右换
```
private TreeNode dq(TreeNode root) {
     if(root==null) return null;
 
     TreeNode l = dq(root.left);
     TreeNode r = dq(root.right);
     
     root.left = r;
     root.right = l;
 
     return root;
 }
```

#### Validate BST
- 分治思想
    - 不是BST条件：mid<=left or mid>=right or mid<=left.max or mid>=right.min
    - 证明后面两个条件正确性：是BST -> mid>left.max 保证mid比左边所有值都大，mid<right.min 保证mid比右边所有值都小
- 这个分治不仅要考虑局部BST性质，还要维护跨层级的BST性质

```
private Result dq(TreeNode root) {
    Result res = new Result(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
    if(root==null) return res;

    Result l = dq(root.left);
    Result r = dq(root.right);

    // all nodes in left subtree should < mid
    // all nodes in right subtree should > mid 
    if(!l.bst || !r.bst) res.bst = false;
    if(root.right!=null && (root.val>=root.right.val || root.val>=r.min)) res.bst = false;
    if(root.left!=null && (root.val<=root.left.val || root.val<=l.max)) res.bst = false;

    res.max = Math.max(Math.max(root.val, r.max), l.max);
    res.min = Math.min(Math.min(root.val, r.min), l.min);

    return res;
}

```

#### Search Rango in BST
- DFS思想
    - 中序遍历一遍，找到满足条件的
    - 剪枝优化: 根据BST性质，[k1,k2]之外的节点没有比较进行左右延申
```
private void dfs(TreeNode root, int k1, int k2) {
    if(root==null) return;

    // root > k1 [k1, ... root, ... k2] 可以再向左试探一下
    if(root.val>k1) dfs(root.left, k1, k2);
    if(root.val<=k2 && root.val>=k1) res.add(root.val);
    // root < k2 [k1, ... root, ... k2] 可以再向右试探一下
    if(root.val<k2) dfs(root.right, k1, k2);

}
```
- 分治思想(很慢)
    - 将左右满足条件的保存在list返回，上面整合左右两个list
    

#### Serialize and Deserialize Binary Tree
- 将完美二叉树数组转化为二叉树结构
- 分治思想: 根据数组index,从下到上建立树结构
    - Time:
        - 二叉树编码: BFS - O(N) #nodes of tree
        - 二叉树解码: 分治 - O(logN) 
    - Space:
        - 二叉树编码：BFS - queue - O(2^(h-1)) 叶子节点个数2^(h-1)
        - 二叉树解码: 分治 - stack - O(h) - 完美二叉树 - O(logN);
```
// 层级遍历编码成完美二叉树
public String serialize(TreeNode root) {
    // return a perfect BT
    String res = "";
    if(root==null) return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int h = getH(root);

    while(h>0) {
        int size = queue.size();
        for(int i=0; i<size; i++) {
            TreeNode node = queue.poll();
            if(node==null) {
                res += (" " + "#"); // add curr as #
                queue.offer(null); // add left child
                queue.offer(null); // add right child
            } else {
                res += (" " + node.val); // add curr val
                if(node.left!=null) queue.offer(node.left);
                else queue.offer(null);

                if(node.right!=null) queue.offer(node.right);
                else queue.offer(null);
            }
        }
        h--;
    }
    return res.substring(1);

}

private int getH(TreeNode root) {
    if(root==null) return 0;

    int l = getH(root.left);
    int r = getH(root.right);

    return Math.max(l, r) + 1;
}

// 将数组转化为树结构，分治可以
public TreeNode deserialize(String data) {
    if(data.equals("")) return null;
    String[] arr = data.split(" ");
    return arr2Tree(arr, 0);
}

private TreeNode arr2Tree(String[] arr, int idx) {
    TreeNode curr = null;
    if(idx>=arr.length) return curr;
    // if(2*idx+1>=arr.size()) {
    //     // child not exist in arr; which mean it's left node
    //     if(arr.get(idx).equals("#")) return curr;

    //     int val = String.parseInt(arr.get(idx));
    //     curr = new TreeNode(val);
    //     return curr;
    // }

    TreeNode l = arr2Tree(arr, 2*idx+1);
    TreeNode r = arr2Tree(arr, 2*idx+2);
    
    if(arr[idx].equals("#")) return curr;
    
    int val = Integer.parseInt(arr[idx]);
    curr = new TreeNode(val);
    if(l!=null) curr.left = l;
    if(r!=null) curr.right = r;

    return curr;
}
```
    
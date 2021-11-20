### BST 题目

#### 求前驱节点

#### 求后驱节点

#### BST-LCA
- 减治思想
    - 如果两个都比root大 - 往root右边找
    - 如果两个都比root小 - 往root左边找
    - 如果两个一个大一个小或者有一个等于root那么返回root - LCA
- BST性质优化了LCA算法的时间 
    - Time; O(logN), Space: O(logN)
```
private TreeNode dc(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null) return root;

    if(p.val<root.val && q.val<root.val) {
        return dc(root.left, p, q);
    }else if(p.val>root.val && q.val>root.val) {
        return dc(root.right, p, q);
    }else {
        // 一大一小或者某一个等于当前root
        return root;
    }
}
```


#### 寻找接近target的前驱和后继节点 - 仅适用于BST
```
while(root!=null) {
      if(root.val<target) {
          // 会是target的前驱节点但不一定往右找看有没有更接近的
          pre.push(root);
          root = root.right;
      } else {
          // 会是target后继或者它本身但不一定往左边找更接近的
          post.push(root);
          root = root.left;
      }
  } 
```


#### 在BST上做two sum
- 利用前后驱节点来做二叉树上的双指针 - 有了前后驱算法就可以对BST进行指针的任何操作了
    - Note: 只有求解BST前后驱节点的时候space: O(1) 如果在普通二叉树中是要O(h)
```
// 暴力加二分
// 或者使用双指针 - 一个找后驱，一个找前驱
// 时间 O(N*h) 空间 O(1)
public int[] twoSum(TreeNode root, int n) {
    // write your code here
    int[] res = new int[2];
    if(root==null) return null;

    TreeNode min = root;
    TreeNode max = root;
    // find max
    while(max.right!=null) {
        max = max.right;
    }
    // find min
    while(min.left!=null) {
        min = min.left;
    }

    TreeNode l = min, r = max;
    while(l!=r) {
        // System.out.println("l: " + l.val + ",r: " + r.val);
        if(l.val + r.val==n) {
            res[0] = l.val;
            res[1] = r.val;
            break;
        } else if(l.val+r.val<n) {
            // l find successor
            TreeNode node = root;
            l = post(node, l.val);
        } else {
            // r find predecessor
            TreeNode node = root;
            r = pre(node, r.val);
        }
        if(l==null || r==null) break;
    }

    return res;

}

private TreeNode pre(TreeNode root, int t) {
    TreeNode pre = null;
    while(root!=null) {
        if(root.val>=t) {
            // find more close to t
            root = root.left;
        } else {
            pre = root;
            root = root.right;
        }
    }

    return pre;
}

private TreeNode post(TreeNode root, int t) {
    TreeNode post = null;
    while(root!=null) {
        if(root.val<=t) {
            root = root.right;
        } else {
            post = root;
            root = root.left;
        }
    }
    return post;
}
```
package Data_Structure.tree.bst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
/**
 * CRUD 操作 - BST
 * 分裂操作 - BST
 *
 * BST一些隐藏性质:
 *  - 如果某点左子树节点没有右孩子那么这个点是该点左子树最大值点 - 最大值节点一定没有右孩子 - 如果有右孩子就不是最大
 *  - 如果某点右子树节点没有左孩子那么这个点是该点右子树最小值点 - 最小值节点一定没有左孩子 - 如果有就不是最小
 * */
public class BST {

    private int length;
    private TreeNode root;

    public BST() {
        this.length  = 0;
        // default TreeNode is null pointer
    }
    /**
     * Search a value in BST
     * */
    // 递归写法 - O(logN)
    public TreeNode search(TreeNode root, int val) {
        if(root==null) return null;

        if(root.val>val) return search(root.left, val);
        else if(root.val<val) return search(root.right, val);
        else return root;
    }

    // 迭代写法 - O(logN)
    public TreeNode iterSearch(TreeNode root, int val) {
        if(root==null) return null;
        TreeNode curr = root;
        while(curr!=null) {
            if(curr.val<val) curr=curr.right;
            else if(curr.val>val) curr=curr.left;
            else return curr;
        }
        return curr;
    }

    /**
     * Add value in BST
     * return new tree root
     * - BST插入新值，通常是在叶子节点插入，不会在原结构内部插入
     * - 这样会存在隐患时，多次插入后会导致BST不平衡，比如在[10, 9] 插入[8,5,4,3]这些节点会会让左子树很深
     * */
    public TreeNode add(TreeNode root, TreeNode node) {
        if(root==null) return node;

        // node 应该插在root右边
        if(root.val<node.val) root.right = add(root.right, node);
        else if(root.val>node.val) root.left = add(root.left, node);

        return root;
    }

    public TreeNode iterAdd(TreeNode root, TreeNode node) {
        if(root==null) return node;

        TreeNode curr = root;
        while(curr!=null) {
            if(curr.val>node.val) {
                // 应该插左边
                if(curr.left==null) {
                    // left空闲可插
                    curr.left = node;
                    break;
                } else {
                    // 当前left不空闲往下找
                    curr = curr.left;
                }
            } else if(curr.val<node.val) {
                if(curr.right==null) {
                    curr.right = node;
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
        return root;
    }

    /**
     * Update a value in BST
     * */
    public void update(int val) {
        // 删除node
        // 再插入该node
    }

    /**
     * Remove a value in BST - 难点
     * 删除会有以下几个可能性
     *  - 删除叶子节点 - easy直接删
     *  - 删除只有一个子节点的节点 - 将那个子节点接上去
     *  Time: O(logN+M) -> M是找到最大值点的时间复杂度
     * */
    public TreeNode remove(TreeNode root, int key) {
        // 找到 node了 开始删
        // 情况1. node是叶子节点
        // 情况2. node仅有一个子节点
        // 情况3. node有两个子节点
        // recusively find key node
        if(root==null) return null;
        if(root.val<key) root.right = remove(root.right, key);
        else if(root.val>key) root.left = remove(root.left, key);
        else {
            if(root.left!=null && root.right!=null) {
                // 有两个child
                // 找到左子树最大值点,覆盖当前root
                // 1.找到左子树最大值然后覆盖当前节点-并删除最大值原始节点 / 找到右子树最小值然后覆盖 - 并删除最小值原始节点
                // 2.找到删除点(左子树最大值点)后，将要删除的点一直右旋向下，使其变成叶子节点
                // 解法1 - 找到最大值,覆盖当前root,并让当前最大值节点parent.right=null删除该最大值
                TreeNode left = root.left;
                if(left.right==null) {
                    // 当前左子树点就是最大值点
                    root.val = left.val;
                    root.left = left.left;
                } else {
                    // 最大值点还没找到，接着向右找
                    TreeNode fast = left.right;
                    while(fast.right!=null) {
                        // 同向双指针一前一后
                        // 前找最大值点，后找parent为了后面删除覆盖
                        fast = fast.right;
                        left = left.right;
                    }
                    //此时 fast在最大值点处，left是fast parent
                    root.val = fast.val;
                    left.right = fast.left;
                }
                return root;
            } else if(root.left!=null || root.right!=null) {
                // 有一个child
                if(root.left!=null) return root.left;
                if(root.right!=null) return root.right;
            } else {
                // root left/right no child
                return null;
            }
        }

        return root;
    }

    /**
     * 第二种方法 - 通过旋转删除
     *
     * */
    public TreeNode removeRotate(TreeNode root, int key) {
        // 找到 node了 开始删
        // 情况1. node是叶子节点
        // 情况2. node仅有一个子节点
        // 情况3. node有两个子节点
        // recusively find key node
        if(root==null) return null;
        if(root.val<key) root.right = removeRotate(root.right, key);
        else if(root.val>key) root.left = removeRotate(root.left, key);
        else {
            if(root.left!=null || root.right!=null) {
                // 有两个child
                // 找到左子树最大值点,覆盖当前root
                // 解法2.找到删除点(左子树最大值点)后，将要删除的点一直右旋向下，使其变成叶子节点
                // 右旋：tmp1=root.left.right, tmp2=root.left.right->root, root.left
                if(root.left!=null) {
                    // 有左节点 - 可右旋
                    root = zig(root);
                    root.right = removeRotate(root.right, key);
                }
                if(root.right!=null) {
                    // 有右节点 - 可左旋
                    root = zag(root);
                    root.right = removeRotate(root.left, key);
                }
            } else {
                // root left/right no child
                return null;
            }
        }

        return root;
    }

    /**
     * 右旋 - zig
     * */
    public TreeNode zig(TreeNode root) {
        TreeNode left = root.left;
        // 把left的right childe给root.left
        root.left = left.right;
        // 把left.right -> root
        left.right = root;
        return left;
    }

    /**
     * 左旋 - zag
     * */
    public TreeNode zag(TreeNode root) {
        TreeNode right = root.right;
        root.right = right.left;
        right.left = root;
        return right;
    }
}



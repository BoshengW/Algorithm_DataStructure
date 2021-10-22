package Data_Structure.tree;

class TreeNode {
    /*
    * we can consider Data_Structure.tree structure is a linklist with multiple connected node
    * */

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BinaryTree {

    TreeNode tree;

    public BinaryTree(TreeNode root) {
        this.tree = root;
    }

    // Transversal
    // pre-order 先序遍历 根-左-右
    public void preOrder(TreeNode root) {
        if(root==null) {
            return;
        }
        System.out.println(root.val);
        this.preOrder(root.left);
        this.preOrder(root.right);
    }

    // in-order 中序遍历 左-根-右
    public void inOrder(TreeNode root) {
        //中序遍历
        if(root==null) {
            return ;
        } else {
            this.inOrder(root.left);
            System.out.println(root.val);
            this.inOrder(root.right);
        }
    }

    // post-order 后序遍历 左-右-根
    public void postOrder(TreeNode root) {
        //中序遍历
        if(root==null) {
            return ;
        } else {
            this.postOrder(root.left);
            this.postOrder(root.right);
            System.out.println(root.val);
        }
    }

    // ?? print a binary Data_Structure.tree with format node x:value, parent node, left node , right node



    public int sumOfLeaves(TreeNode root) {
        // base case
        if(root.left==null && root.right==null) {
            return root.val;
        }

        return sumOfLeaves(root.left) + sumOfLeaves(root.right);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node1.left = node4;

        BinaryTree tree = new BinaryTree(root);

        tree.postOrder(root);

        System.out.println(tree.sumOfLeaves(root));

    }

}

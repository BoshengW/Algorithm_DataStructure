package bst;

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

public class BST {

    private int length;
    private TreeNode root;

    public BST() {
        this.length  = 0;
        // default TreeNode is null pointer
    }

    public void add(int element) {
        TreeNode newtree = new TreeNode(element);
        this.root = insert(this.root, newtree);
        this.length += 1;
    }

    public TreeNode insert(TreeNode root, TreeNode newNode) {
        if(root==null) {
            return newNode;
        }

        // if insert val less than current root.val, insert into left
        if(newNode.val > root.val) {
            root.left = insert(root.left, newNode);
        }
        // if insert val greater than current root.val, insert into right
        if(newNode.val < root.val) {
            root.right = insert(root.right, newNode);
        }

        if(newNode.val == root.val) {
            return root;
        }

        return root;
    }

    public void printInOrder() { 
        this.printHelper(this.root);
    }

    public void printHelper(TreeNode root) {
        // print BST with InOrder
        if(root==null) {
            return;
        }

        printHelper(root.left);
        System.out.println(root.val);
        printHelper(root.right);



    }


    public static void main(String[] args) {
        BST bst = new BST();

        bst.add(1);
        bst.add(12);
        bst.add(5);
        bst.add(11);
        bst.add(1);

        bst.printInOrder();
    }

}



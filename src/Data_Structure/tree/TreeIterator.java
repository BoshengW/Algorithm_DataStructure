package Data_Structure.tree;

import java.util.Stack;

public class TreeIterator {

    private Stack<TreeNode> stack = new Stack<>();

    public TreeNode next() {

        TreeNode currNode = stack.peek(); // get latest node
        TreeNode temp = currNode;

        if(temp.right!=null) {

            temp = temp.right;
            stack.push(temp);

            // get all left node in this right node
            while(temp.left!=null) {

                stack.push(temp.left);
                temp = temp.left;

            }
        }

        return currNode;
    }

    public boolean hasNext() {
        return false;
    }

    public TreeIterator(TreeNode root) {
        //保存左子树
        while(root!=null) {
            stack.push(root);
            root = root.left;
        }
    }


}

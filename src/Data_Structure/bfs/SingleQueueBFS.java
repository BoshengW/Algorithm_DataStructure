package Data_Structure.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
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
 * Time Complexity: O(hk) -> h is height; k is node each level
 *
 * */

public class SingleQueueBFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List result = new ArrayList();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            System.out.println(size);
            for(int i=0;i<size;i++) {
                //  遍历同级所有节点并把他们下一级依次放入queue中
                TreeNode head = queue.poll();
                level.add(head.val);
                if(head.left != null) {
                    queue.offer(head.left);
                }

                if(head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode child1 = new TreeNode(4);
        TreeNode child2 = new TreeNode(3);
        TreeNode child11 = new TreeNode(6);
        TreeNode child12 = new TreeNode(11);
        TreeNode child22 = new TreeNode(12);

        root.left = child1;
        root.right = child2;
        child1.left = child11;
        child1.right = child12;
        child2.right = child22;

        SingleQueueBFS obj = new SingleQueueBFS();
        List<List<Integer>> BFS_Level = obj.levelOrder(root);
        System.out.println(BFS_Level);


    }

}

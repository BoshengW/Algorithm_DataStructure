package graph.bfs;

import java.util.ArrayList;
import java.util.List;
/**
 * Time Complexity: O(hk) -> h is height; k is node each level
 *
 * */
public class DoubleQueueBFS {
    // more brief than singleQueue, but slower
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) {
            return result;
        }

        // make two queue to save current + prev level Node
        // since no need to pop val from top, regular arraylist can do it
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            ArrayList<TreeNode> newQueue = new ArrayList<>();

            List<Integer> level = new ArrayList<>();
            for(TreeNode currLevelNode: queue) {
                level.add(currLevelNode.val);

                if(currLevelNode.left!=null) {
                    newQueue.add(currLevelNode.left);
                }

                if(currLevelNode.right!=null) {
                    newQueue.add(currLevelNode.right);
                }
            }

            result.add(level);
            // add next level nodes into new queue
            queue = newQueue;

        }
        return result;
    }
}

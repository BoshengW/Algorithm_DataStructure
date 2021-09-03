package graph.bfs;

/**
 * Time Complexity: Linear time O(n): N is nodes in tree or graph
 * Idea of this algorithm is that we make a dummy哨兵节点 to mark end of each level
 *
 * 优点：相比较通过单双队列，可以少写一层循环
 * */
public class DummyNodeBFS {
    /**
     * 思路：遍历整个Tree,如果没碰到dummy 说明层遍历没有结束继续往队列里面加点
     * 如果碰到dummynode，则把记录node的list加到result里然后再重置这个list
     * 然后此时应该已经把下一层所有的node加好了，那么在queue最后在加上dummyNode继续遍历
     * */


}

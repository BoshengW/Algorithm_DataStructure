package graph;

import java.util.*;

class DirectedGraphNode {
    private int label;
    private int val;
    private List<DirectedGraphNode> neighbors;

    public DirectedGraphNode(int label, int val) {
        this.label = label;
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(DirectedGraphNode neighborNode) {
        this.neighbors.add(neighborNode);
    }
}

/**
 * Graph can also design like HashMap+Hashset
 * Map<T, Set> = new HashMap<Integer, HashSet>();
 *
 * */
public class GraphTable {

    public static void main(String[] args) {
        String a = "hello";
        int[][] b = {{1,2}, {3,4,3},{1}};
        b[0][0] =2;
        System.out.println(b[0].length);
    }



}

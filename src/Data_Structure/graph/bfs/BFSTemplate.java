package Data_Structure.graph.bfs;

import java.util.*;

public class BFSTemplate {
    private void bfs(List<Node> graphNode) {
        // 如果对于无向图可以找起点作为起始点
        //Node firstNode = findFirstNode(graphNode);
        // 如果对于DAG可以找入度为0点作为起始点
        // -- Step 1. init the Data_Structure.queue for BFS and hashset for visited node checking
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        // -- Step 2. add first node inside
        Node firstNode = graphNode.get(0);
        queue.offer(firstNode);
        visited.add(firstNode);

        // --Step 3. BFS loop
        while(!queue.isEmpty()) {
            Node currNode = queue.poll();
            // add logic for node checking

            for(Node neighbor: currNode.neighbors) {
                if(!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
    }

    // use for adding in-degree of the DAG (for un-directed Data_Structure.graph, no need to calculate in-degree)
    private Node findFirstNode(List<Node> graph) {
        HashMap<Node, Integer> inDegree = new HashMap<>();
        for(Node node: graph) {
            inDegree.putIfAbsent(node, 0);
            for(Node neighbor: node.neighbors) {
                inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        for(Node node: inDegree.keySet()) {
            // return in-degree == 0 node
            if(inDegree.get(node)==0) return node;
        }
        return null;
    }

}

class Node {
    int val;
    List<Node> neighbors;

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

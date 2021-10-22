package Data_Structure.graph;

import java.util.*;

public class Solution {

    public HashMap<Integer, List<Integer>> getAllNodesMap(int[][] seqs, HashMap<Integer, Integer> inDegree) {
        HashMap<Integer, List<Integer>> nodeMap = new HashMap<>();
        for(int[] seq: seqs) {
            for(int i=0; i<seq.length;i++) {
                nodeMap.put(seq[i], nodeMap.getOrDefault(seq[i], new ArrayList<>()));
                inDegree.put(seq[i], inDegree.getOrDefault(seq[i], 0));

                if(i>=1) {
                    // add i+1 into i node list as child
                    nodeMap.get(seq[i-1]).add(seq[i]);
                    inDegree.put(seq[i], inDegree.get(seq[i])+1);
                }

            }
        }

        return nodeMap;
    }


    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        // different with previous top sorting the seqs allow [1,2,3,4] sub-seq size >= 2

        // step 1. convert seqs into hashmap <node, <node child>> & in-degree
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> nodeMap = getAllNodesMap(seqs, inDegree);


        // step 2. put all in-degree 0 into Data_Structure.queue
        Queue<Integer> queue = new ArrayDeque<>();
        for(int key: inDegree.keySet()) {
            System.out.println(key);
            System.out.println(inDegree.get(key));
            System.out.println(nodeMap.get(key).size());
            System.out.println("+++++++++++++++++");
            if(inDegree.get(key)==0) {
                queue.offer(key);
            }
        }
        // step 3. loop check node is unique
        List<Integer> topSort = new ArrayList<>();
        int index = 0;

        while(!queue.isEmpty()) {

            int currNode = queue.poll();
            if(queue.size()>0 || currNode!=org[index]) {
                // if node in Data_Structure.queue is not unique then too Basic_Algorithm.sort shouldn't unique
                return false;
            }

            topSort.add(currNode);
            index++;

            for(int neighbor: nodeMap.get(currNode)){
                // list all neighbor
                inDegree.put(neighbor, inDegree.get(neighbor)-1);
                if(inDegree.get(neighbor)==0) {
                    queue.offer(neighbor);
                }
            }

        }
        if(topSort.size()==org.length) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        int[][] seqs = {{5,3,2,4},{4,1},{1},{3},{2,4},{1,1000000}};
//        int[] org = {5,3,2,4,1};

        int[][] seqs = {{1}, {2,3}, {3,2}};
        int[] org = {1};
        Solution obj = new Solution();

        HashSet<Character> set = new HashSet<>();
        set.add('c');
        set.add('e');
        set.add('a');

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('c',1);
        map.put('a',2);
        map.put('e',3);
        String a= "abc";

        System.out.println(a + 'c' + 's');

        System.out.println(set);
        for(char key: set) {
            System.out.print(key);
        }
        obj.sequenceReconstruction(org, seqs);

        Queue<Integer> queue = new PriorityQueue<>();

    }


}
package Data_Structure.set;

import java.util.*;
public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a Data_Structure.set of string
     * @return: a list of lists of string
     */

    // BFS 解法
    class WordPath {
        String currWord;
        List<String> path;
        Set<String> visited;

        public WordPath(String currWord, List<String> path, Set<String> visited) {
            this.currWord = currWord;
            this.path = path;
            this.visited = visited;
        }
    }


    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here

        Map<String, List<String>> wordMap = getGraph(dict);
        List<List<String>> res = new ArrayList<>();

        // Step 1. Data_Structure.queue init for word, Data_Structure.set init for visited
        Queue<WordPath> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        // Add first node
        WordPath node = new WordPath(start, new ArrayList<String>(), new HashSet<String>());
        node.visited.add(start);
        node.path.add(start);

        queue.offer(node);
        visited.add(start);

        // Step 2. BFS traversal - BFS
        while(!queue.isEmpty()) {
            WordPath curr = queue.poll();
            for(String neighbor: wordMap.get(curr.currWord)) {
                // generate new class and add path of neighbor node
//                if (!visited.contains(neighbor)) {
                if (!curr.visited.contains(neighbor)) {
                    List<String> copyPath = new ArrayList<>(curr.path);
                    copyPath.add(neighbor);
                    Set<String> copyVisited = new HashSet<>(curr.visited);
                    copyVisited.add(neighbor);
                    WordPath newNode = new WordPath(neighbor, copyPath, copyVisited);
                    queue.offer(newNode);

                    if (neighbor.equals(end)) {
                        // check if this path is shortest
                        if (res.size() == 0) {
                            // first one must be shortest in BFS
                            res.add(newNode.path);
                        } else {
                            // exist shortest
                            if (newNode.path.size() == res.get(0).size()) {
                                res.add(newNode.path);
                            }
                        }
                    }
                }
            }
//            }
        }
        System.out.println(res.size());
        return res;
    }



    private Map<String, List<String>> getGraph(Set<String> dict) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word: dict) {
            map.put(word, new ArrayList<>());
            for(String transWord: dict) {
                if(!transWord.equals(word) && canTransfer(word, transWord)) {
                    map.get(word).add(transWord);
                }
            }
        }

        return map;
    }

    private boolean canTransfer(String a, String b) {
        char[] list = a.toCharArray();
        char[] lista = b.toCharArray();
        int changeNum = 0;
        int start = 0;

        if(list.length!=lista.length) {
            return false;
        }

        while(start<list.length) {
            if(list[start]!=lista[start]) {
                changeNum++;
            }
            start++;
        }
        return changeNum==1? true: false;
    }

    public static void main(String[] args) {
        Set<String> testcase = new HashSet<>();
        testcase.add("hot");
        testcase.add("dot");
        testcase.add("dog");
        testcase.add("lot");
        testcase.add("log");
        testcase.add("hit");
        testcase.add("cog");

        Solution obj = new Solution();
        obj.findLadders("hit", "cog", testcase);
    }
}
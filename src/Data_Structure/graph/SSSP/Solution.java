package Data_Structure.graph.SSSP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    // 单源最短路径有限制路径长度 - 这道题暴力搜索会超时 - 贪心
    // 贪心，最后的最优解要保证stop很小并且price很小，这样
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 建图
        int[][] graph = new int[n][n];
        for(int[] i: graph) {
            Arrays.fill(i, -1);
        }

        for(int[] f: flights) {
            graph[f[0]][f[1]] = f[2];
        }

        // visited map： key->city, value-current min stops
        HashMap<Integer, Integer> visited = new HashMap<>();

        // PQ -> [node, stops, dist of node (不一定最小)]
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2]-y[2]);
        pq.offer(new int[]{src, 0, 0});

        while(!pq.isEmpty()) {

            int[] cur = pq.poll();
            int price  = cur[2], city = cur[0], stops = cur[1];
            visited.put(city, stops);

            if(city==dst) return price;
            if(stops==k+1) continue;

            for(int i=0; i<n; i++) {
                // 遍历所有邻居
                if(graph[city][i]==-1) continue;
                if(!visited.containsKey(i) || visited.get(i)>stops) {
                    pq.add(new int[]{i, stops+1, price+graph[city][i]});

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[][] t = {{0,1,100},{1,2,100},{0,2,500}};
        obj.findCheapestPrice(3,t,0,2,0);
    }
}

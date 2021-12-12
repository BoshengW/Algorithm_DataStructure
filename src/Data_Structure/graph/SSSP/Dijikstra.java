package Data_Structure.graph.SSSP;

import java.util.*;

class Dijikstra {
    // 单源最短路径有限制路径长度 - 这道题暴力搜索会超时 - 贪心
    // 贪心，最后的最优解要保证stop很小并且price很小，这样
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 建图
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] flight: flights) {
            graph.computeIfAbsent(flight[0], x->new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // --- 两种情况需要考虑1.代价最少路径也是stop最少-理想情况 2.满足stop限制的最少路径不是代价最少的
        // price 数组
        int[] price = new int[n+1];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src] = 0;

        // stop数组保存source到当前节点最少的stop
        int[] stop = new int[n+1];
        Arrays.fill(stop, Integer.MAX_VALUE);
        stop[src] = 0;

        // // visited数组
        // boolean[] visited = new boolean[n+1];

        // pq -> [cur node, stop# ,cur low price] 加入当前停的点 如果停的stop>k那么不加入pq
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[2]-y[2]);
        pq.offer(new int[]{src, 0, 0});


        while(!pq.isEmpty()) {

            int[] cur = pq.poll();

            // 这道题不能使用visited因为会存在不是最短但是stop达标的情况
            // if(visited[cur[0]]) continue;
            // visited[cur[0]] = true;
            if(cur[0]==dst) return cur[2]; // 满足条件最先出来的一定是最少代价

            // stop exceed
            if(cur[1]==k+1) continue;

            for(int[] edge: graph.getOrDefault(cur[0], new ArrayList<>())) {
                // if neighbor not visited and find lower price - update
                // better cost
                if(price[edge[0]]>cur[2]+edge[1]) {
                    price[edge[0]] = cur[2]+edge[1];
                    pq.offer(new int[]{edge[0], cur[1]+1, price[edge[0]]});
                    // better stop
                } else if(stop[edge[0]]>cur[1]+1){
                    // don't update but offer into pq
                    pq.offer(new int[]{edge[0], cur[1]+1, cur[2]+edge[1]});
                }
                stop[cur[0]] = cur[1]; // price少的会先更新这个值，price大但是stop少的会后更新，stop结果会(price更小) <-> (stop更小)之间来回交换
            }



        }

        return price[dst]==Integer.MAX_VALUE? -1: price[dst];
    }
}

### 有非负权图的最短路径 - Dijikstra
- 非负权图: 每一条边的权重>=0
#### 典型例题
- 模板题 Leetcode 743
- Leetcode 743, 787

#### 几个要点
- visited[] 来判断节点之前是否访问过
    - 如果访问过说明该点最优解已经给出了，后面无需查看
- 有些题目会有一些变种 - 比如限制路径长度，这时不能单纯用visited来进行过滤
    - 还需要对路径长度更小的选项继续放进PQ进行求解
    
#### 模板要素
- PQ -> 保存要遍历的点和他的dist
- dist[] -> 保存每个节点的最优解
- visited[] -> 确定是否每个节点都遍历过
- graph[][] -> 根据要求建图

#### Dijikstra 朴素版本 
- 基本逻辑
    1. 根据数据进行建图 (稀疏-邻接表，稠密-邻接矩阵)
    2. 建立 dist[]/HashMap<node, Integer> 保存当前node到source的最短距离
        - 如果无法到达则设为 Integer.MAX_VALUE
        - source的 dist => 0
    3. 将所有graph nodes加入Set - 所有nodes
    4. 循环 loop
        - loop 找到当前dist最短那个点 - 从set去除
            - 如果当前dist最短的点是Integer.MAX_VALUE那么跳出loop说明没有点可以到达source
        - loop 这个点node的neighbours - 比较这些点当前dist和从node到这些点的距离那个短，更新距离
        !!!-注意：这里可能会导入重复节点
            - 举例: 2->1->4, 2->3->4 当poll node3时会添加node4进入, 当poll node1时也会添加node4进入,这时node4被加入了两次
    5. 最后返回的dist[] 就是从source到每一个点的最短距离

- 时空复杂度 (Edge边个数 - E， 节点个数vertex - V)
    - Time: O(V*V)
    - Space: O(V*V + V) -> graph space + dist space

```
// 建图
int[][] graph = new int[n][n];

// init
for(int[] i: graph) {
    Arrays.fill(i, -1);
}

for(int[] edge: edges) {
    graph[edge[0]][edge[1]] = edge[2];
    // graph[edge[1]][edge[0]] = edge[2]; // 如果是无向图
}

// 各节点的距离矩阵 
int[] dist = new int[n];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[source] = 0;

// 保存所有节点进set
HashSet<Integer> set = new HashSet<>();
for(int i=1; i<n; i++) set.add(i);

// Dijikstra
while(!set.isEmpty()) {
    // 找当前距离最短点 - 可优化部分
    int min = Integer.MAX_VALUE;
    int cand = -1;
    for(int node: set) {
        if(dist[node]<max) {
            min = dist[node];
            cand = node; 
        }
    }
    
    // 找到与否
    if(cand==-1) break;
    
    set.remove(cand);
    for(int i=1; i<n; i++) {
        // 找邻居
        if(set.contains(i) && graph[cand][i]!=-1) {
            // 更新neighbor 距离
            dist[i] = Math.min(dist[i], dist[cand] + graph[cand][i]);
        }
    }
}

// 出循环后 - check是否source能到达所有点
for(int i=1; i<n; i++) {
    if(dist[i]==Integer.MAX_VALUE) return false;
}

return true;
```    

#### Dijikstra 优化版本 - heap
- 朴素版本: 求距离最小值点时都是使用暴力求解 - O(V)
- 改进: 如果使用heap保存所有节点那么可以在O(logV)去除距离最小点

```
// 建图 - 通过HashMap建立邻接表 key-node: value[0]: end node, value[1] edge
HashMap<Integer, List<int[]>> graph = new HashMap<>();
for(int[] edge: edges) {
    graph.computeIfAbsent(edge[0], x-> new ArrayList<int[]>()).add(new int[]{edge[1], edge[2]});
}

// 各个节点到source当前最短距离
int[] dist = new int[n+1];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[<source>] = 0;

// visited 数组
boolean[] visited = new boolean[n+1];
visited[<source>] = true;

// min heap - 保存 [end node, curr dist]
PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0]-y[0]);
pq.add(new int[]{<source>, 0});

while(!pq.isEmpty()) {
    // 取出当前最小距离点
    int[] node = pq.poll();
    if(visited[node[0]]) continue;

    // 与BFS模板不同，这里每一次visited出堆再加，因为要出堆才能更新距离 - 所以这样写会导致可能有重复点进堆，需要在进堆时判断
    visited[node[0]] = true;  

    // update  当前点邻居的距离
    for(int[] edge: graph.getOrDefault(node[0], new ArrayList<>())) {
        // 如果当前点没被访问并且更新的距离更小
        if(!visited[edge[0]] && dist[edge[0]]>node[1] + edge[1]) {
            dist[edge[0]] = node[1] + edge[1];
            pq.offer(new int[]{edge[0], dist[edge[0]]});
        }
    }
    
}
```    
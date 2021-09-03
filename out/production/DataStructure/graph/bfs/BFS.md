## BFS 宽度优先搜索
### BFS 适用场景
- 分层遍历
    - 一层一层遍历 图，树，矩阵
        - 经典题型:
            - Lintcode 137 克隆图
            - Lintcode 120 单词接龙
         
    - 简单图最短路径
        - 简单图定义是，图中所有的边无权重，图没有方向，两点之间最多只有一条边
            - Undirected, Unweighted, no-multiple edges
        - 经典题型:
            - Lintcode 611 骑士最短路线
            - Lintcode 120 单词接龙
        - 解决最短路径算法
            - 简单图：BFS
            - 复杂图(面试通常不考，可做进阶)：Floyd, Dijkstra, Bellman-ford, SPFA
    
- 连通块问题
    - 通过图中一个点找到其他所有连通的点,找到所有方案问题的一种非递归实现方式
    - 经典题型：
        - Lintcode 433: 岛屿的个数
        - 岛屿问题基本都是BFS
    
- 拓扑排序 Topology Sorting(实现容易度远超过DFS)
    - 常见问题
        - 求任意拓扑序
        - 求是否有拓扑序
        - 求字典最小的拓扑序
        - 求是否唯一拓扑序
    - 经典题型
        - Course Schedule问题
        - Lintcode 616 course schedule
        - Lintcode 605 sequence reconstruction
        - Lintcode 892 alien dictionary
        - Lintcode 127 Topological Sorting
        

### Tree Structure BFS
- 核心思路: 建立一个Queue来存储各层节点
- 遍历顺序: 属于层序遍历

#### Tree-BFS 实现方法
- 单队列方法

```
## check in code
```
- 双队列方法
```$xslt

```
- DummyNode
```$xslt

```

### 二叉树BFS vs. Graph BFS
- 最大区别在于二叉树无需使用HashSet来存储访问过的节点
    - 在Tree Strucutre中，只需一次丢进queue然后pop即可，上下层关系分明，不存在环circle结构
    - 而在Graph中一个节点邻居的邻居可能回到自己，存在环结构

### Graph BFS遍历
- 核心思路: 
    - 如果DAG无环结构：从一个顶点出发一层一层向外扩展，之后的点不走以前相连的点
        - queue的种类
            - 利用双边队列保存 -> 有道题目每条边存在两个权值(0/1)
            - 常见利用单边队列进行保存
            - 还有通过PirorityQueue 进行保存，Dijiastrka 最短路径
                - 或者利用PriorityQueue来求解最大或最小字典拓扑排序问题
    - 如果图存在环结构：可能会重复进入队列？？之后研究
        - 同一个节点可能重复进入队列
        - 重复BFS没有意义
            - 对于联通块，不可能带来新的节点
            - 对于最短路径，不可能带来最短路径
        - 如何进行去重，避免重复BFS
            - HashMap/HashSet去重
                - HashMap -> 可以记录路过的点并记录与顶点的cost
                - HashSet -> 只记录已经路过的点
    
#### 如何实现图BFS遍历
- 如何定义一个图的数据结构
    - 常见的图存储结构
        - 邻接矩阵
        - 邻接表


##### 邻接矩阵 - 稀疏矩阵
```$xslt
邻接矩阵 Adjacency Matrix
[
[1,0,0,1],
[0,1,1,0],
[0,1,1,0],
[1,0,0,1]
]
例如上面的矩阵表示0号点和3号点有连边。1号点和2号点有连边。
当然，每个点和自己也是默认有连边的。
图中的 0 表示不连通，1 表示连通。
我们也可以用一个更具体的整数值来表示连边的长度。
邻接矩阵我们可以直接用一个二维数组表示，如
int[][] matrix;
这种数据结构因为耗费 O(n^2) 的空间，所以在稀疏图上浪费很大，因此并不常用
```
#####邻接表
```$xslt
邻接表 (Adjacency List)

[
  [1],
  [0,2,3],
  [1],
  [1]
]
这个图表示 0 和 1 之间有连边，1 和 2 之间有连边，1 和 3 之间有连边。
即每个点上存储自己有哪些邻居（有哪些连通的点）。这种方式下，空间耗费和边数成正比，可以记做 O(m)，m代表边数。
m最坏情况下虽然也是 O(n^2)，但是邻接表的存储方式大部分情况下会比邻接矩阵更省空间。
可以用自定义的类来实现邻接表
```

### General Graph BFS模板
- N个点，M条边 - 图BFS时间复杂度 = O(N+M) 
    - M最坏情况是N^2
    
- Note: 入队和标记已访问应当同时进行，而不是queue.poll()了之后在标记已访问，这样的滞后标记会导致队列中出现重复节点，会大大影响效率甚至死循环
    - 一个元素标记成已访问的正确时间，应该是他入队的那一刻，而不是出队的那一刻
- 分层和不分层 BFS
    - 模板展示的是不分层
    - 分层指每一次进入while loop会把queue每一层所有节点访问一边，再迭代进入下一个while loop
        - while loop中需要多些一个for loop去check queue length.
    - 何时需要分层？
        - 按层展示每一层结果
        - 求最短路径以及多少个点能够组成最短路径
```$xslt
Queue<Node> queue = new ArrayQueue<>(); // 建议使用arrayQueue,比LinkedList queue更快
HashMap<Node, Integer> distance = new HashMap<>();

// step 1: 初始化
// 把初始节点放到queue里，如果有多个就都放进去
// 并标记初始节点的距离为0，记录distance的hashmap里
// distance有两个作用，一是判断是否访问过，二是记录起点的距离

// Note：!!! 入队和标记访问节点最好同时一起执行
queue.offer(node);
distance.put(node, 0);

// step 2不断访问队列
// while 循环 + 每次 pop队列中的一个点出来

while(!queue.isEmpty()) {
    Node node = queue.poll();
    // step 3. 拓展相邻节点
    // pop 出的节点的相邻节点，加入队列并在distance中存储距离
    for(Node neighbor: node.getNeighbors()) {
        if(distance.containsKey(neighbor)) {
            continue;
        }

        // 入队标记同时
        distance.put(neighbor, distance.get(node) + 1);
        queue.offer(neighbor);
    }
}
```

#### Graph BFS 题型
- 分层遍历
- 联通块 Adj block
    - 联通块通常是解决2D矩阵问题
        - 如何记录每一个(x,y)的距离 通过 HashMap
            - Java中没有tuple
            - Solution: 编码x,y into 一维index HashMap<int,int> -> key=x*ColumnCount + y -> new index
- 拓扑排序 Topological Sorting

##### 拓扑排序
- 什么是拓扑排序
    - 拓扑排序是将有向图所有顶点的一个线性序列
        - 每个顶点出现且仅出现一次
        - 若边的方向是A -> B那么排序中A应该在B前面
- 拓扑排序只应用在有向无环图 DAG 中
    - 只有无环结构的有向图才有拓扑序
    
- 基本概念
    - 入度
        - 有向图中指向当前节点的点的个数(指向当前节点边的条数)
    - 出度
    - 不是传统的排序算法
        - 一个图可能存在多个拓扑序 也可能不存在任何拓扑序
- 算法描述
    - 统计每个点的入度
    - 将每个入度为0的点放入队列中作为起始节点
        - 入度为0即只发送状态的点，不接受状态
    - 不断从队列中拿出一个点，去掉这个点的所有连边(指向其他点的边)，其他点的相应入度 -1
    - 一旦发现新的入度为0的点，丢回队列中

    

### 难点问题：存在环结构问题
- 上述BFS模板无法适用于环形结构
    - 在BFS模板中，每一次会把queue中当前节点的邻接节点入度-1,如果有新的入度为0点那么将新点加入queue
    - 但是如果存在环形结构，会导致最后这两个点始终无法进入
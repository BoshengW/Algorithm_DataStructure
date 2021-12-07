### 拓扑排序
- 只有有向无环图才有拓扑 
    - 无向说明互相没有依赖
    - 有环说明没有in-degree=0的点
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
        
- 算法描述 - 步骤
    - 统计每个点的入度
    - 将每个入度为0的点放入队列中作为起始节点
        - 入度为0即只发送状态的点，不接受状态(所有in-degree都可以作为起始点)
    - while loop -> BFS
    
    - 不断从队列中拿出一个点，去掉这个点的所有连边(指向其他点的边)，其他点的相应入度 -1
    - 一旦发现新的入度为0的点，丢回队列中

#### 拓扑序列模板
```

class gNode {
    int val;
    List<gNode> dep;
}

public void topsort(List<gNode> nlist) {
    // 建图
    HashMap<Integer, Integer> inDegree = new HashMap<>();
    for(gNode i: nlist) {
        if(!inDegree.containsKey(i.val)) inDegree.put(i.val, 0);
        for(gNode n: i.dep) {
            // give dep in-degree + 1
            inDegree.put(n.val, inDegree.getOrDefault(n.val, 0)+1);
        }
    }
    
    // add in-degree = 0  node into queue
    Queue<Integr> q = new LinkedList<>();
    for(Integer i: inDegree.keySet()) {
        if(inDegree.get(i)==0) q.offer(i);
    }
    
    List<Integer> res = new ArrayList<>();
    while(!.q.isEmpty()) {
        int curr = q.poll();
        for(gNode d : curr.dep) {
            inDegree.get(d.val)
        } 
    }
}
```
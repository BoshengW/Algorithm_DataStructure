## Graph

### 什么是图
- 图在离散数据中表示方法为<E,V> E表示Edge，V表示Vertex，就是边和顶点的集合
- 图可分为两种：
    - 有向图 directed Data_Structure.graph
    - 无向图 undirected Data_Structure.graph
- BFS 大部分时候在图上进行操作，在两种图中都适用
- Note: 树Tree也是一种特殊结构的图
    - Graph -> Tree -> Binary Tree


#### 存储图方法
- 邻接表
    - 每一行保存与那个节点有边
    
```
[
    [1],
    [0,2,3],
    [1],
    [1]
]
```
- 邻接矩阵
    - 利用0/1矩阵保存所有边信息
    - 缺点:较为浪费空间 O(N^2)
```
[
    [1,0,0,1]
    [0,1,1,0]
    [0,1,1,0]
    [1,0,0,1]
]
```
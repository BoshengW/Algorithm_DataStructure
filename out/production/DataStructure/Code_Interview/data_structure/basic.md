### 基础数据结构概述

#### 数组类
##### Array
- 特点
    - 定长, 定type
    - 通常用于存储有序结构容器
- 问询功能:
    - 根据index查询: O(1)
    - 在某一个index插入或者删除较慢: O(N)

- 用法: 
    - 存储数字
    - 存储字符出现频率 int[26] idx = char-'a'
    - visited - 存储图中某个index是否访问 boolean[]

##### 差分数组
- 特点:
    - 每一个index存储相邻两个的差值
    - 前缀和即为 [l, r]的差值
- 问询功能:
    - 对一个区间加减一个数：O(1)
    - 查询原数组某个index的值: O(N) - 前缀和
```
array = [a0, a1, a2, ..., an]

diff = [d0, d1, d2, ..., dn] -  [N+1]
d0 = a0
d1 = a1 - a0
d2 = a2 - a1
...
dn = an - an-1
```

##### 块状数组
- 特点:
    - 将原数组划分成整块 + 散块 (通常sqrt(N))
    - 快速维护某个区间和
        - 整块暴力加，散块看lazy
- 问询功能
    - 给一个区间加减一个数，快速更新区间和 - O(1) - O(1+1+(r-l))

##### 数组堆化
- 特点:
    - 堆是用来维护一个数组集合
    - 大小顶堆: 堆内顺序不确定，但是top一定最大最小
- 应答功能
    - 查询数组最大小值 - O(1) 
    - 插入 - O(logN)
    - 删除top - O(logN)
- Java堆使用
    - 默认是小顶堆
```
// Default 
PriorityQueue<Integer> heap = new PriorityQueue<>();

// Make a Max Heap
PriorityQueue<Object> heap = new PriorityQueue<>((x,y) -> {return y.val-x.val;});

// Make a Max Heap
PriorityQueue<Object> heap = new PriorityQueue<>((x,y) -> y.compareTo(x));
```

##### 循环数组

#### Stack
##### 单调栈


#### Queue
##### 队列

##### 双边队列



#### 哈希
- 重点: HashMap. HashSet并不是真正O(1)查找
    - 数值hash可以通过一个计算得到hash值 - O(1)
    - 但是字符串求解hash值，需要每一次遍历一遍字符串计算hash值 - O(Length)
##### 重哈希 rehashing
##### HashMap
- 特点:
    - 无序数据结构
    - key无重复值，不能是null
    - value可以有重复值
    - 通常用来 - 分类统计(频率)
- 应答功能
    - 增、删、改、查 key - O(1)
        - 查 value - O(N) 
    - 遍历 - O(N)
```
HashMap<~> map = new HashMap<>();

// CRUD 操作
map.put(key, value);
map.get(key);
map.remove(key);
map.put(old-key, new-value);
map.containsKey(key);
map.containsValue(value);

// 
map.getOrDefault(key, default-value);
map.size();

// 遍历
for(object key: map.keyset()) {}
for(Entry entry: map.EntrySet()) {}

```

##### HashSet
- 特点:
    - 无序的数据结构
    - 无重复值
    - 适用于快速查找某个值存不存在
- 应答功能
    - 增、删、查 - O(1)
    - 遍历 - O(N)
    
```
Set<~> hashset = new HashSet<>();

// CRUD
hashset.add(<~>)
hashset.remove(<~>)
hashset.contains(<~>)
hashset.size()

```


##### 字符串哈希 - Robin-karp
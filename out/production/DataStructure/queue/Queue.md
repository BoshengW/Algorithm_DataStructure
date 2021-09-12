# Queue

## 为什么使用Queue
- 队列（queue）是一种采用先进先出（FIFO，first in first out）策略的抽象数据结构。比如生活中排队，总是按照先来的先服务，后来的后服务。队列在数据结构中举足轻重，其在算法中应用广泛，最常用的就是在宽度优先搜索(BFS）中，记录待扩展的节点。

- 队列内部存储元素的方式，一般有两种，数组（array）和链表（linked list）。两者的最主要区别是：
    - 数组对随机访问有较好性能。
    - 链表对插入和删除元素有较好性能。

### PriorityQueue

- 基于堆(heap)实现
- 非FIFO(最先出队列的是优先级最高的元素)
### 普通 Queue
- 基于链表实现
- FIFO


## 实现
### 利用纯数组实现 - 假溢出问题
### 利用链表实现 - 避免溢出
### 改良纯数组问题 - 循环队列
- 为充分利用向量空间，克服"假溢出"现象的方法是：将向量空间想象为一个首尾相接的圆环，并称这种向量为循环向量。存储在其中的队列称为循环队列（Circular Queue）。循环队列是把顺序队列首尾相连，把存储队列元素的表从逻辑上看成一个环，成为循环队列。
    - 我们主要介绍三个操作：
        - 初始化循环队列
            - enqueue()向队尾插入元素
            - dequeue()删除并返回队首元素
            - 在循环队列中，除了用一组地址连续的存储单元依次存储从队首到队尾的元素外，还需要附设两个整型变量head和tail分别指示队首和队尾的位置。

我们可以将循环队列视作一个类，通过成员变量数组来表示一组地址连续的存储单元，再定义两个成员变量head和tail，将循环队列的基本操作定义成类的方法，循环效果则用“模”运算实现，以此来实现循环队列。

- 每当tail到达末尾的时候，将tail对MAXSIZE取模，使其回到队首。但是如果这样我们会发现一个问题，队列为空和队列已满的条件都成了tail == head。为了避免这种无法判断的情况，我们规定当循环队列只剩一个空位的时候，就认为队列已满。这样队列已满的条件就成了 (tail + 1) % MAXSIZE == head。

####循环队列练习题
https://leetcode.com/problems/design-circular-queue/

## 常见题型
队列是一种比较重要的数据结构，它支持FIFO(First in First out)，即尾部添加、头部删除（先进队列的元素先出队列），跟我们生活中的排队类似。

## Java 中如何使用Queue interface
- Java 中 Queue是以interface形式存在: https://www.geeksforgeeks.org/queue-interface-java/
    - Java 中Deque是继承了原始Queue interface
    - 而Java中LinkedList，ArrayQueue这两个实现类是实现了Deque接口


```
## for example
Queue<TreeNode> bfsQueue = new LinkedList<>();

```

### 常见Queue接口实现类
- LinkedList
- PriorityQueue
    - non-thread safe
- PriorityBlockingQueue
    - thread safe
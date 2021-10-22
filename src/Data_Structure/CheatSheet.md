### Data Structure Cheat Sheet

#### Array & LinkedList
- Array 便于快速读取by index,但是不便于存储(因为定长)
- LinkedList 便于存储，不便于快速读取(需要遍历)

#### 哈希的过程

- Keys(String, Object, ...) -> Hash Function: f(Keys) -> Integer in Buckets
    - Note: Hash Collision: Diff Object has same hashcode
    - Collision解决方法：
        - Open Hashing: 相同Hashcode,用链表把相同hashcode存在一起
            - 后来存的数据放在表头
            - 查询时需要遍历链表
        - Close Hashing: 相同的hashcode,放到下一个空闲空间中 (用的不多-使用起来容易造成冲突 - 因为相同的那个object会占用别的hashcode的空间)

- 重哈希 rehashing
    - 定义：当前capacity的哈希表存储过大时，应该进行扩容，并且进行重哈希
        - 啥时候扩容: 当超过容量的1/10

#### 哈希表 - 散列表
- 什么是散列表
    - 数组和链表的结合体
- 哈希表是用来解决LinkedList访问不快速的问题，
- HashMap
    - 底层是一个数组结构，数组中每一项对应一个链表，称为链表散列
        - 对HashMap的Key调用hashCode()方法，返回int值，即对应的hashCode
        - 把此hashCode作为哈希表的索引，查找哈希表的相应位置，若当前位置内容为NULL，则把HashMap的Key、Value包装成Entry数组，放入当前位置；
        - 若当前位置内容不为空，则继续查找当前索引处存放的链表，利用equals方法，找到Key相同的Entry数组，则用当前Value去替换旧的Value；
        - 若未找到与当前Key值相同的对象，则把当前位置的链表后移（Entry数组持有一个指向下一个元素的引用），把新的Entry数组放到链表表头；
    - 数组 -> 存放<Key, Value> Entry Object -> if Key HashCode collision -> 组建成链表，并按次序一个一个往后存
    - HashMap使用Key进行hashcode计算 
- HashSet
    - 通过HashMap来实现的，在实现hashset时，保证HashMap中Value为常量，HashSet的值保存在Key上面
    - HashSet使用添加的成员对象进行hashcode计算
        - Note:两个对象的hashcode可能会相同，这时就需要用equals方法对两个对象内容进行比较 - 如果还是相同那么认为重复不加入

#### 堆 Heap, Priority Queue (优先队列)
- 堆Heap是一棵满足如下性质的**二叉树**
    - 应答时间复杂度
        - insert O(logN)
        - poll O(logN)
            - 把顶的min/max和最底部进行交换，然后siftdown(找到新值的正确位置)
        - peek (min/max) O(1)
    - 小顶堆 minHeap: 父节点总是不大于他的孩子节点 - 小的在顶
    - 大顶堆 maxHeap: 父节点总是不小于他的孩子节点 - 大的在顶
    - 堆化 Heapify
        - 堆中每一个节点满足下面定义
            - A[i] 左右儿子：A[i*2+1], A[i*2+2]
    
- 优先队列 
    - 是一种抽象关系，Heap是实现优先队列的一种方式
        - Heap 和 PQ关系就像List和Array
        
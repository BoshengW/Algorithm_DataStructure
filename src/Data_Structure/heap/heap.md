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
#### 堆化
- 堆中每一个节点满足下面定义
    - A[i] 左右儿子：A[i*2+1], A[i*2+2]
    - 堆化并不保证有序(左右孩子大小不确定)
- 堆的所有操作都可以通过ShiftDown/ShiftUp
    - peek() - heap[0]
    - insert() - heap[++size] -> shiftUp(size)
    - deleteTop() - heap[0] = heap[size] -> shiftDown(1)
    - insert(k) - 在index k处插入 - heap[k] = x -> shiftUp(k)/shiftDown(k)
    - delete(k) - 在index k处删除 - heap[k] = heap[size] -> shiftDown(k)/shiftUp(k)
     
- ShiftDown 操作
```
private void down(int[] A, int i) {
    while(i<A.length/2) {
        int ne = i;
        // 与左右儿子比较找到最小值
        if(2*i + 1<A.length && A[ne]<A[2*i+1]) ne = 2*i + 1;
        if(2*i + 2<A.length && A[ne]<A[2*i+2]) ne = 2*i + 2;
        if(i!=ne) {
            swap(A[i], A[ne]);
            i = ne;
        } else break;
    }
}

```
- ShiftUp 操作
```
```
#### 堆排序
- 堆排序讲解 - [https://www.cnblogs.com/chengxiao/p/6129630.html]
- 在堆结构上进行堆排序流程

```
 - Data_Structure.heap: [9,6,5,3,4]  每一次将当前堆最大的顶点0放到最后length-i
 - [4, 6, 5, 3, 9] ->然后对[0, length-i-1] 进行堆化，得到当前最大值
 - 通过这种方法每一次将当前最大值找出并放到后面 -> 从而得到排序  
```
- 是建立在堆数据结构上的一种排序方式 - 使用堆排序先要进行堆化
    - Time: O(nlogN)
    - Space: O(1)
    - 升序排列
        - 先建立大顶堆(max on top), 然后
- 相比较Quick Sort & Merge Sort
    - 时间上N基数会大一些，会慢一点
    - 空间上远优于两者
    
```

```
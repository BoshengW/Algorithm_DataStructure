### Array大类题目

####常用的计算公式
- 某个index前面和后面的长度
```
int[] arr = new int[N];
------
前面长度 prevL = index;
后面长度 postL = arr.length-index-1;

```
- 两个index之间的距离 / idx2要和相邻交换几次能得到idx1
```
gap = idx2 - idx1+1

swap = idx2-idx1
```


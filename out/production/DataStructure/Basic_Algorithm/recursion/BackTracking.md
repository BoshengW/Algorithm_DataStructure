### Back Tracking 回溯

#### 回溯法
- 将当前状态改回上一次的状态
    - 回溯就是深度优先搜索
- 使用递归函数时，我们使用的时操作系统的栈，无需手动建立栈

##### 手动回溯和自动回溯

```
### 系统自动进行回溯 - 通常找点回溯时可以使用系统自动回溯
def findNodes(node, nodes):
    if not node:
        return
    nodes.append(node.val)
    findNodes(node.left, nodes)
    findNodes(node.right, nodes)
```

```
### 手动回溯 - 通常在找路径时，需要手动回溯到之前的路径继续搜索
def findPath(node, path, paths)：
    path.append(node.val);
    findPath(node.left, path, paths);
    path.pop() // 回溯 ->切换成上一级状态

    path.append(node.right);
    findPaths(node.right, path, paths);
    path.pop(); // 回溯 -> 切换成上一级状态

```

#### 回溯操作
### 隐式图 DFS题目
- 通常这类问题都是 NP问题 - 即非多项式时间问题
#### 组合类问题
##### Subsets - no duplicate element
- DFS 0/1 选择组合
- Time: O(2^N*N), Space: O(N) N is nums.length
```
private void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> res) {
    if(idx==nums.length) {
        res.add(new ArrayList<Integer>(path));
        return;
    }

    path.add(nums[idx]); // add current 
    dfs(nums, idx+1, path, res);
    path.remove(path.size()-1); // not add current
    dfs(nums, idx+1, path, res);
}
```

- DFS 较为通用
    - 通过for loop遍历所有前缀组合
    - 这种做法会将空间复杂度比较小，最坏情况是O(N), 最好O(1)
        - 但是上面0/1操作最好最坏都是O(N)
- Time: O(2^N*N), Space: O(N)
    - Time里面乘以N是list deep copy的时间因为每一次都要保存path结果
    - Recursive call一共执行了O(2^N)次，T(N) = T(N-1) + T(N-2) + T(N-3) + ... + T(1) = O(2^N)
```
private void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> res) {
    // 每一次碰到的节点都是我要的答案
    res.add(new ArrayList<Integer>(path)); // 每一次都要保存，不像0/1组合那样到最后保存
    for(int i=idx; i<nums.length; i++) {
        path.add(nums[i]);
        dfs(nums, i+1, path, res);
        path.remove(path.size()-1);
    }

}
```

##### Subsets2 - duplicate elements
- DFS 通用模板
    - 查重的部分: 每一次回溯的时候，在下一次loop添加之前应该跳过后面相同的元素，那些就是重复的
- Time: O(2^N*N), Space: O(N)
```
private void dfs(int[] nums, int idx, List<Integer> path, List<List<Integer>> res) {
    res.add(new ArrayList<Integer>(path));

    for(int i=idx; i<nums.length; i++) {
        // 剪枝
        path.add(nums[i]);
        dfs(nums, i+1, path, res);
        path.remove(path.size()-1);
        // 剪枝 remove之后忽略后面所有相同元素
        while(i<nums.length-1 && nums[i]==nums[i+1]) {
            i++;
        }
    }
}
```


#### 排列问题
##### Permutation - no duplicate elements
- DFS 通用模块
- Time: O(N!*N), Space: O(N)
```
private void dfs(int[] nums, 
                List<Integer> path, 
                List<List<Integer>> res,
                HashSet<Integer> visited) {
    
    if(path.size()==nums.length) {
        res.add(new ArrayList<Integer>(path));
        return;
    }

    for(int i=0; i<nums.length; i++) {
        
        if(visited.contains(nums[i])) continue;

        visited.add(nums[i]);
        path.add(nums[i]);
        dfs(nums, path, res, visited);
        path.remove(path.size()-1);
        visited.remove(nums[i]);
    }
}
```

##### Permutation II - duplicate elements
- DFS 通用模板
- Time: O(N!*N), Space: O(N)

```
private void dfs(int[] nums, 
                    List<Integer> path, 
                    List<List<Integer>> res, 
                    HashMap<Integer, Integer> visited) {

    if(path.size()==nums.length) {
        res.add(new ArrayList<Integer>(path));
        return;
    }

    for(int i=0; i<nums.length; i++) {
        if(visited.get(nums[i])==0) continue; // curr element use out

        path.add(nums[i]);
        visited.put(nums[i], visited.get(nums[i])-1);
        dfs(nums, path, res, visited);
        path.remove(path.size()-1);
        visited.put(nums[i], visited.get(nums[i])+1);

        // next part ignore all element == nums[i]
        while(i<nums.length-1 && nums[i]==nums[i+1]) {
            i++;
        }
    }
}
```

##### 经典NP问题 - TSP旅行商问题
Note:
    - 两个city之间可能有多个路径 - 取最小cost
    - 不一定所有city之间都存在road

```
public int minCost(int n, int[][] roads) {
    // Write your code here
    if(roads==null) return 0;

    boolean[] visited = new boolean[n+1];
    int[][] cost = new int[n+1][n+1];
    for(int[] road: roads) {
        int a = road[0];
        int b = road[1];
        cost[a][b] = cost[a][b]!=0? Math.min(road[2], cost[a][b]):road[2];
        cost[b][a] = cost[b][a]!=0? Math.min(road[2], cost[b][a]):road[2];
    }
    visited[1] = true; // start from city 1 
    dfs(0, 1, 1, visited, cost);

    return min;
}

private void dfs(int curr,
                int prev,
                int pass,
                boolean[] visited,
                int[][] cost) {
    if(pass==cost.length-1) {
        min = Math.min(min, curr);
        return;
    }

    for(int i=2; i<=cost.length-1; i++) {
        if(visited[i] || cost[prev][i]==0) continue; // visited or road not exist
        curr = curr + cost[prev][i];
        visited[i] = true;
        dfs(curr, i, pass+1, visited, cost);
        visited[i] = false;
        curr -= cost[prev][i];
    }
}
```


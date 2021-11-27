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
- 二进制求解
    - 每一个数 0/1 一共 2^N
    - Time: O(2^N), Space: O(N)

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

##### Letter Combination of a Phone number
- DFS组合问题
```
public List<String> letterCombinations(String digits) {
    // write your code here
    String[] map = {
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    List<String> res = new ArrayList<>();
    if(digits==null || digits.length()==0) return res;

    dfs(digits, 0, map, "", res);
    return res;
}

private void dfs(String digits, int idx, String[] map, String curr, List<String> res) {
    if(idx==digits.length()) {
        res.add(curr);
        return;
    }

    char digit = digits.charAt(idx);
    for(int i=0; i<map[digit-'2'].length(); i++) {
        dfs(digits, idx+1, map, curr+map[digit-'2'].charAt(i), res);
    }
}
```

##### String permutation II - duplicate elements
- DFS组合问题
    - Char数组也可以进行排序 
```
private void dfs(char[] str, 
                int[] visited,
                String curr,
                List<String> res) {
    if(curr.length()==str.length) {
        res.add(curr);
        return;
    }

    for(int i=0; i<str.length; i++) {
        if(visited[str[i]-'a']==0) continue; // element use out
        curr = curr + str[i];
        visited[str[i]-'a']-=1;
        dfs(str, visited, curr, res);
        curr = curr.substring(0, curr.length()-1);
        visited[str[i]-'a']+=1;

        while(i<str.length-1 && str[i]==str[i+1]) i++;
    }
}
```
##### Combination Sum
- 无限元素组合 - 去除重复解数组
    - 对于有序数组可重复选取 - 解去重操作可以设计index每一次不能选取index之前的值
    - 当回溯开始选取下一个元素时，应当跳过后面相同元素，因为重复元素在dfs递归时已经包括了
- Time: O(N^(target/min)*N) Space: O(N^(target/min)*N + target/min) 
    - 深度最深： target/min
```
private void dfs(int[] cad, 
                int idx, 
                int sum,
                int target,
                List<Integer> path,
                List<List<Integer>> res) {
    if(sum==target) {
        res.add(new ArrayList<Integer>(path));
        return;
    }

    for(int i=idx; i<cad.length; i++) {
        if(sum+cad[i]>target) break;
        path.add(cad[i]);
        dfs(cad, i, sum+cad[i], target, path, res);
        path.remove(path.size()-1);
        // 如果不使用当前element那么跳过相同元素
        while(i<cad.length-1 && cad[i]==cad[i+1]) i++;
    }
}
```

##### Ksum 
- DFS 组合
- 限制了高度，到达限高就返回
- Time: O(N^k*k), Space: O(N^k*k + k)
    - 树高: k
```
private void dfs(int[] A, 
                    int idx, 
                    int sum,
                    int k, 
                    int target,
                    List<Integer> path,
                    List<List<Integer>> res) {
    if(k<0) return;

    if(sum==target && k==0) {
        res.add(new ArrayList<Integer>(path));
        return;
    }

    for(int i=idx; i<A.length; i++) {
        if(sum+A[i]>target) break; // solution not exist
        path.add(A[i]);
        dfs(A, i+1, sum+A[i], k-1, target, path, res);
        path.remove(path.size()-1);
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

#### 字符串 相关问题
##### Word Break II
- DFS思路 - 也是找subset
- Tips:
    - 在DFS找匹配字符串问题时，可以通过前缀是否存在来进行剪枝
```
// 暴力搜索会超时
// 需要通过前缀map进行剪枝
int[] x = {-1, 0 , 1, 0};
int[] y = {0, -1, 0, 1}; 
public List<String> wordSearchII(char[][] board, List<String> words) {
    // write your code here
    List<String> res = new ArrayList<>();
    if(board==null) return res;
    
    
    HashSet<String> ans = new HashSet<>();
    HashSet<String> dict = new HashSet<>();
    HashSet<String> prefixSet = getPrefix(words);
    boolean[][] visited = new boolean[board.length][board[0].length];

    for(String i: words) {
        dict.add(i);
    }
    for(int i=0; i<board.length; i++) {
        for(int j=0; j<board[i].length; j++) {
            visited[i][j] = true;
            dfs(board, i, j, dict, "", ans, visited, prefixSet);
            visited[i][j] = false;
        }
    }
    for(String i: ans) {
        res.add(i);
    }

    return res;
}

private HashSet<String> getPrefix(List<String> words) {
    HashSet<String> set = new HashSet<>();
    
    for(String i : words) {
        for(int j=1; j<=i.length(); j++) {
            set.add(i.substring(0, j));
        }
    }

    return set;
}

private void dfs(char[][] board,
                int dx,
                int dy,
                HashSet<String> dict,
                String curr,
                HashSet<String> ans,
                boolean[][] visited,
                HashSet<String> prefix) {

    curr = curr + board[dx][dy];
    if(!prefix.contains(curr)) return;

    if(dict.contains(curr)) {
        ans.add(curr);
    }

    for(int i=0; i<4; i++) {
        if(dx+x[i]>=0 && dx+x[i]<board.length && dy+y[i]>=0 && dy+y[i]<board[0].length && !visited[dx+x[i]][dy+y[i]]) {
            // not out of bound and not visited
            visited[dx+x[i]][dy+y[i]] = true;
            dfs(board, dx+x[i], dy+y[i], dict, curr, ans, visited, prefix);
            visited[dx+x[i]][dy+y[i]] = false;
        }
    }
}
```
- 最优解 Trie


##### Word Break III

#### 字符串分割问题
##### Restore IP Address
- 一个valid IP address
    - length ~ [4, 12]
    - 3 dots
    - 每个区域数 ~[0,255] - 0 只能单独一个区域
        - 不能有 .00 只能 .0
        
- DFS 组合思路 选一位，两位，三位
```
private void dfs(char[] arr,
                String curr,
                int idx,
                int pt,
                List<String> res) {
    if(idx==arr.length) {
        // touch end
        if(pt==-1) res.add(curr.substring(0, curr.length()-1));
        return;
    } 

    if(arr[idx]=='0') dfs(arr, curr+arr[idx]+'.', idx+1, pt-1, res);
    else {
        String tmp = "";
        for(int i=idx; i<=idx+2 && i<arr.length; i++) {
            tmp += arr[i];
            if(check(tmp)) dfs(arr, curr+tmp+".", i+1, pt-1, res);
        }
    }


}

private boolean check(String num) {
    if(Integer.parseInt(num)>255) return false;
    return true;
}
```


#### 经典 DFS问题
##### N - Queens 问题

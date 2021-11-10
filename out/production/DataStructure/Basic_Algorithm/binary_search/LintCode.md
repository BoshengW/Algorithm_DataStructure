## Binary Search 例题
### 题型
- 排序集上面二分
- 非排序集上面二分
- 答案集上面二分
### 二分法思路
- 前提条件: 能够通过一个条件将解空间划分成[0, L] , [R, end] - OOOOO XXXX模型
    - 如果找L 即满足条件的最后一个 - 左半段满足条件，右半段不满足
    - 如果找R 即满足条件的第一个 - 左半段不满足条件， 右半段满足条件

### 有序集上面二分
#### Last Position of Target - 找满足条件[0, L] 最后一个
- 条件: find <=target last element in left
```
public int lastPosition(int[] nums, int target) {
    // is the solution space can be split into two parts - yes <target, >=target
    // find last element which is match the condition <= target - condition a<=target

    if(nums==null || nums.length==0) return -1;

    int l=0, r=nums.length-1;
    while(l<r) {
        int mid = l + (r-l+1>>1);
        // match condition in left, target should in [mid, r]
        if(nums[mid]<=target) l = mid;
        else r = mid-1;
    }
    // if solution exist
    return nums[l]==target? l: -1;
}
```

#### First Position of target - 找满足条件[R, end]第一个
- 条件: find >= target first element in right
```
public int findFirstPosition(int[] nums, int target) {
    // Solution space can be split into 2 part
    // Condition: a<target - Find last element which match condition
    if(nums==null || nums.length==0) return -1;

    int l=0, r=nums.length-1;
    while(l<r) {
        int mid = l + (r-l>>1);
        // match condition, mid is in right, first one match must be in right [l, mid]
        if(nums[mid]>=target) r = mid;
        // doesn't match condition mid is in left, find the first match [mid+1, ~]
        else l = mid+1;
    }
    // check solution space exists
    return nums[l]==target? l: -1;
}

```

#### Find target exist in 2D Matrix
- 条件: find first element >= target in 2D matrix
```
public boolean searchMatrix(int[][] matrix, int target) {
    // write your code here
    if(matrix==null) return false;
    
    int h=matrix.length, c=matrix[0].length;
    int l=0, r=h*c-1;
    // Condition >=target first one
    while(l<r) {
        int mid = l + (r-l>>1);
        // 2D -> 1D idx/column = row idx; idx%column = col idx
        if(matrix[mid/c][mid%c]>=target) r=mid;
        else l=mid+1;
    }
    return matrix[l/c][l%c]==target? true: false;
}
```

#### Find target occurence in 2D Matrix
- 非典型二分法 - 模板不适用 - O(m+n)
```
public int searchMatrix(int[][] matrix, int target) {
    // 不是典型的二分查找,二分并不能找到所有解只能查看单一解
    int r = 0, c = matrix[0].length-1;

    // 从第一行最右开始找如果小于那么当前行都小于直接下一行
    // 如果等于同行直接跳过count++ - 从下一行前面一个找, 
    // 如果大于则看前面的一个数
    int count = 0;
    while(r<=matrix.length-1 && c>=0) {
        if(matrix[r][c]==target) {
            count++;
            r++;
            c--;
        } else if(matrix[r][c]<target) {
            r++;
        } else {
            c--;
        }
    }

    return count;
}
```
#### Find Median of two sorted array
- 条件比较巧妙
- 首先解空间是一组平均数集合 - 涵盖了所有A,B中的组合 - 在其中找到中位数那个值。
    - 也就是找到A,B中在这个平均数之前的元素个数之和(是个数不是index)==(n+m)/2+1 或 [(n+m)/2,(n+m)/2+1]
- 那么该问题可以细化成两部分:
    1. 遍历所有平均数 - (二分)
    2. 每一个平均数查找A,B在这个数之前的元素个数 - (二分)
- 条件就可以转换成 A,B在mid元素个数和>=(n+m)/2+1的第一个位置即为median
    - {===========区间内total(A,B<=mid)<(n+m)/2+1} {***********区间内total(A,B<=mid)>=(n+m)/2+1}
                                                   | -> 我们要找的位置
```
public double findMedianSortedArrays(int[] A, int[] B) {
    // write your code here
    // 条件: 寻找第一个mid数值使得A,B 中<=mid总和 >=[(n+m)/2] || [(n+m/2)-1, (n+m)/2]
    // 条件: odd: checkTotal(mid)>=(n+m)/2,  even: checkTotal(mid1)<=(n+m)/2 && checkTotal(mid2)<=(n+m)/2-1
    int m = A.length;
    int n = B.length;

    if((n+m)%2==0) {
        return (Helper(A, B, (n+m)/2+1) + Helper(A, B, (n+m)/2))/2.0;
    } else {
        return Helper(A, B, (n+m)/2+1);
    }
}

private int Helper(int[] A, int[] B, int loc) {
    if(A==null || A.length==0) return B[loc-1];
    if(B==null || B.length==0) return A[loc-1];

    int l = Math.min(A[0], B[0]);
    int r = Math.max(A[A.length-1], B[B.length-1]);

    // find the first mid value total(A, B)>=loc
    while(l<r) {
        int mid = l + (r-l>>1);
        if(checkTotal(A, B, mid)>=loc) r=mid;
        else l=mid+1;
    }
    // System.out.println("final " + l);
    return l;
}

private int checkTotal(int[] A, int[] B, int t) {
    int res = 0;
    int l = 0, r = A.length-1;

    // find first element which A[l]>=t -> 有可能A[l] > t还要分条件讨论一下，有点麻烦
    // find last element which A[l]<=t -> 只要l存在(即A 全部>t) 那么l必是解
    while(l < r) {
        int mid = l + (r-l+1>>1);
        if(A[mid]<=t) l=mid;
        else r=mid-1;
    }
    if(A[l]<=t) res+=(l+1);
    int a = l;

    l=0; r=B.length-1;
    while(l < r) {
        int mid = l + (r-l+1>>1);
        if(B[mid]<=t) l=mid;
        else r=mid-1;
    }

    if(B[l]<=t) res+=(l+1);
    // System.out.println("t: " + t + ",A l: " + a + ",B l: " + l +  ",res : " + res);
    return res;
}
```

### Find median in K sorted Array


### 无序集上面二分(即没有顺序关系的问题使用二分法)
#### Find intersection of two array
- 数组之间的交集并不需要连续，共同元素即为交集
- 条件: 找到 >= target
```
public int[] intersection(int[] nums1, int[] nums2) {
    // Hash找每一个当前元素是否存在 O(1) Time(N) - Space O(N)
    // 通过二分法或者求当前元素是否存在于有序数组 - O(logN) Time(NlogN) - Space O(m)
    // 通过同向双指针进行扫描 - Time: O(NlogN) Space O(m)
    if(nums1.length==0 || nums2.length==0) return new int[0];
    List<Integer> res = new ArrayList<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int i=0, j=0;
    while(j<nums2.length) {
        if(j>0 && nums2[j]==nums2[j-1]) {
            j++; 
            continue;
        }
        if(binarySearch(nums2[j], nums1)) res.add(nums2[j]);
        j++;   
    }

    int[] arr = new int[res.size()];
    for(int w=0; w<arr.length; w++) arr[w] = res.get(w);
    return arr;
}

private boolean binarySearch(int t, int[] n) {
    int l=0, r=n.length-1;
    while(l<r) {
        int mid = l + (r-l>>1);
        if(n[mid]>=t) r=mid;
        else l=mid+1;
    }

    return n[l]==t;
}
```


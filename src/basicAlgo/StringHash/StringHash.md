### 字符串哈希 - Rabin-Karp 

#### 主要解决字符串匹配问题
https://coolcao.com/2020/08/20/rabin-karp/

#### 定义
定义一个进制数(通常进制是131)，将每一个字符串转化成该进制的long整数，该进制下基本能确保
不存在不同字符串collision的问题。

#### 为什么使用hash
这种方法非常适合解决前缀问题，以及子串问题
- 传统前缀查找需要O(r*(l-r)) -> r为前缀长度，字符串Hash可以做到O(1*(l-r))
- Note: subsequence & substring区别：
    - subsequence: 子序列不一定要连续
    - substring: 子串一定是连续的

##### Note: 为什么选取131作为基底

#### 步骤 
- Note: 通常字符串hash适用于定长前缀问题，定长字符串查找
- 对于找前缀问题 - 前缀定长
    - 从idx=0 一直遍历到尾部
    - 计算当前字符之前的前缀hash值 -> hash[]
    - 通过从各个前缀之间求差：hash = hash[当前idx] - hash[当前idx-定长]*131的定长次方
        - 相当于将字符进行移位操作
        - abcd -> 求bcd哈希 -> abcd - a000 = bcd
        
- 利用字符哈希来比较字符是否存在而不是遍历每一个字符比较，就是字符串hash快的原因


#### 
Leetcode 5, 28, 187

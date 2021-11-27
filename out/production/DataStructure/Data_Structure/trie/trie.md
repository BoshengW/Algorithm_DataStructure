### Trie字典树，前缀树

#### 什么是 Trie树
- 一个高效保存和查找字符串集合的数据结构
#### Trie树基本性质
1. 根结点不包含字符，便于插入新字符，除了根结点以外所有节点都包含一个字符
2. 从根节点到某一个节点，路径上字符连接起来，为该节点对应的字符串-前缀
3. 一般节点树较少(26 大小写，数字)
    - 每一个节点最多26个子节点，并且每一个子节点包含的字符互不相同
    
#### 前缀树应用
    - 前缀匹配
    - 字符串检索
    - 自动补全
    - 词频统计
    - 字符串排序
#### HashMap查询时间复杂度真的是O(1)吗
- 当我们以String作为Key在map中做查询时，并不是O(1)而是O(L)
- String对象改写hashcode - 需要遍历String然后进行比对
```
public int hashCode() {
    int h = hash;
     if (h == 0 && value.length > 0) {
         char val[] = value;
 
         for (int i = 0; i < value.length; i++) {
             h = 31 * h + val[i];
         }
         hash = h;
     }
     return h;
 }
```
#### Trie 比 HashMap 优势在哪里
- Note: Trie的优势是在前缀查询方面，单一字符串查找没有区别
- 举例: abcdefg , dict = [abc, acg, abg, abcd]
    - 问: 目标字符串中包含dict中那些单词
- HashMap每一次查询前缀是否存在时需要再花费O(L)时间计算出Hashcode
    - 从头到尾 O(L + L-1 + L-2 + ... + 1) = O(L*L) - N是前缀数量
```
HashMap 解法 - 保存所有dict在Hashmap中
for(i) {
    for(j) {
        substring(i,j) 是否在hashMap中 
    }
}
```
- Trie每一次查询前缀是利用index直接查询花费O(L)
```
Trie 解法 - 
for(i) {
    for(j) {
        substring(i, j);
    }
}
```
#### 时空复杂度
- Time
    - 如果不使用Trie,通过HashMap可以储存所有词频和前缀
        - Insert: O(L) L is length of Word
        - find: O(NL) N is number of keys, L is length of word

    - 如果使用Trie
        - Insert：O(L) L is length of word
        - find: O(L) L is length of word
- Space
    - Trie
        - O(26*N*L): 26是字母总量，N是指dict中单词数量，L是指插入词的length
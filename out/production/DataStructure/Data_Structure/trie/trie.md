### Trie字典树，前缀树

#### Trie树基本性质
- 根结点不包含字符，便于插入新字符，除了根结点以外所有节点都包含一个字符
- 从根节点到某一个节点，路径上字符连接起来，为该节点对应的字符串-前缀
- 每一个节点最多26个子节点，并且每一个子节点包含的字符互不相同

#### 前缀树应用
    - 前缀匹配
    - 字符串检索
    - 自动补全
    - 词频统计
    - 字符串排序

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
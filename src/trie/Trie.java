package trie;

/**
 * Time complexity:
 *      - Insert: O(L) L is length of word
 *      - Find: (word/prefix) O(L) L is length of word
 * Space complexity:
 *      -
 *
 * */
public class Trie {
    // define root of trie
    private TrieNode root;

    public Trie() {
        // do intialization if necessary
        this.root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        this.root.insert(word, 0);
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode res = this.root.find(word, 0);
        return res!=null && res.hasEndWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode res = this.root.find(prefix, 0);
        return res!=null;
    }
}

class TrieNode {
    private TrieNode[] children;
    public boolean hasEndWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.hasEndWord = false;
    }

    public void insert(String word, int height) {
        if(height == word.length()) {
            this.hasEndWord = true; // mark is end of word;
            return;
        }
        // 同一条路径上可以有多个end word
        int pos = word.charAt(height) - 'a';
        if(this.children[pos]==null) {
            // char not exist - create one
            this.children[pos] = new TrieNode();
        }
        this.children[pos].insert(word, height+1);
    }

    public TrieNode find(String word, int height) {
        if(height == word.length()) {
            // return curr
            return this;
        }

        int pos = word.charAt(height) - 'a';
        if(this.children[pos]==null) {
            // if not found
            return null;
        }
        return this.children[pos].find(word, height+1);
    }
}
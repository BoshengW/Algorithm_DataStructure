package dynamic_program.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param s: A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> wordSet) {
        // write your code here
        if(s==null || s.length()==0) {
            return false;
        }

        if(wordSet==null || wordSet.size()==0) {
            return false;
        }

        return dfs(s, "", wordSet);
    }

    private boolean dfs(String target,
                        String sep,
                        Set<String> wordSet) {

        if(target.length()==0) {
            return true; // String have seperated completely
        }

        if(!seperate(target, sep)) {
            return false;
        }

        boolean flag = false;
        String newTarget = target.substring(sep.length());
        for(String word: wordSet) {
            System.out.println(word);
            flag = flag || dfs(newTarget, word, wordSet);
        }
        return flag;
    }

    private boolean seperate(String target, String sep) {
        // check if target can be seperated by sep
        for(int i=0; i<sep.length(); i++) {
            if(target.charAt(i)!=sep.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testcase = {"a"};
        Set<String> set = new HashSet<>();
        set.add("aaaa");
        set.add("aa");
        Solution obj = new Solution();
        obj.wordBreak("aaaaaaa", set);
    }
}

package trie;

import java.util.HashSet;

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        String[] patMap = new String[26];
        HashSet<String> used = new HashSet<>();
        return dfs(pattern, str, 0, patMap, used);

    }

    private boolean dfs(String pattern,
                        String str,
                        int start,
                        String[] patMap,
                        HashSet<String> used) {

        if(pattern.length()==0) {
            // used all word in str then match
            System.out.println(start);
            return str!=null && start==str.length();
        }

        // if current pattern inside patMap
        int pos = pattern.charAt(0)-'a';
        if(patMap[pos]!=null) {
            int length = patMap[pos].length();
            // current pattern exist but not match then return false
            if(length>str.length()-start || !patMap[pos].equals(str.substring(start, start+length))) {
                return false;
            }

            // current pattern exist and match a substirng
            if(dfs(pattern.substring(1),
                    str,
                    start+length,
                    patMap,
                    used)) {
                // if follow up match return true;
                return true;
            }
        } else {
            // if current pattern not in patMap 可以赋予新值
            for(int i=start+1; i<=str.length(); i++) {
                // 选择下一个字符串片段
                String cur = str.substring(start, i);
                // 片段被使用过跳过
                if(used.contains(cur)) {
                    continue;
                }
                // 片段没有被使用过
                patMap[pos] = cur;
                used.add(cur);
                if(dfs(pattern.substring(1),
                        str,
                        i,
                        patMap,
                        used)) {
                    // if follow up match return true;
                    return true;
                }
                // backtracking
                patMap[pos] = null;
                used.remove(cur);
            }
        }
        // if all checks are not successful then return false
        return false;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.wordPatternMatch("aa","dgdg"));
    }
}

package palindronmic_substring;

import java.util.*;

public class palindrome_partition {
    /*
    * Leetcode #131
    *
    * */

    public List<List<String>> partition(String target) {
        List<List<String>> res = new ArrayList<List<String>>();
        Deque<String> stack = new ArrayDeque<>();

        dfs(target, 0, stack, res);

        return res;
    }

    public void dfs(String target, int start, Deque<String> path, List<List<String>> res) {
        if(start>=target.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int j = start; j<target.length(); j++) {
            if(!checkPalindrome(target, start, j)) {
                continue;
            }

            path.addLast(target.substring(start, j+1));
            dfs(target, j+1, path, res);
            path.removeLast();

        }

    }


    public boolean checkPalindrome(String arrays, int start, int end) {
        if(arrays==null || arrays.length()==0) {
            return false;
        }

        while(start<end) {
            if(arrays.charAt(start) != arrays.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {

        palindrome_partition obj = new palindrome_partition();

        String testcase = "abcc";
        List<List<String>> result = obj.partition(testcase);
        for(List<String> item: result) {
            System.out.println(item);
        }


    }

}

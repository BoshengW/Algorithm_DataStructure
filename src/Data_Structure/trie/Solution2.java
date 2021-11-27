package Data_Structure.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution2 {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: return the maximum nunber
     */
    int max = 0;
    int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int wordSearchIII(char[][] board, List<String> words) {
        // write your code here
        if(board==null) return max;

        // save all prefix
        HashSet<String> prefix = new HashSet<>();
        // save all word
        HashSet<String> dict = new HashSet<>();
        // visited
        boolean[][] visited = new boolean[board.length][board[0].length];
        // save ans
        init(prefix, dict, words);

        // traversal
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                // dfs from each point
                if(!prefix.contains(""+board[i][j])) continue;
                visited[i][j] = true;
                dfs(board, i, j, i*board[0].length+j, visited, prefix, dict, ""+board[i][j], new ArrayList<>());
                visited[i][j] = false;
            }
        }

        return max;

    }

    private void dfs(char[][] board,
                     int dx,
                     int dy,
                     int start,
                     boolean[][] visited,
                     HashSet<String> prefix,
                     HashSet<String> dict,
                     String curr,
                     List<String> res) {

        if(dict.contains(curr)) {
            res.add(curr);
            max = Math.max(max, res.size());
            // System.out.println(curr);
            int next = start;
            dict.remove(curr);
            if(curr.equals("abce")) System.out.println("x: " + dx + ",y: " + dy + ",start: " + start);
            // find next point to scan in rest
            while(++next<board.length*board[0].length) {
                int sx = next/board[0].length;
                int sy = next%board[0].length;

                if(!visited[sx][sy]) {
                    // next start point
                    visited[sx][sy] = true;
                    // System.out.println("x: " + dx + ",y: " + dy);
                    // System.out.println(res.get(0));
                    // System.out.println("sx: " + sx + ",sy: " + sy);

                    dfs(board, sx, sy, next, visited, prefix, dict, ""+board[sx][sy], res);
                    visited[sx][sy] = false;
                }

            }

            res.remove(res.size()-1);
            dict.add(curr);
        }

        for(int i=0; i<4; i++) {
            int x = dx+dir[i][0];
            int y = dy+dir[i][1];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && !visited[x][y]) {
                visited[x][y] = true;
                dfs(board, x, y, start, visited, prefix, dict, curr+board[x][y], res);
                visited[x][y] = false;
            }
        }

    }

    private void init(HashSet<String> prefix, HashSet<String> dict, List<String> words) {
        for(String i: words) {
            dict.add(i);
            for(int j=1; j<=i.length(); j++) {
                prefix.add(i.substring(0, j));
            }
        }
    }

    public static void main(String[] args) {
        char[][] t1 = {{'a','b','c','e'},{'s','f','c','s'},{'a','b','e','e'}};
        String[] t2 = {"abce","ab"};
        List<String> t3 = new ArrayList<>();

        for(String i: t2) {
            t3.add(i);
        }
        Solution2 obj = new Solution2();
        obj.wordSearchIII(t1,t3);
    }
}
package Code_Interview.String.palindronmic_substring;

public class Solution {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public static String longestPalindrome(String s) {
        // write your code here
        if(s.length()<=1) return s;

        int maxLen = Integer.MIN_VALUE;
        int[] res = new int[2];

        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
            // 枚举中心点
            int r1 = 0;
            int temp = 0;
            // 偶数
            while(i+1+r1<s.length() && i-r1>=0) {
                // 没越界
                System.out.println(s.substring(i-r1, i+1));
                System.out.println(s.substring(i+1, i+1+r1+1));
                if(!s.substring(i-r1, i+1).equals(s.substring(i+1, i+1+r1+1))) {
                    break;
                }
                // if 回文
                temp += 2;
                if(temp>maxLen) {
                    maxLen = temp;
                    res[0] = i-r1;
                    res[1] = i+1+r1;
                }
                r1++;
            }



            // 奇数
            int r2 = 1;
            temp = 1;
            while(i+r2<s.length() && i-r2>=0) {
                System.out.println(s.substring(i-r2, i+1));
                System.out.println(s.substring(i, i+r2+1));
                if(!s.substring(i-r2, i+1).equals(s.substring(i, i+r2+1))) {
                    break;
                }

                temp += 2;
                if(temp>maxLen) {
                    maxLen = temp;
                    res[0] = i-r2;
                    res[1] = i+r2;
                }
                r2++;
            }


        }

        return s.substring(res[0], res[1]+1);
    }

    public static void main(String[] args) {
        String testcase = "aba";
        Solution.longestPalindrome(testcase);
    }
}

package palindronmic_substring;

public class LongestPalindronmicSubstring {
    /*
    * 最长回文字符串
    * 1. Enumeration - O(n2)
    * 2. Dynamic Programming O(n2)
    * 3. Manacher's Algorithm O(n)
    * */
    public String LongestPalindronmicSubstring(String s) {
        if(s==null) {
            return null;
        }

        // check odd length substring
        String longestSubstring = "";
        for(int i=0; i<s.length();i++) {
            String temp = longestPalidronHelper(s, i, i);
            if(longestSubstring.length()<temp.length()) longestSubstring=temp;

        }

        // check even length substring
        for(int j=0; j<s.length()-1;j++){
            String temp = longestPalidronHelper(s, j, j+1);
            if(longestSubstring.length()<temp.length()) longestSubstring=temp;
        }

        return longestSubstring;


    }

    private String longestPalidronHelper(String s, int start, int end) {
        while(start>=0 && end<=s.length()-1) {
            if(s.charAt(start)==s.charAt(end)) {
                start--;
                end++;
            } else break;
        }
        return s.substring(start+1, end);
    }


    public static void main(String[] args) {
        String s = "bb";
        LongestPalindronmicSubstring obj = new LongestPalindronmicSubstring();
        System.out.println(obj.LongestPalindronmicSubstring(s));
    }

}

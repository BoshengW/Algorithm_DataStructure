package twopointer;

public class ValidPalindrome_II {
    /*
    * A String can also be palindrome if it is palidrome after removing at most 1 character.
    * 贪心 -> 当两个指针对应元素不相等时，删除其中一个字符如果相等那么继续
    * 不同于ValidPalindrome1，这里不用判断不合理字符
    *
    * Solution 1:
    *
    * */
    public boolean ValidPalindromeII(String s) {
        if(s == null) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return checkEqual(s, left+1, right) || checkEqual(s, left, right-1);
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isValidChar(char a) {return false;}

    public boolean checkEqual(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        ValidPalindrome_II obj1 = new ValidPalindrome_II();
        System.out.println(obj1.ValidPalindromeII(s));
    }
}

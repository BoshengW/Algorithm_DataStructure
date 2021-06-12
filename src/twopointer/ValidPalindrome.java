package twopointer;

public class ValidPalindrome {
    /*
    * ignore upper-lower case and non-valid characters find palindrome
    *
    * String Common methods:
    * 1. isLetter()
    * 2. isDigit()
    * 3. toLowerCase()
    * 4. toUpperCase()
    * */
    public boolean checkPalindrome(String str) {
        if(str==null) return false;

        int left = 0;
        int right = str.length()-1;

        while(left<right) {
            if(!checkValidChar(str.charAt(left))) {
                left++;
            }

            if(!checkValidChar(str.charAt(right))) {
                right--;
            }

            if(checkValidChar(str.charAt(left)) && checkValidChar(str.charAt(right))) {
                if(Character.toLowerCase(str.charAt(left)) == Character.toLowerCase(str.charAt(right))) {
                    left++;
                    right--;
                } else return false;
            }

        }
        return true;
    }

    public boolean checkValidChar(char target) {
        return Character.isLetter(target) && Character.isDigit(target);
    }




    public static void main(String[] args) {
        ValidPalindrome obj = new ValidPalindrome();
        obj.checkPalindrome("ab");
    }
}

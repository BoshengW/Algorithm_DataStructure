package Code_Interview.Google;

import java.util.Arrays;
import java.util.HashMap;

// 猜词游戏
public class Guess {
    // Time: O(L) Space: O(L)
    public static int[] guess_secret(String a, String b) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int same = 0;
        int wrPos = 0;
        // cal all char freq in b
        for(int i=0; i<b.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) freq.put(b.charAt(i), freq.getOrDefault(b.charAt(i), 0)+1);
            else same++;

        }

        // match word a w b
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                // check if no match map have this
                if(freq.containsKey(a.charAt(i)) && freq.get(a.charAt(i))>0) {
                    wrPos++;
                    freq.put(a.charAt(i), freq.get(a.charAt(i))-1);
                }
            }
        }

        return new int[]{same, wrPos};

    }

    public static void main(String[] args) {
        int[] res = Guess.guess_secret("AABB","CCAA");
        System.out.println(Arrays.toString(res));
    }
}

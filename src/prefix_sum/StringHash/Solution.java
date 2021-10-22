package prefix_sum.StringHash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();

        HashMap<Long, Integer> map = new HashMap<>();

        long[] hash = new long[s.length()+1];
        long pow = 1; // make sure it not exceed value limit

        int P = 31;

        // calculate all prefix hash of String
        for(int i=1; i<=s.length(); i++) {
            hash[i] = hash[i-1]*P + s.charAt(i-1);
            System.out.println(hash[i]);
        }


        long temp = 0;
        int strLength = 2;
        // traversal
        for(int i=0; i<s.length()-strLength+1;i++) {

            temp = hash[i+strLength] - hash[i]*P*P;
            System.out.println(s.substring(i, i+strLength));

            map.put(temp, map.getOrDefault(temp, 0) + 1);

            if(map.get(temp)==2) {
                res.add(s.substring(i, i+strLength));
            }

        }

        return res;

    }

    public static void main(String[] args) {
        String a = "AABABC";
        List<String> res = Solution.findRepeatedDnaSequences(a);

        System.out.println(Arrays.toString(res.toArray()));
    }
}
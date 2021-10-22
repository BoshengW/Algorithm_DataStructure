package prefix_sum.StringHash;

public class StringHash {



    public static void main(String[] args) {
        String str = "abcd";
        String target = "bc";

        int P = 131;
        long[] hash = new long[str.length()];

        long target_hash = 0;
        long pow = 1;

//        // calculate target hash
//        for(int i=0; i<target.length()-1;i++) {
//            target_hash = target_hash*P + target.charAt(i);
//            pow *= P;
//        }
//
//        // calculate prefix of
//        for(int i=1; i<str.length(); i++) {
//            hash[i] = hash[i-1]*P + str.charAt(i);
//
//        }

        int a = 0 + 'A';
        System.out.println(a);
    }


}

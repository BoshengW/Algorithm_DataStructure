package prefix_sum;

public class PrefixSum {

    private int[] prefixSum1D(int[] A) {
        int[] s = new int[A.length+1];
        for(int i=0; i<A.length; i++) {
            s[i+1] = s[i] + A[i];
        }

        return s;
    }

    private int[][] prefixSum2D(int[][] A) {
        return null;
    }

    public static void main(String[] args) {

    }
}

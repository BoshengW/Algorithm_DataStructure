package difference_array;

public class DiffArray {

    private static void insert1D(int[] diff1D, int l, int r, int C) {
        // 在一个区间所有值都加C
        diff1D[l] += C;
        diff1D[r+1] -= C;
    }

    private static void insert2D(int[][] diff2D, int x1, int x2, int y1, int y2, int C) {
        // 在一个2D区间所有值都加C
        diff2D[x1][y1] += C;
        diff2D[x1][y2+1] -= C;
        diff2D[x2+1][y1] -= C;
        diff2D[x2+1][y2+1] += C;
    }

    public static void main(String[] args) {
        int[] tc1 = {1,2,3,4};
        int[][] tc2 = {{2,3,1}, {2,1,2}, {1,2,2}};

        int[] d1 = new int[tc1.length+2];
        int[][] d2 = new int[tc2.length+2][tc2[0].length+2];

        // 1D 差分
        int sum = 0;
        for(int i=1; i<=tc1.length; i++) {
            DiffArray.insert1D(d1, i, i, tc1[i-1]);
            d1[i] += d1[i-1]; // 前缀和来还原每一个元素值
//            System.out.println(d1[i]);
        }

        // 2D 差分
        for(int i=1; i<=tc2.length; i++) {
            for(int j=1; j<=tc2[0].length; j++) {
                DiffArray.insert2D(d2, i,i,j,j,tc2[i-1][j-1]);
            }
        }

        // 难点: 通过差分还原2D数组
        int[][] S = new int[tc2.length+2][tc2[0].length+2];
        for(int i=1; i<=tc2.length; i++) {
            for(int j=1; j<=tc2[0].length; j++) {
                //前缀和
                S[i][j] = d2[i][j] + S[i-1][j] + S[i][j-1] - S[i-1][j-1]; // 前缀和
                System.out.println(S[i][j]);
            }
        }
    }
}

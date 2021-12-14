package Code_Interview.Amazon;

public class ContinuousDescSubArray {
    /**
     * 找出所有连续递减subarray个数
     *
     * */

    public int coutDescRatings(int[] ratings) {
        int st = 0;
        int res = 0;
        for(int i=0; i<ratings.length; i++) {
            if(i>0 && ratings[i]>=ratings[i-1]) {
                st = i;
            }
            res += (i-st+1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] t = {9,8,6,7,6,5};

        ContinuousDescSubArray obj = new ContinuousDescSubArray();
        System.out.println(obj.coutDescRatings(t));
    }
}

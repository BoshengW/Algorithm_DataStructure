package Code_Interview.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeAirTime {
    /**
     * Two Sum 变种
     * 在两个array中寻找target最接近或者==target的所有解
     *
     * */
    public int[] findTargetOnce(int[][] arr1, int[][] arr2, int target) {
        if(arr1==null || arr1.length==0) return null;

        // 根据score排序
        Arrays.sort(arr1, (x, y)->x[1]-y[1]);
        Arrays.sort(arr2, (x, y)->x[1]-y[1]);
        int min = Integer.MAX_VALUE;
        int[] ids = new int[2];
        for(int i=0; i<arr1.length; i++) {
            int res = target - arr1[i][1];
            // binary search find last index < res
            int l=0, r=arr2.length-1;
            while(l<r) {
                int mid = l + (r-l+1>>1);
                if(arr2[mid][1]<res) l=mid;
                else r=mid-1;
            }
            // l <= res
            int tIdx = l;
            if(l+1<arr2.length && Math.abs(arr2[l+1][1]-res)<Math.abs(arr2[l][1]-res)) {
                tIdx = l+1;
            }
            System.out.println("arr1 : " + arr1[i][0] + ", arr2 target : " + arr2[tIdx][0]);
            if(Math.abs(arr2[tIdx][1]-res)<min) {
                min = Math.abs(arr2[tIdx][1]-res);
                ids[0] = arr1[i][0];
                ids[1] = arr2[tIdx][0];
            }
        }
        return ids;
    }
    int min = Integer.MAX_VALUE;

    public List<int[]> findTargetDup(int[][] arr1, int[][] arr2, int target) {
        // 根据score排序
        Arrays.sort(arr1, (x, y)->x[1]-y[1]);
        Arrays.sort(arr2, (x, y)->x[1]-y[1]);

        List<int[]> ids = new ArrayList<>();
        for(int i=0; i<arr1.length; i++) {
            int res = target - arr1[i][1];
            // binary search find last index < res
            int l=0, r=arr2.length-1;
            while(l<r) {
                int mid = l + (r-l+1>>1);
                if(arr2[mid][1]<res) l=mid;
                else r=mid-1;
            }
            // l <= res
            int tIdx = l;
            if(l+1<arr2.length && Math.abs(arr2[l+1][1]-res)<Math.abs(arr2[l][1]-res)) {
                tIdx = l+1;
            }

            ids = findDup(arr1, arr2, tIdx, ids, res, i);

        }
        return ids;
    }

    private List<int[]> findDup(int[][] arr1, int[][] arr2, int tIdx, List<int[]> ids, int res, int i) {
        if(Math.abs(arr2[tIdx][1]-res)<min) {
            min = Math.abs(arr2[tIdx][1]-res);
            ids = new ArrayList<>();

        } else if(Math.abs(arr2[tIdx][1]-res)>min) {
            return ids;
        }
        int left=tIdx, right=tIdx+1;
        while(left>=0 && arr2[left][1]==arr2[tIdx][1]) {
            int[] tmp = new int[2];
            tmp[0] = arr1[i][0];
            tmp[1] = arr2[tIdx][0];
            ids.add(tmp);
            left--;
        }

        while(right<arr2.length && arr2[right][1]==arr2[tIdx][1]) {
            int[] tmp = new int[2];
            tmp[0] = arr1[i][0];
            tmp[1] = arr2[tIdx][0];
            ids.add(tmp);
            right++;
        }

        return ids;
    }


    public static void main(String[] args) {
        int[][] arr1 = {{1, 2000}, {2, 3000}, {3, 4000}, {4, 2000} };
        int[][] arr2 = { { 1, 5000 }, {2, 3000} };

        PrimeAirTime obj = new PrimeAirTime();
//        System.out.println(Arrays.toString(obj.findTargetOnce(arr1, arr2, 7500)));
        List<int[]> res = obj.findTargetDup(arr1, arr2, 7500);
        for(int[] i: res) {
            System.out.println(Arrays.toString(i));
        }
    }
}

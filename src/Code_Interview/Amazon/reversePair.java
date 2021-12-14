package Code_Interview.Amazon;

public class reversePair {
    // 归并排序是可以观察阶段性排序结果的算法
    int res = 0;
    public int reversePairs(int[] nums) {
        merge(nums, 0, nums.length-1);
        return res;
    }

    private int[] merge(int[] nums, int l, int r) {
        if(l==r) {
            return new int[]{nums[l]};
        }

        int mid = l + (r-l>>1);
        int[] left = merge(nums, l, mid);
        int[] right = merge(nums, mid+1, r);

        // 分治的每一个区间互相之间的相对位置是固定的
        // Left/Right区间内部虽然位置变化了 但是 Left和Right之间Left元素位置都比Right元素位置靠前，所以可以放心进行逆序对比较
        // 如果Left元素 (idx1)>Right元素 (idx2)即出现逆序对，那么idx2-idx1个逆序对
        int[] arr = new int[left.length+right.length];
        int idx = 0;
        int i=0, j=0;
        while(i<left.length && j<right.length) {
            // 如果left<=right不计算
            if(left[i]<=right[j]) arr[idx++] = left[i++];
            else {
                res+=(j-i);
                arr[idx++] = right[j++];
            }
        }

        while(i<left.length) arr[idx++] = left[i++];
        while(j<right.length) arr[idx++] = right[j++];

        return arr;

    }

    public static void main(String[] args) {
        int[] t = {7, 5, 6, 4};
        reversePair obj = new reversePair();
        obj.reversePairs(t);
    }
}

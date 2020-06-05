package leetcode;

//左右都是闭区间，则L=R时的元素必定是所找元素所应该在的位置。
public class LC704 {
    public int search(int[] arr, int T) {
        int L = 0, R = arr.length - 1;
        while (L < R) {
            int M = (L + R) >> 1;
            if (arr[M] == T) return M;
            if (arr[M] > T) R = M - 1;
            if (arr[M] < T) L = M + 1;
        }
        return arr[L] == T? L: -1;
    }
}
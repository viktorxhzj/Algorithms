package leetcode;

// 先找左边界，如果找不到目标元素直接返回。再找右边界。
public class LC34 {
    public int[] searchRange(int[] arr, int T) {
        int[] res = {-1, -1};
        int L = 0, R = arr.length;
        while (L < R) {
            int M = L + ((R - L) >> 1);
            if (arr[M] == T) R = M;
            if (arr[M] > T) R = M;
            if (arr[M] < T) L = M + 1;
        }
        if (L == arr.length || arr[L] != T) return res;
        res[0] = L;

        L = 0;
        R = arr.length;
        while (L < R) {
            int M = L + ((R - L) >> 1);
            if (arr[M] == T) L = M + 1;
            if (arr[M] > T) R = M;
            if (arr[M] < T) L = M + 1;
        }
        res[1] = L - 1;
        return res;
    }
}

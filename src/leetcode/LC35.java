package leetcode;

// 搜索右边界。如果查找不到此数，则右边界为答案。
public class LC35 {
    public int searchInsert(int[] arr, int T) {
        int L = 0, R = arr.length;

        while (L < R) {
            int M = L + ((R - L) >> 1);
            if (arr[M] == T) L = M + 1;
            if (arr[M] > T) R = M;
            // 因此结束时，left所在位置绝不可能是target，但left - 1可能是
            if (arr[M] < T) L = M + 1;
        }

        // 有可能超出边界
        if (L == 0) return 0;

        return arr[L - 1] == T? L - 1: L;
    }
}

class LC35II {
    public int searchInsert(int[] arr, int T) {
        int L = 0, R = arr.length;

        while (L < R) {
            int M = L + ((R - L) >> 1);
            if (arr[M] == T) R = M;
            if (arr[M] > T) R = M;
            if (arr[M] < T) L = M + 1;
        }

        return L;
    }
}

package leetcode;

// 要注意平方越界的问题，不能用乘积。
public class LC69 {
    public int mySqrt(int x) {
        if (x == 1 || x == 2 || x == 3) return 1;
        int left = 1, right = x / 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) return mid;
            if (mid < x / mid) {
                left = mid + 1;
            }
            if (mid > x / mid) {
                right = mid - 1;
            }
        }
        return left <= x / left? left: left - 1;
    }
}

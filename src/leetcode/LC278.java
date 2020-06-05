package leetcode;

// 逼近一边的边界，因为是必定存在。
public class LC278 {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean isBadVersion(int mid) {
        return true;
    }
}

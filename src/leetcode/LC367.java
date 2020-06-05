package leetcode;

// 用除法处理平方越界的同时，要判断是否余数为零来检验完全平方。
public class LC367 {
    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 4) return true;
        int left = 1, right = num / 2;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (num % mid == 0 && num / mid == mid) return true;
            else if (num /  mid == mid) return false;
            else if (num / mid > mid) left = mid + 1;
            else right = mid - 1;
        }
        return num % left == 0 && num / left == left;
    }
}

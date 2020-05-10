package leetcode;

public class LC7 {
    public int reverse(int x) {
        int sum = 0;
        if (x > 0) {
            int m = Integer.MAX_VALUE;
            while (x != 0) {
                if (sum > m / 10) return 0;
                sum *= 10;
                if (m - sum < x % 10) return 0;
                sum += x % 10;
                x /= 10;
            }
        }
        else {
            int m = Integer.MIN_VALUE;
            while (x != 0) {
                if (sum < m / 10) return 0;
                sum *= 10;
                if (sum < m - x % 10) return 0;
                sum += x % 10;
                x /= 10;
            }
        }
        return sum;
    }
}

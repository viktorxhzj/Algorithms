package leetcode;

public class LC50 {
    double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            // 当前最低位为1，则计入贡献
            if ((N & 1) == 1) ans *= x_contribute;
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃二进制表示的最低位，这样我们每次只要判断最低位即可
            N >>= 1;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }
}

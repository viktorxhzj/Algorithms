/**
 * 字符串相乘
 *
 * 思路：10进制按位加和
 */

/**
 * LeetCode 9
 * 回文数
 *
 * 思路：10进制按位取余
 */
class LC9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        return x == reverse(x);
    }

    public int reverse(int x) {
        int sum = 0;
        int m = Integer.MAX_VALUE;
        while (x != 0) {
            if (sum > m / 10) return 0;
            sum *= 10;
            if (m - sum < x % 10) return 0;
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}

/**
 * 剑指67
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 思路：10进制按位判断取余
 */
class LC8 {
    public int strToInt(String str) {
        char[] cs = str.toCharArray();
        int i = 0;
        boolean neg = false;
        while (i < cs.length && cs[i] == ' ') i++;
        if (i == cs.length) return 0;
        if (cs[i] != '+' && cs[i] != '-' && (cs[i] - '0' < 0 || cs[i] - '0' > 9)) return 0;
        if (cs[i] == '-') {
            neg = true;
            i++;
        }
        else if (cs[i] == '+') i++;
        int res = 0, temp = 0;
        while (i < cs.length && cs[i] - '0' >= 0 && cs[i] - '0' <= 9) {
            temp = cs[i] - '0';
            if (neg) {
                if (res < Integer.MIN_VALUE / 10) return Integer.MIN_VALUE;
                res *= 10;
                if (Integer.MIN_VALUE - res > -temp) return Integer.MIN_VALUE;
                res -= temp;

            }
            else {
                if (res > Integer.MAX_VALUE / 10) return Integer.MAX_VALUE;
                res *= 10;
                if (Integer.MAX_VALUE - res < temp) return Integer.MAX_VALUE;
                res += temp;

            }
            i++;
        }
        return res;
    }
}

/**
 * LeetCode 7
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 思路：10进制按位判断取余
 */
class LC7 {
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
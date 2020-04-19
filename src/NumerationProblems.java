/**
 * 字符串相乘
 *
 * 思路：10进制按位加和
 */
class LC43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] s1 = num1.toCharArray();
        char[] s2 = num2.toCharArray();
        String res = "0";
        for (int j = s2.length - 1; j >= 0; j--) {
            int carry = 0;
            StringBuilder bd = new StringBuilder();
            for (int k = 0; k < (s2.length - 1 - j); k++) {
                bd.append('0');
            }
            int n2 = s2[j] - '0';
            for (int i = s1.length -1; i >= 0; i--) {
                int n1 = s1[i] - '0';
                bd.append((carry + n1 * n2) % 10);
                if (carry + n1 * n2 >= 10) carry = (carry + n1 * n2) / 10;
                else carry = 0;
            }
            if (carry != 0) bd.append(carry);
            res = addStrings(res, bd.reverse().toString());
        }
        return res;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }
}

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
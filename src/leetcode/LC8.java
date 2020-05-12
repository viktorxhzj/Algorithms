package leetcode;

public class LC8 {
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

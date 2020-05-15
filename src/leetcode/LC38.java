package leetcode;

public class LC38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int j = 2; j <= n; j++) {
            char[] cs = str.toCharArray();
            StringBuilder bd = new StringBuilder();
            int i = 0;
            while (i < cs.length) {
                char num = cs[i];
                int count = 0;
                while (i < cs.length && cs[i] == num) {
                    i++;
                    count++;
                }
                bd.append(count);
                bd.append(num);
            }
            str = bd.toString();
        }
        return str;
    }
}

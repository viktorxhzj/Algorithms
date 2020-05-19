package leetcode;

import java.util.LinkedList;

public class LC394 {
    public String decodeString(String s) {
        char[] str = s.toCharArray();
        StringBuilder list = new StringBuilder();
        LinkedList<Integer> num = new LinkedList<>();
        int k = 0;
        while (k < str.length) {
            // if it is a number
            if (str[k] >= '0' && str[k] <= '9') {
                int sum = 0;
                while (str[k] >= '0' && str[k] <= '9') {
                    sum = sum * 10 + str[k] - '0';
                    k++;
                }
                num.addLast(sum);
            }
            else if (str[k] == '[' || (str[k] >= 'a' && str[k] <= 'z') || (str[k] >= 'A' && str[k] <= 'Z')) {
                list.append(str[k++]);
            }
            else {
                int t = num.removeLast();
                int j = list.length() - 1;
                while (list.charAt(j) != '[') j--;
                String tmp = list.substring(j + 1);
                list.deleteCharAt(j);
                while (t-- > 1) {
                    list.append(tmp);
                }
                k++;
            }
        }
        return list.toString();
    }
}

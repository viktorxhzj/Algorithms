package leetcode;

public class LC43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        char[] cs1 = num1.toCharArray(), cs2 = num2.toCharArray();
        int[] res = new int[cs1.length + cs2.length];

        //  index:  0   1   2   3   4   5   6
        //
        //                  9   9   9   9   9
        //                              9   9
        //          -   -   -   -   -   -   -
        //                              8   1
        //                          8   1
        //                      8   1
        //                  8   1
        //              8   1
        //          -   -   -   -   -   -   -
        //                          8   1
        //                      8   1
        //                  8   1
        //              8   1
        //          8   1

        for (int j = cs2.length - 1; j >= 0; j--) {
            for (int i = cs1.length - 1; i >= 0; i--) {
                int mul = (cs1[i] - '0') * (cs2[j] - '0');
                int sum = mul + res[i + j + 1];
                // 只确保当前位为个位数
                res[i + j + 1] = sum % 10;
                // 下一位可以为双位数，因为到最后一格最多也是单位数
                res[i + j] += sum / 10;
            }
        }
        int index = 0;
        while (res[index] == 0) index++;
        StringBuilder bd = new StringBuilder();
        for (; index < res.length; index++) bd.append(res[index]);
        return bd.toString();
    }
}

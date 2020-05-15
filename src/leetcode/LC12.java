package leetcode;

public class LC12 {
    public String intToRoman(int num) {
        String[] str = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder bd = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num - arr[i] < 0) {
                i++;
                continue;
            }
            num -= arr[i];
            bd.append(str[i]);
        }
        return bd.toString();
    }
}

package leetcode;

public class LC29 {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == Integer.MIN_VALUE){ // 此处如不特判，后面会陷入死循环
            if(dividend == Integer.MIN_VALUE) return 1;
            else return 0;
        }
        if(divisor == -1) return -dividend;
        if(divisor == 1) return dividend;
        boolean d = true; // 同号标志
        if(dividend <= 0 && divisor > 0){
            d = false;
            divisor = -divisor;
        }else if(dividend >= 0 && divisor < 0){
            d = false;
            dividend = -dividend;
        }else if(dividend >= 0 && divisor > 0){
            dividend = -dividend;
            divisor = -divisor;
        }
        int div = divisor, k = 1, result = 0;
        final int bound = Integer.MIN_VALUE >> 1;
        while(true){
            dividend -= div;
            if(dividend > 0){
                if(k == 1) return d == true ? result : -result;
                else{
                    dividend += div;
                    div = divisor;
                    k = 1;
                    continue;
                }
            }
            result += k;
            if(div >= bound){ // ****溢出判断，不能让 div 左移后溢出了
                div <<= 1;
                k <<= 1;
            }
        }
    }
}

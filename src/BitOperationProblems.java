/**
 * 剑指56-I
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 *
 * 思路：异或+分类
 */
class JZ56I {
    public int[] singleNumbers(int[] nums) {
        int temp = 0;
        for (int num : nums) temp ^= num;
        int shift = 0;
        while ((temp & 1) == 0) {
            shift++;
            temp >>= 1;
        }
        int[] result = new int[2];
        for (int num: nums) {
            int local = num >> shift;
            if ((local & 1) == 0) result[0] ^= num;
            else result[1] ^= num;
        }
        return result;
    }
}

/**
 * 剑指56-II
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * 思路：遍历二进制位
 */
class JZ56II {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 31; i >= 0; i--) {
            int res = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & 1) == 1) res++;
                nums[j] >>>= 1;
            }
            if (res % 3 != 0) bits[i] = 1;
        }
        int sum = 0;
        for (int bit: bits) {
            sum *= 2;
            sum += bit;
        }
        return sum;
    }

    public static void main(String[] args) {
        JZ56II test = new JZ56II();
        test.singleNumber(new int[]{3, 4, 3, 3});
    }
}

/**
 * 剑指65
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * 思路：位运算
 */
class JZ65 {
    public int add(int a, int b) {
        int s, c;
        while (b != 0) {
            s = a ^ b;
            c = (a & b) << 1;
            a = s;
            b = c;
        }
        return a;
    }
}

/**
 * 2的幂
 */
class LC231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}


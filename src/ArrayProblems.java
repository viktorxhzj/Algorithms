import java.util.*;


/**
 * 剑指39
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 思路：摩尔投票法
 */
class JZ39 {
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}

/**
 * 剑指45
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 思路：比较器
 */
class JZ45 {
    public String minNumber(int[] nums) {
        //得到一个String类型数组，形似nums
        String[] strNumbers = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strNumbers[i] = String.valueOf(nums[i]);
        }
        //排序。（传入一个比较器对象）
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);//升序
            }
        });
        //将该字符串数组元素拼接起来
        StringBuilder sb = new StringBuilder();
        for (String strNumber : strNumbers) {
            sb.append(strNumber);
        }
        return sb.toString();
    }
}

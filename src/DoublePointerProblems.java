import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 剑指21
 * 调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 思路：首尾双指针
 */
class JZ21 {
    public int[] exchange2(int[] nums) {
        int i = 0, j = nums.length - 1, temp;
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && (nums[j] & 1) == 0) j--;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}

/**
 * 剑指57
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 *
 * 思路：首尾双指针
 */
class JZ57 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) i++;
            else if (nums[i] + nums[j] > target) j--;
            else return new int[]{nums[i], nums[j]};

        }
        return new int[2];
    }
}

/**
 * 剑指58-I
 * 输入一个英文句子，翻转句子中单词的顺序
 *
 * 思路：前后双指针
 */
class JZ58I {
    public String reverseWords(String s) {
        s = s.trim(); // 删除首尾空格
        char[] cs = s.toCharArray();
        int j = cs.length - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while (i >= 0 && cs[i] != ' ') i--; // 搜索首个空格
            char[] local = new char[j - i];
            for (int k = i + 1; k <= j; k++) local[k - i - 1] = cs[k];
            res.append(local).append(' '); // 添加单词
            while (i >= 0 && cs[i] == ' ') i--; // 跳过单词间空格
            j = i; // j 指向下个单词的尾字符
        }
        return res.toString().trim(); // 转化为字符串并返回
    }

    public static void main(String[] args) {
        JZ58I test = new JZ58I();
        String res = test.reverseWords("  Hello   World!   ");
        System.out.println("END");
    }
}

/**
 * LeetCode 480
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 */
class LC480 {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;

        // 优雅!
        while (i < j && chars[i] == chars[j]) {
            i++;
            j--;
        }
        if (isValid(chars,i+1,j)) return true;
        return isValid(chars, i, j - 1);
    }

    private boolean isValid(char[] chars,int i,int j) {
        while (i < j) {
            if (chars[i++]!=chars[j--]) return false;
        }
        return true;
    }
}

/**
 * LeetCode 15
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 */
class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int k = 0;
        while (k <= nums.length - 3 && nums[k] <= 0) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                k++;
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == -nums[k]) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i + 1] == nums[i]) i++;
                    while (i < j && nums[j - 1] == nums[j]) j--;
                    i++;
                    j--;
                }
                else if (nums[i] + nums[j] < -nums[k]) i++;
                else j--;
            }
            k++;
        }
        return res;
    }
}

/**
 * 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 首尾双指针
 */
class LC16 {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                ans = Math.abs(sum - target) < Math.abs(ans - target) ? sum: ans;
                if (sum == target) return ans;
                else if (sum < target) i++;
                else j--;
            }
        }
        return ans;
    }
}
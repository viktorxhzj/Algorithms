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


/**
 * 剑指53
 * 统计一个数字在排序数组中出现的次数。
 *
 * 思路：BiSearch
 */
class JZ53 {
    public int search(int[] nums, int target) {
        int index = biSearchM(nums, 0, nums.length - 1, target);
        if (index == -1) return 0;
        int count = 1, i = index - 1;
        while (i >= 0 && nums[i] == target) {
            count++;
            i--;
        }
        i = index + 1;
        while (i < nums.length && nums[i] == target) {
            count++;
            i++;
        }
        return count;

    }

    public int biSearchM(int[] arr, int low, int high, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (target == arr[mid]) return mid;
        if (target < arr[mid]) return biSearchM(arr, low, mid - 1, target);
        else return biSearchM(arr, mid + 1, high, target);
    }
}

/**
 * 剑指53-II
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 思路：BiSearch
 */
class JZ53II {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    public int biSearch(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int i = 0, j = nums.length - 1;
        if (target < nums[0] || target > nums[nums.length - 1]) return -1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (target == nums[m]) return m;
            if (nums[m] > target) j = m - 1;
            else i = m + 1;
        }
        return -1;
    }
}

/**
 * 剑指58-II
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 *
 * 思路：切片
 */
class JZ58II {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}

/**
 * 剑指64
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 思路：短路原则！
 */
class JZ64 {
    public int sumNums(int n) {
        int sum = n;
        boolean arg = (n > 0) && ((sum += sumNums(n-1)) > 0);
        return sum;
    }
}










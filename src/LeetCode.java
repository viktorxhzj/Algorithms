import java.util.*;

class FindRepeatNumber {
    /*
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
    请找出数组中任意一个重复的数字。
     */

    // 额外哈希表 O(n)
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            if (myMap.containsKey(nums[i])) {
                value = nums[i];
                break;
            }
            else {
                myMap.put(nums[i], i);
            }
        }
        return value;
    }
    // 本身就是哈希表 O(n)
    public int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return -1;

    }
}

class LeetCode1 {
    // [22ms, 42.72%] Bruteforce O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if (length < 2) {
            return new int[]{};
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (target == (nums[i] + nums[j])) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    // [3ms, 97.17%] Hashmap O(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if ((map.containsKey(complement)) && (map.get(complement) != i)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}

class LeetCode9 {
    // [15ms, 13.45%] O(logn)
    public static boolean isPalindrome(int x) {
        if (x == 2147483647) {
            return false;
        }
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int exp = 0;
        int baseTen = (int) Math.pow(10, exp);
        while ((x / baseTen) > 0) {
            exp++;
            baseTen = (int) Math.pow(10, exp);
        }
        int length = exp;
        int[] digits = new int[length];
        exp--;
        baseTen = (int) Math.pow(10, exp);
        for (int index = 0; index < length; index++) {
            digits[index] = x / baseTen;
            x = x % baseTen;
            exp--;
            baseTen = (int) Math.pow(10, exp);
        }
        int i = 0;
        int j = length - 1;
        while (i <= j) {
            if (digits[i] == digits[j]) {
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}

class LeetCode13 {
    // [12ms, 20.55%] SwitchCase O(7n)
    public static int romanToInt(String s) {
        int i = 0;
        int length = s.length();
        int num = 0;
        while (i < length) {
            switch(s.charAt(i)) {
                case 'M':
                    num += 1000;
                    i++;
                    break;
                case 'D':
                    num += 500;
                    i++;
                    break;
                case 'C':
                    if ((i + 1 < length) && (s.charAt(i + 1) == 'D')) {
                        num += 400;
                        i = i + 2;
                        break;
                    }
                    else if ((i + 1 < length) && (s.charAt(i + 1) == 'M')) {
                        num += 900;
                        i = i + 2;
                        break;
                    }
                    else {
                        num += 100;
                        i++;
                        break;
                    }
                case 'L':
                    num += 50;
                    i++;
                    break;
                case 'X':
                    if ((i + 1 < length) && (s.charAt(i + 1) == 'L')) {
                        num += 40;
                        i = i + 2;
                        break;
                    }
                    else if ((i + 1 < length) && (s.charAt(i + 1) == 'C')) {
                        num += 90;
                        i = i + 2;
                        break;
                    }
                    else {
                        num += 10;
                        i++;
                        break;
                    }
                case 'V':
                    num += 5;
                    i++;
                    break;
                case 'I':
                    if ((i + 1 < length) && (s.charAt(i + 1) == 'V')) {
                        num += 4;
                        i = i + 2;
                        break;
                    }
                    else if ((i + 1 < length) && (s.charAt(i + 1) == 'X')) {
                        num += 9;
                        i = i + 2;
                        break;
                    }
                    else {
                        num += 1;
                        i++;
                        break;
                    }
            }
        }
        return num;

    }
}

class LeetCode14 {
    // [1ms, 81.72%] Horizontal Traversal O(S)
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String shortest = strs[0];

        for (String element: strs) {
            if (element.length() < shortest.length()) {
                shortest = element;
            }
        }

        StringBuilder builder = new StringBuilder();

        int minSize = shortest.length();
        outer: for (int i = 0; i < minSize; i++) {
            for (String str: strs) {
                if (str.charAt(i) != shortest.charAt(i)) {
                    break outer;
                }
            }
            builder.append(shortest.charAt(i));
        }

        return builder.toString();

    }
}

class LeetCode20 {
    // [43ms, 5.74%]
    public static boolean isValid(String s) {
        while ((s.contains("()")) || (s.contains("{}")) || (s.contains("[]"))) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.length() == 0;
    }
}

class LeetCode21 {
    // Pointer [0ms, 100.00%]
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if ((l1 == null) && (l2 == null)) {
            return null;
        }
        else if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode current = head;

        while ((l1 != null) && (l2 != null)) {
            if (l1.val < l2.val) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;

            }
            else {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            current.next = l1;
            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            current.next = l2;
            current = current.next;
            l2 = l2.next;
        }

        return head.next;

    }
}

class LeetCode26 {
    // [1ms, 99.90%] Two Pointers O(n)
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int i = 1;
        int j = 0;
        int length = nums.length;
        while (i < length) {
            if (nums[i] != nums[i - 1]) {
                j++;
                nums[j] = nums[i];
            }
            i++;
        }
        return j + 1;
    }
}

class LeetCode27 {
    // [0ms, 100.00%] Two Pointers O(n)
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

class LeetCode28 {
    // [4ms, 34.04%] BruteForce O(n*m)
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int pos = -1;
        int sizeH = haystack.length();
        int sizeN = needle.length();

        for (int i = 0; i < sizeH; i++) {
            int count = 0;
            if ((haystack.charAt(i) == needle.charAt(0)) && ((i + sizeN - 1) < sizeH)) {
                for (int  j = i; j < i + sizeN; j++) {
                    if (haystack.charAt(j) == needle.charAt(j - i)) {
                        count++;
                    }
                }
            }
            if (count == sizeN) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}

class LeetCode53 {
    // [1ms, 99.96%] Dynamic Programming O(n)
    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num: nums) {
            if (sum > 0) {
                sum += num;
            }
            else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    // [2ms, 25.46%] Recursive O(n)
    public static int maxSubArray2(int[] nums) {
        DoubleInt result = LeetCode53.findMax(nums, nums.length - 1);
        return result.intTwo;
    }
    public static class DoubleInt {
        int intOne;
        int intTwo;

        public DoubleInt(int i, int j) {
            this.intOne = i;
            this.intTwo = j;
        }
    }
    public static DoubleInt findMax(int[] nums, int high) {
        if (high == 0) {
            return new DoubleInt(nums[high], nums[high]);
        }
        DoubleInt childResult = LeetCode53.findMax(nums, high - 1);
        if (childResult.intOne < 0) {
            if (childResult.intTwo > nums[high]) {
                return new DoubleInt(nums[high], childResult.intTwo);
            }
            else {
                return new DoubleInt(nums[high], nums[high]);
            }
        }
        else {
            int newLastMax = childResult.intOne + nums[high];
            if (childResult.intTwo > newLastMax) {
                return new DoubleInt(newLastMax, childResult.intTwo);
            }
            else {
                return new DoubleInt(newLastMax, newLastMax);
            }
        }
    }
}

class LeetCode121 {
    // [1ms, 99.99%] Dynamic Programming O(n)
    public static int maxProfit(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrices) {
                minPrices = price;
            } else if ((price - minPrices) > maxProfit) {
                maxProfit = price - minPrices;
            }
        }
        return maxProfit;
    }
}

class LeetCode225 {
    // [0ms, 100%] Re-Push O(n)
    public class MyStack {
        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack() {
            this.queue = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            this.queue.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            int size = this.queue.size();
            for (int i = 0; i < size - 1; i++) {
                this.queue.offer(this.queue.poll());
            }
            return this.queue.poll();
        }

        /** Get the top element. */
        public int top() {
            int size = this.queue.size();
            for (int i = 0; i < size - 1; i++) {
                this.queue.offer(this.queue.poll());
            }
            int temp = this.queue.poll();
            this.queue.offer(temp);
            return temp;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
    // [0ms, 100%] Recursive O(n)
    public static class MyStack2 {
        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStack2() {
            this.queue = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            ArrayList<Integer> array = new ArrayList<>();
            while (!this.queue.isEmpty()) {
                array.add(this.queue.poll());
            }
            this.queue.offer(x);
            for (int element: array) {
                this.queue.offer(element);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return this.queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return this.queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            if (this.queue.isEmpty()) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}

class LeetCode543 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rigthDepth = dfs(root.right);
        res = Math.max(res, leftDepth + rigthDepth);
        return Math.max(leftDepth, rigthDepth) + 1;
    }
}
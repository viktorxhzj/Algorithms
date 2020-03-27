import sun.reflect.generics.tree.Tree;

import javax.naming.PartialResultException;
import java.util.*;

/*
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/
class Solution1 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int rowLen = matrix.length, colLen = matrix[0].length;
        int i = rowLen - 1, j = 0;
        while ((i >= 0) && (j < colLen)) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) i--;
            else j++;
        }
        return false;
    }


    // DFS
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
}

/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
*/
class Solution2 {
    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') builder.append(s.charAt(i));
            else builder.append("%20");
        }
        return builder.toString();
    }
}

/*
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
*/
class Solution3 {
    // 利用Stack的后进先出特性
    public int[] reversePrint(ListNode head) {
        Stack<Integer> myStack = new Stack<Integer>();
        while (head != null) {
            myStack.push(head.val);
            head = head.next;
        }
        int[] array = new int[myStack.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = myStack.pop();
        }
        return array;
    }

    // 递归
    ArrayList<Integer> list = new ArrayList<Integer>();
    public int[] reversePrint2(ListNode head) {
        this.helper(head);
        int[] arr = new int[this.list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = this.list.get(i);
        }
        return arr;
    }

    public void helper(ListNode cur) {
        if (cur == null) return;
        this.helper(cur.next);
        this.list.add(cur.val);
    }
}

/*
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
*/
class Solution4 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = this.formTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
        return root;
    }
    public TreeNode formTree(int[] preorder, int[] inorder, int pl, int ph, int il, int ih) {
        TreeNode parent = new TreeNode(preorder[pl]);
        if (pl == ph) return parent;

        int parentNodePos = il;
        while (inorder[parentNodePos] != preorder[pl]) parentNodePos++;

        if (parentNodePos == il) {
            // no left child
            pl++;
            il++;
            parent.right = this.formTree(preorder, inorder, pl, ph, il, ih);
        }
        else if (parentNodePos == ih) {
            // no right child
            pl++;
            ih--;
            parent.left = this.formTree(preorder, inorder, pl, ph, il, ih);
        }
        else {
            parent.right = this.formTree(preorder, inorder, pl + parentNodePos - il + 1, ph, parentNodePos + 1, ih);
            parent.left = this.formTree(preorder, inorder, pl + 1, pl + parentNodePos - il, il, parentNodePos - 1);
        }
        return parent;
    }
}

/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
class Solution5 {

    private Stack<Integer> stack1 = new Stack<Integer>();;
    private Stack<Integer> stack2 = new Stack<Integer>();;

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty() && stack1.isEmpty()) return -1;
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}

class Solution6 {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];
    }
}

/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 */
class Solution7 {
    public int fib(int n) {
        if (n == 0) return 0;
        int[] list = new int[n + 1];
        list[0] = 0;
        list[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            list[i] = (list[i - 1] + list[i - 2]) % 1000000007;
        }
        return list[n];
    }
}

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
class Solution8 {
    public int numWays(int n) {
        if (n == 0) return 1;
        int[] list = new int[n + 1];
        list[0] = 1;
        list[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            list[i] = (list[i - 1] + list[i - 2]) % 1000000007;
        }
        return list[n];
    }
}

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
class Solution9 {
    public int JumpFloorII(int target) {
        if (target <= 0) return 0;
        return (int) Math.pow(2, target - 1);
    }
}
/*
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
class Solution10 {
    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        int[] list = new int[target];
        list[0] = 1;
        list[1] = 2;
        for (int i = 2; i < target; i++) {
            list[i] = list[i - 1] + list[i - 2];
        }
        return list[target - 1];
    }
}

/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
class Solution11 {
    public int NumberOf1(int n) {
        if (n >= 0) {
            int count = 0;
            while (n != 0) {
                if (n % 2 == 1) count++;
                n = n / 2;
            }
            return count;
        }
        int[] binary = new int[32];
        int i = 0;
        while (n != 0) {
            if (n % 2 == -1) binary[i] = 1;
            else binary[i] = 0;
            n = n / 2;
            i++;
        }
        i = 0;
        int count = 0;
        while ((i < 32) && (binary[i] == 0)) i++;
        i++;
        while (i < 32) {
            if (binary[i] == 1) binary[i] = 0;
            else binary[i] = 1;
            i++;
        }
        for (int num: binary) {
            if (num == 1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution11 test = new Solution11();
        System.out.println(test.NumberOf1(-1));

    }
}

/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
保证base和exponent不同时为0
 */
class Solution12 {
    public double Power(double base, int exponent) {
        if (base == 0.0) return 0.0;
        if (exponent == 0) return 1;
        double res = base;
        int abs = exponent > 0 ? exponent : -exponent;
        while (abs > 1) {
            res *= base;
            abs--;
        }
        return exponent > 0 ? res : 1 / res;

    }
}

/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
class Solution13 {
    public void reOrderArray(int [] array) {
        int[] helper = new int[array.length];
        int i = 0;
        for (int num: array) {
            if (num % 2 == 1) {
                helper[i] = num;
                i++;
            }
        }
        for (int num: array) {
            if (num % 2 == 0) {
                helper[i] = num;
                i++;
            }
        }
        for (int j = 0; j < array.length; j++) {
            array[j] = helper[j];
        }
    }
}

/*
输入一个链表，输出该链表中倒数第k个结点。
 */
class Solution14 {
    private int num = 0;
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return null;

        ListNode useless = FindKthToTail(head.next, k);

        if (useless != null) return useless;

        num++;

        if (num == k) return head;

        return null;
    }
}

/*
输入一个链表，反转链表后，输出新链表的表头。
 */
class Solution15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public ListNode ReverseList2(ListNode head) {

        if(head==null)
            return null;
        ListNode pre = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

class Solution16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode res = null;
        if (list1.val < list2.val) {
            res = list1;
            res.next = Merge(list1.next, list2);
        }
        else {
            res = list2;
            res.next = Merge(list1, list2.next);
        }
        return res;
    }

    public ListNode Merge2(ListNode list1,ListNode list2) {
        ListNode cur = new ListNode(-1);
        ListNode head = cur;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                cur.next = list2;
                list2 = list2.next;
            }
            else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        if (list1 != null) cur.next = list1;
        if (list2 != null) cur.next = list2;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode s1 = new ListNode(1);
        s1.next = new ListNode(3);
        s1.next.next = new ListNode(5);
        ListNode s2 = new ListNode(2);
        s2.next = new ListNode(4);
        s2.next.next = new ListNode(6);
        Solution16 solution = new Solution16();
        solution.Merge2(s1, s2);



    }
}

// 0317

/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
class Solution17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null)  return false;
        return doesTree1HasTree2(root1, root2)|| HasSubtree(root1.left, root2)
                ||HasSubtree(root1.right, root2);
    }

    private boolean doesTree1HasTree2(TreeNode root1,TreeNode root2) {
        if(root2 == null)  return true;
        if(root1 == null)  return false;
        return root1.val==root2.val && doesTree1HasTree2(root1.left, root2.left)
                && doesTree1HasTree2(root1.right, root2.right);
    }
}

/*
操作给定的二叉树，将其变换为源二叉树的镜像。
 */
class Solution18 {
    public void Mirror(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */
class Solution19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] flag = new int[row][col];
        int i = 0;
        int j = 0;
        int x1 = 0;
        int x2 = col - 1;
        int y1 = 0;
        int y2 = row - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (x2 >= x1 && y2 >= y1) {
            list.add(matrix[i][j]);
            flag[i][j] = 1;
            while (j + 1 <= x2) {
                j++;
                if (flag[i][j] != 1) {
                    list.add(matrix[i][j]);
                    flag[i][j] = 1;
                }
            }
            while (i + 1 <= y2) {
                i++;
                if (flag[i][j] != 1) {
                    list.add(matrix[i][j]);
                    flag[i][j] = 1;
                }
            }
            while (j - 1 >= y1) {
                j--;
                if (flag[i][j] != 1) {
                    list.add(matrix[i][j]);
                    flag[i][j] = 1;
                }
            }
            while (i - 1 > x1) {
                i--;
                if (flag[i][j] != 1) {
                    list.add(matrix[i][j]);
                    flag[i][j] = 1;
                }
            }
            x1++;
            x2--;
            y1++;
            y2--;
            i = x1;
            j = y1;

        }
        return list;
    }


}

/*
定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数。
 */
class Solution20 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) stack2.push(node);
        else if (node <= stack2.peek())  stack2.push(node);
    }

    public void pop() {
        int temp = stack1.pop();
        if (temp == stack2.peek()) stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}

//0318

/*
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
class Solution21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }
}

/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
        return list;
    }
}

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
class Solution23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return this.finder(sequence, 0, sequence.length - 1);
    }

    public boolean finder(int[] seq, int low, int high) {
        if (low == high) return true;
        int i = low;
        int root = seq[high];
        while (seq[i] < root) i++;
        int j = i;
        while (j < high) {
            if (seq[j] < root) return false;
            j++;
        }
        if (i == low || i == high) return this.finder(seq, low, high - 1);
        else return this.finder(seq, low, i - 1) && this.finder(seq, i, high - 1);

    }
}

//0319

/*
输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)
 */
class Solution24 {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }
}

/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，
一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
class Solution25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode temp = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = temp;
            cur = temp;
        }
        cur = pHead;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(cur != null) {
            RandomListNode next = cur.next;
            if (next == null) cur = null;
            else {
                cur.next = next.next;
                cur = next;
            }
        }
        return pCloneHead;
    }
}

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
class Solution26 {
    ArrayList<TreeNode> list = new ArrayList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        this.inOrder(pRootOfTree);
        if (list.size() == 1) return pRootOfTree;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                list.get(i).right = list.get(i + 1);
            }
            else if (i == list.size() - 1) {
                list.get(i).left = list.get(i - 1);

            }
            else {
                list.get(i).left = list.get(i - 1);
                list.get(i).right = list.get(i + 1);
            }
        }
        return list.get(0);
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            this.inOrder(node.left);
            list.add(node);
            this.inOrder(node.right);
        }
    }
}

// 0320

/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
class Solution27 {
    ArrayList<String> list = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) return this.list;
        char[] chars = str.toCharArray();
        this.helper(chars, 0);
        Collections.sort(this.list);
        return this.list;
    }

    public void helper(char[] chars, int i) {
        if (i == chars.length - 1) {
            if (!this.list.contains(String.valueOf(chars))) this.list.add(String.valueOf(chars));
        }
        else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                this.helper(chars, i + 1);
                swap(chars, i, j);
            }
        }
    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
class Solution28 {
    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int half = array.length / 2;
        for (int value : array) {
            if (!map.containsKey(value)) map.put(value, 1);
            else map.put(value, map.get(value) + 1);
            if (map.get(value) > half) return value;
        }
        return 0;
    }
}

/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
class Solution29 {
    private ArrayList<Integer> heapArray = new ArrayList<>();
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input.length == 0 || k > input.length) return new ArrayList<>();
        for (int num: input) heapArray.add(num);
        this.heapify();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) list.add(extractMin());
        return list;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length == 0 || k > input.length) return list;
        for (int i = 0; i < k; i++) {
            int temp = this.partition(input, 0, input.length - 1);
            while (temp != i) {
                if (temp > i) {
                    temp = this.partition(input, 0, temp - 1);
                }
                else {
                    temp = this.partition(input, temp + 1, input.length - 1);
                }
            }
            list.add(input[i]);
        }
        return list;

    }
    public int partition(int[] array, int low, int high) {
        int pivot = array[low]; //选第一个元素作为枢纽元
        while(low < high)
        {
            while(low < high && array[high] >= pivot) high--;
            array[low] = array[high]; //从后面开始找到第一个小于pivot的元素，放到low位置
            while(low < high && array[low] <= pivot) low++;
            array[high] = array[low]; //从前面开始找到第一个大于pivot的元素，放到high位置
        }
        array[low] = pivot; //最后枢纽元放到low的位置
        return low;
    }

    public void percolateUp(int index) {
        if (index > 0) {
            int position = index + 1;
            int parentPosition = position / 2;
            int parentIndex = parentPosition - 1;
            while ((parentIndex >= 0) && (this.heapArray.get(parentIndex) > this.heapArray.get(index))) {
                int temp = this.heapArray.get(parentIndex);
                this.heapArray.set(parentIndex, this.heapArray.get(index));
                this.heapArray.set(index, temp);
                position = parentPosition;
                parentPosition = position / 2;
                index = position - 1;
                parentIndex = parentPosition - 1;
            }
        }
    } // O(logn)

    public void percolateDown(int index) {
        int size = this.heapArray.size();
        int position = index + 1;
        int leftChild = position * 2;
        int leftIndex = leftChild - 1;
        int rightChild = leftChild + 1;
        int rightIndex = rightChild - 1;
        while (leftChild <= size) {
            if (leftChild == size) {
                if (this.heapArray.get(index) > this.heapArray.get(leftIndex)) {
                    int temp = this.heapArray.get(index);
                    this.heapArray.set(index, this.heapArray.get(leftIndex));
                    this.heapArray.set(leftIndex, temp);
                }
                break;
            }
            else {
                if ((this.heapArray.get(index) > this.heapArray.get(leftIndex)) && (this.heapArray.get(leftIndex) > this.heapArray.get(rightIndex))) {
                    int temp = this.heapArray.get(index);
                    this.heapArray.set(index, this.heapArray.get(rightIndex));
                    this.heapArray.set(rightIndex, temp);
                    position = rightChild;
                    index = position - 1;
                    leftChild = position * 2;
                    leftIndex = leftChild - 1;
                    rightChild = leftChild + 1;
                    rightIndex = rightChild - 1;
                }
                else if ((this.heapArray.get(index) > this.heapArray.get(rightIndex)) && (this.heapArray.get(rightIndex) > this.heapArray.get(leftIndex))) {
                    int temp = this.heapArray.get(index);
                    this.heapArray.set(index, this.heapArray.get(leftIndex));
                    this.heapArray.set(leftIndex, temp);
                    position = leftChild;
                    index = position - 1;
                    leftChild = position * 2;
                    leftIndex = leftChild - 1;
                    rightChild = leftChild + 1;
                    rightIndex = rightChild - 1;
                }
                else if (this.heapArray.get(index) > this.heapArray.get(leftIndex)) {
                    int temp = this.heapArray.get(index);
                    this.heapArray.set(index, this.heapArray.get(leftIndex));
                    this.heapArray.set(leftIndex, temp);
                    position = leftChild;
                    index = position - 1;
                    leftChild = position * 2;
                    leftIndex = leftChild - 1;
                    rightChild = leftChild + 1;
                    rightIndex = rightChild - 1;
                }
                else if (this.heapArray.get(index) > this.heapArray.get(rightIndex)) {
                    int temp = this.heapArray.get(index);
                    this.heapArray.set(index, this.heapArray.get(rightIndex));
                    this.heapArray.set(rightIndex, temp);
                    position = rightChild;
                    index = position - 1;
                    leftChild = position * 2;
                    leftIndex = leftChild - 1;
                    rightChild = leftChild + 1;
                    rightIndex = rightChild - 1;
                }
                else {
                    break;
                }
            }
        }
    } // O(logn)

    public void heapify() {
        int size = this.heapArray.size();
        for (int i = size - 1; i >= 0; i--) {
            this.percolateDown(i);
        }
    } // Based on percolateDown -> O(n)

    public int extractMin() {
        int size = this.heapArray.size();
        if (size == 1) {
            return this.heapArray.remove(0);
        }
        else {
            int min = this.heapArray.get(0);
            int last = this.heapArray.remove(size - 1);
            this.heapArray.set(0, last);
            this.percolateDown(0);
            return min;
        }
    }
}

// 0321

/*
在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
class Solution30 {
    int localBestSum = 0;
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) return 0;
        return this.bestSum(array, array.length - 1);
    }

    public int bestSum(int[] array, int index) {
        if (index == 0) {
            localBestSum = array[index];
            return localBestSum;
        }
        int globalBestSum = bestSum(array, index - 1);
        if (localBestSum <= 0) {
            localBestSum = array[index];
            return Math.max(globalBestSum, array[index]);
        }
        int preBestSum = localBestSum;
        localBestSum +=  array[index];
        return Math.max(preBestSum, localBestSum);
    }
}

/*
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
class Solution31 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += counter(i);
        }
        return count;
    }

    public int counter(int num) {
        int count = 0;
        while (num / 10 != 0) {
            if (num % 10 == 1) count++;
            num /= 10;
        }
        if (num == 1) count++;
        return count;
    }
}

/*
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
则打印出这三个数字能排成的最小数字为321323。
 */
class Solution32 {
    public String PrintMinNumber(int[] numbers) {
        int n;
        String s="";
        ArrayList<Integer> list= new ArrayList<Integer>();
        n=numbers.length;
        for(int i=0;i<n;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {

            public int compare(Integer str1, Integer str2){
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });
        for (int j:list) s += j;
        return s;
    }
}

/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

/*
链接：https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b?f=discussion
来源：牛客网

通俗易懂的解释：
首先从丑数的定义我们知道，一个丑数的因子只有2,3,5，那么丑数p = 2 ^ x * 3 ^ y * 5 ^ z，换句话说一个丑数一定由另一个丑数乘以2或者乘以3或者乘以5得到，那么我们从1开始乘以2,3,5，就得到2,3,5三个丑数，在从这三个丑数出发乘以2,3,5就得到4，6,10,6，9,15,10,15,25九个丑数，我们发现这种方***得到重复的丑数，而且我们题目要求第N个丑数，这样的方法得到的丑数也是无序的。那么我们可以维护三个队列：
（1）丑数数组： 1
乘以2的队列：2
乘以3的队列：3
乘以5的队列：5
选择三个队列头最小的数2加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
（2）丑数数组：1,2
乘以2的队列：4
乘以3的队列：3，6
乘以5的队列：5，10
选择三个队列头最小的数3加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
（3）丑数数组：1,2,3
乘以2的队列：4,6
乘以3的队列：6,9
乘以5的队列：5,10,15
选择三个队列头里最小的数4加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
（4）丑数数组：1,2,3,4
乘以2的队列：6，8
乘以3的队列：6,9,12
乘以5的队列：5,10,15,20
选择三个队列头里最小的数5加入丑数数组，同时将该最小的数乘以2,3,5放入三个队列；
（5）丑数数组：1,2,3,4,5
乘以2的队列：6,8,10，
乘以3的队列：6,9,12,15
乘以5的队列：10,15,20,25
选择三个队列头里最小的数6加入丑数数组，但我们发现，有两个队列头都为6，所以我们弹出两个队列头，同时将12,18,30放入三个队列；
……………………
疑问：
1.为什么分三个队列？
丑数数组里的数一定是有序的，因为我们是从丑数数组里的数乘以2,3,5选出的最小数，一定比以前未乘以2,3,5大，同时对于三个队列内部，按先后顺序乘以2,3,5分别放入，所以同一个队列内部也是有序的；
2.为什么比较三个队列头部最小的数放入丑数数组？
因为三个队列是有序的，所以取出三个头中最小的，等同于找到了三个队列所有数中最小的。
实现思路：
我们没有必要维护三个队列，只需要记录三个指针显示到达哪一步；“|”表示指针,arr表示丑数数组；
（1）1
|2
|3
|5
目前指针指向0,0,0，队列头arr[0] * 2 = 2,  arr[0] * 3 = 3,  arr[0] * 5 = 5
（2）1 2
2 |4
|3 6
|5 10
目前指针指向1,0,0，队列头arr[1] * 2 = 4,  arr[0] * 3 = 3, arr[0] * 5 = 5
（3）1 2 3
2| 4 6
3 |6 9
|5 10 15
目前指针指向1,1,0，队列头arr[1] * 2 = 4,  arr[1] * 3 = 6, arr[0] * 5 = 5
 */
class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        int p2=0, p3=0, p5=0;//初始化三个指向三个潜在成为最小丑数的位置
        int[] result = new int[index];
        result[0] = 1;
        for(int i = 1; i < index; i++){
            result[i] = Math.min(result[p2]*2, Math.min(result[p3]*3, result[p5]*5));
            if (result[i] == result[p2]*2) p2++;//为了防止重复需要三个if都能够走到
            if (result[i] == result[p3]*3) p3++;//为了防止重复需要三个if都能够走到
            if (result[i] == result[p5]*5) p5++;//为了防止重复需要三个if都能够走到
        }
        return result[index-1];
    }
}

// 0322

/*
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
class Solution34 {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = str.toCharArray();
        for (char c : array) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c) + 1);
        }
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) return i;
        }
        return -1;
    }
}

/*
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */

class Solution35 {
    int count = 0;
    int[] helper;
    public int InversePairs(int[] array) {
        if (array == null) return this.count;
        helper = new int[array.length];
        this.mergeSort(array, 0, array.length - 1);
        return this.count;
    }
    public void mergeSort(int[] array, int low, int high) {
        if (low >= high) return ;
        int mid = (low + high) / 2;
        this.mergeSort(array, low, mid);
        this.mergeSort(array, mid + 1, high);
        this.merge(array, low, mid, high);
    }
    public void merge(int[] array, int low, int mid, int high) {
        int k = 0;
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (array[i] > array[j]) {
                this.count = (this.count + mid - i + 1) % 1000000007;
                helper[k++] = array[j++];
            }
            else {
                helper[k++] = array[i++];
            }
        }
        while (i <= mid) {
            helper[k++] = array[i++];
        }
        while (j <= high) {
            helper[k++] = array[j++];
        }
        for (k = low; k <= high; k++) {
            array[k] = helper[k - low];
        }
    }

    public static void main(String[] args) {
        Solution35 test = new Solution35();
        System.out.println(test.InversePairs(new int[]{2, 3, 4, 5, 1, 6, 7, 8, 0}));
    }
}


/*
输入两个链表，找出它们的第一个公共结点。
（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode commonListNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            stack1.pop();
            commonListNode = stack2.pop();
        }
        return commonListNode;
    }
}

/*
统计一个数字在排序数组中出现的次数。
 */

class Solution37 {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0)
            return 0;
        return biSearch(array, k + 0.5) - biSearch(array, k - 0.5);
    }
    private int biSearch(int [] array, double k){
        int low = 0, high = array.length - 1;
        while(low <= high){
            int mid = low + (high -low) / 2;
            if(array[mid] > k)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

}


//0323

/*
输入一棵二叉树，求该树的深度。
从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
class Solution38 {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}

/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
class Solution39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}


/*
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 */
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
class Solution40 {
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2)    {
        int length = array.length;
        if(length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; ++i){
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; ++i){
            if(isBit1(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    private int findFirst1(int bitResult){
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32){
            bitResult >>= 1;
            index++;
        }
        return index;
    }

    private boolean isBit1(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}

/*
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */
class Solution41 {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1,phigh = 2;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }

}

// 0324

/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int mul = Integer.MAX_VALUE;
        int[] res = new int[2];
        if (array.length < 2) return list;
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] < sum) i++;
            if (array[i] + array[j] > sum) j--;
            if (array[i] + array[j] == sum) {
                if (array[i] * array[j] < mul) {
                    mul = array[i] * array[j];
                    res[0] = array[i];
                    res[1] = array[j];
                }
                i++;
            }
        }
        if (mul == Integer.MAX_VALUE) return list;
        else {
            list.add(res[0]);
            list.add(res[1]);
            return list;
        }
    }
}

/*
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
class Solution43 {
    public String LeftRotateString(String str, int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n) return "";
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int low, int high) {
        char temp;
        while (low < high) {
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low++;
            high--;
        }
    }
}

/*
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
class Solution44 {
    public String ReverseSentence(String str) {
        if (str.trim().equals("") && str.length() > 0) {
            return str;
        }
        String[] words = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) builder.append(words[i]).append(" ");
        builder.append(words[0]);
        return builder.toString();

    }
}

/*
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
class Solution45 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        int[] map = new int[14];
        int max = 0;
        int min = 14;
        boolean flag = true;
        for (int num: numbers) {
            if (map[num] == 0) map[num] = 1;
            else {
                map[num]++;
                if (num != 0) flag = false;
            }
            if (num > max) max = num;
            if (num < min & num != 0) min = num;
        }
        return (max - min < 5) && flag && numbers.length == 5;

    }

}

// 0325

/*
每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....
直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
class Solution46 {
    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i ++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }

}

/*
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
class Solution47 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean arg = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }
}

/*
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
class Solution48 {
    public int Add(int num1,int num2) {
        while( num2!=0 ) {
            int sum = num1 ^ num2;
            int carray = (num1 & num2) << 1;
            num1 = sum;
            num2 = carray;
        }
        return num1;
    }
}

/*
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
数值为0或者字符串不是一个合法的数值则返回0
 */
class Solution49 {
    public int StrToInt(String str) {
        int res = 0;
        int length = str.length();
        if (str == null || length == 0) return 0;
        int i = 0;
        char first = str.charAt(i);
        boolean negative = false;
        if (first == '-') {
            negative = true;
            i++;
        }
        else if (first == '+') i++;
        int diff;
        while (i < length) {
            diff = str.charAt(i) - '0';
            if (diff > 9 || diff < 0) return 0;
            if (!negative) {
                if (res > Integer.MAX_VALUE / 10) return 0;
                res *= 10;
                if (res > Integer.MAX_VALUE - diff) return 0;
                res += diff;
            }
            else {
                if (res < Integer.MIN_VALUE / 10) return 0;
                res *= 10;
                if (res < Integer.MIN_VALUE + diff) return 0;
                res -= diff;
            }
            i++;
        }
        return res;
    }
}

// 0327

/*
在一个长度为n的数组里的所有数字都在0到n-1的范围内。
数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
class Solution50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int[] duplication) {
        if (length == 0 || numbers == null) return false;
        int[] arr = new int[length];
        int temp;
        for (int i = 0; i < length; i++) {
            if (numbers[i] == i) arr[i] = i;
            else if (numbers[numbers[i]] != numbers[i]) {
                temp = numbers[i];
                arr[i] = numbers[temp];
                arr[temp] = temp;
            }
            else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}

/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */


class Solution51 {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] arr = new int[length];
        if (length == 0 || length == 1) return arr;

        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (i == j) dp[i][j] = A[i];
                else dp[i][j] = dp[i][j - 1] * A[j];
            }
        }

        arr[0] = dp[0][length - 1];
        arr[length - 1] = dp[0][length - 2];
        for (int i = 1; i < length - 1; i++) arr[i] = dp[0][i - 1] * dp[i + 1][length - 1];
        return arr;
    }
}

/*
请实现一个函数用来匹配包括'.'和'*'的正则表达式。
模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
class Solution52 {
    public boolean match(char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i ++) {
            if(pattern[i - 1] == '*') dp[0][i] = dp[0][i - 2];
        }
        for (int i = 1; i < dp.length; i ++) {
            for (int j = 1; j < dp[0].length; j ++) {
                if(pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1]) dp[i][j] = dp[i - 1][j - 1];
                else if(pattern[j - 1] == '*') {
                    if(pattern[j - 2] != str[i - 1] && pattern[j - 2] != '.') dp[i][j] = dp[i][j - 2];
                    else dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                }
            }
        }
        return dp[str.length][pattern.length];
    }
}

/*
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
class Solution53 {
    public boolean isNumeric(char[] str) {
        char[] arr = "+-n.ne+-n".toCharArray();
        int[][] fsm = new int[][]{
                //+  -  n  .  n  e  +  -  n
                {1, 1, 1, 1, 0, 0, 0, 0, 0},    // # start
                {0, 0, 1, 1, 0, 0, 0, 0, 0},    // +
                {0, 0, 1, 1, 0, 0, 0, 0, 0},    // -
                {0, 0, 1, 1, 0, 1, 0, 0, 0},    // n
                {0, 0, 0, 0, 1, 0, 0, 0, 0},    // .
                {0, 0, 0, 0, 1, 1, 0, 0, 0},    // n
                {0, 0, 0, 0, 0, 0, 1, 1, 1},    // e
                {0, 0, 0, 0, 0, 0, 0, 0, 1},    // +
                {0, 0, 0, 0, 0, 0, 0, 0, 1},    // -
                {0, 0, 0, 0, 0, 0, 0, 0, 1}     // n
        };
        int cur = 0;
        for (int i = 0; i < str.length; i++) {
            int j;
            for (j = 0; j < 9; j++) {
                if (fsm[cur][j] == 1) {
                    if (('0' <= str[i] && str[i] <= '9' && arr[j] == 'n')
                            || ((str[i] == 'E' || str[i] == 'e') && arr[j] == 'e')
                            || (str[i] == arr[j])) {
                        cur = j + 1;
                        break;
                    }
                }
            }
            if (j == 9) return false; // 一个都没法转移，就false
        }
        return cur == 3 || cur == 4 || cur == 5 || cur == 9;
    }

    public static void main(String[] args) {
        Solution53 test = new Solution53();
        boolean res = test.isNumeric(new char[]{'+', '1', 'e', '6', '7'});
    }
}
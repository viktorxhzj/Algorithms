import sun.reflect.generics.tree.Tree;

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
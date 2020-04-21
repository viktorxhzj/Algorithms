import datastructure.TreeNode;

import java.util.*;

/**
 * 剑指26
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * 思路：遍历二叉树，判断每一个节点为根节点的情况
 */
class JZ26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean helper(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}

/**
 * 剑指27
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 思路：左右对换
 */
class JZ27 {
    public TreeNode mirrorTree(TreeNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        helper(node.left);
        helper(node.right);
    }
}

/**
 * 剑指28
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 思路：左左=右右，左右=右左
 */
class JZ28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }
    boolean helper(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return helper(L.left, R.right) && helper(L.right, R.left);
    }
}

/**
 * 剑指32-I
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 思路：BFS
 */
class JZ32I {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}

/**
 * 剑指32-II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 思路：BFS
 */
class JZ32II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> localList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                localList.add(temp.val);
                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);
            }
            list.add(localList);
        }
        return list;
    }
}

/**
 * 剑指32-III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印。
 * 思路：BFS
 */
class JZ32III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        boolean odd = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> localList = new ArrayList<>();
            int size = queue.size();
            if (odd) {
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    localList.add(temp.val);
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                }
            }
            else {
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    stack.push(temp.val);
                    if (temp.left != null) queue.offer(temp.left);
                    if (temp.right != null) queue.offer(temp.right);
                }
                while (!stack.isEmpty()) localList.add(stack.pop());
            }
            list.add(localList);
            odd = !odd;
        }
        return list;
    }
}

/**
 * 剑指34
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 思路：DFS
 */
class JZ34 {
    List<List<Integer>> list = new LinkedList<>();
    LinkedList<Integer> stack = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return list;
    }

    public void dfs(TreeNode node, int res) {
        if (node == null) return ;
        stack.addLast(node.val);
        res -= node.val;
        if (res == 0 && node.left == null && node.right == null) list.add(new LinkedList(stack));
        dfs(node.left, res);
        dfs(node.right, res);
        stack.removeLast();
    }
}

/**
 * 剑指37
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 思路：DFS序列化，DFS反序列化
 */
class JZ37 {

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        char[] str = data.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for (char c: str) queue.offer(c);
        return reDfs(queue);
    }

    public void dfs(TreeNode node, StringBuilder builder) {
        if (node == null) builder.append("#");
        else {
            builder.append(node.val);
            builder.append(',');
            dfs(node.left, builder);
            dfs(node.right, builder);
        }
    }

    public TreeNode reDfs(Queue<Character> queue) {
        if (queue.peek() == '#') {
            queue.poll();
            return null;
        }
        TreeNode node = new TreeNode(0);
        boolean neg = false;
        if (queue.peek() == '-') {
            neg = true;
            queue.poll();
        }
        while (queue.peek() != ',') {
            node.val *= 10;
            node.val += queue.poll() - '0';
        }
        if (neg) node.val = -node.val;
        queue.poll();
        node.left = reDfs(queue);
        node.right = reDfs(queue);
        return node;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);
        one.right = new TreeNode(3);
        one.right.left = new TreeNode(4);
        one.right.right = new TreeNode(5);
        JZ37 test = new JZ37();
        System.out.println(test.serialize(one));
    }
}

/**
 * 剑指55-I
 * 输入一棵二叉树的根节点，求该树的深度。
 *
 * 思路：DFS
 */
class JZ55I {
    public int res = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            if (depth > res) res = depth;
            return ;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}

/**
 * LeetCode 257
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
class LC257 {
    ArrayList<String> list = new ArrayList<>();
    LinkedList<String> stack = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return list;
    }

    public void dfs(TreeNode node) {
        if (node == null) return ;
        int size = 0;
        stack.addLast(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            for (String str: stack) builder.append(str);
            list.add(builder.toString());
        }
        else {
            stack.addLast("->");
            dfs(node.left);
            dfs(node.right);
            stack.removeLast();
        }
        stack.removeLast();
    }
}

/**
 * 剑指55-II
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 *
 * 思路：DFS
 */
class JZ55II {
    public boolean res = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null) return -1;
        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        if (Math.abs(left - right) > 1) res = false;
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        JZ55II test = new JZ55II();
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(2);
        head.right.right = new TreeNode(3);
        System.out.println(test.isBalanced(head));
    }
}

/**
 * 剑指68-II
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 思路：DFS/递归
 */
class JZ68II {
    Stack<TreeNode> list1 = new Stack<>();
    Stack<TreeNode> list2 = new Stack<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs1(root, p);
        dfs2(root, q);
        TreeNode res = list1.pop();
        list2.pop();
        while (!list1.isEmpty() && !list2.isEmpty()) {
            TreeNode temp = list1.pop();
            if (temp.val != list2.pop().val) return res;
            res = temp;
        }


        return res;
    }
    public boolean dfs1(TreeNode node, TreeNode k) {
        if (node == null) return false;
        if (node.val == k.val) {
            list1.push(node);
            return true;
        }
        if (dfs1(node.left, k) || dfs1(node.right, k)) {
            list1.push(node);
            return true;
        }
        return false;
    }
    public boolean dfs2(TreeNode node, TreeNode k) {
        if (node == null) return false;
        if (node.val == k.val) {
            list2.push(node);
            return true;
        }
        if (dfs2(node.left, k) || dfs2(node.right, k)) {
            list2.push(node);
            return true;
        }
        return false;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}

/**
 * LeetCode 563
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 * 思路：post-Order
 */
class LC563 {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        posOrder(root);
        return tilt;
    }

    private int posOrder(TreeNode node) {
        if (node == null) return 0;
        int left = posOrder(node.left);
        int right = posOrder(node.right);
        tilt += Math.abs(left - right);
        return left + right + node.val;
    }
}

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) return node;
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return node;
    }
}

class LC617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode left = mergeTrees(t1.left, t2.left);
        TreeNode right = mergeTrees(t1.right, t2.right);
        t1.left = left;
        t1.right = right;
        t1.val += t2.val;
        return t1;
    }
}

class LC226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
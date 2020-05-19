# 小盒子 LeetCode 215/1615

- [小盒子 LeetCode 215/1615](#%e5%b0%8f%e7%9b%92%e5%ad%90-leetcode-2151615)
  - [Algorithms](#algorithms)
    - [1 Binary Search](#1-binary-search)
      - [1.1 Reduce Interval](#11-reduce-interval)
      - [1.2 Find Left Boundary](#12-find-left-boundary)
      - [1.3 Find Right Boundary](#13-find-right-boundary)
      - [1.4 Rotated Sorted Array](#14-rotated-sorted-array)
    - [2 Dynamic Programming](#2-dynamic-programming)
      - [2.1 1D-DP](#21-1d-dp)
      - [2.2 2D-DP](#22-2d-dp)
      - [2.3 KMP](#23-kmp)
      - [2.4 Knapsack Problem](#24-knapsack-problem)
      - [2.5 Catalan Number](#25-catalan-number)
    - [3 Divide & Conquer](#3-divide--conquer)
    - [4 Bit Operation](#4-bit-operation)
      - [4.1 Bit-XOR/OR/AND](#41-bit-xororand)
      - [4.3 Binary-ADD/MUL/DIV](#43-binary-addmuldiv)
      - [4.4 Decimal-ADD/MUL/DIV](#44-decimal-addmuldiv)
    - [5 DFS/BFS](#5-dfsbfs)
      - [5.1 DFS](#51-dfs)
      - [5.2 BackTracking](#52-backtracking)
        - [5.2.1 Combination](#521-combination)
        - [5.2.2 Permutation](#522-permutation)
      - [5.3 BFS](#53-bfs)
        - [5.3.1 Dijkstra](#531-dijkstra)
  - [Data Structures](#data-structures)
    - [1 Binary Tree](#1-binary-tree)
      - [1.1 Iterative Method](#11-iterative-method)
      - [1.2 Recursive Method](#12-recursive-method)
      - [1.3 BFS](#13-bfs)
      - [1.4 DFS](#14-dfs)
    - [2 Array](#2-array)
    - [3 Hash Table](#3-hash-table)
    - [4 Linked List](#4-linked-list)
      - [4.1 Recursive Method](#41-recursive-method)
      - [4.2 Double Pointers](#42-double-pointers)
    - [5 Disjointed Set Union](#5-disjointed-set-union)
    - [6 Stack](#6-stack)
    - [7 Dictionary Tree](#7-dictionary-tree)
    - [8 Matrix](#8-matrix)
  - [Solutions that I failed to understand](#solutions-that-i-failed-to-understand)

## Algorithms

### 1 Binary Search

#### 1.1 Reduce Interval

- [**LeetCode 35 - 搜索插入位置**](src/leetcode/LC35.java)

    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    你可以假设数组中无重复元素。
 
- [LeetCode 69 - x的平方根](src/leetcode/LC69.java)

    实现 int sqrt(int x) 函数。

- [LeetCode 367 - 有效的完全平方数](src/leetcode/LC367.java)

    给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

- [LeetCode 658 - x的平方根](src/leetcode/LC658.java)

    给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。
    返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。

- [LeetCode 704 - 二分查找](src/leetcode/LC704.java)

    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

- [LeetCode 852 - 山脉数组的峰顶索引](src/leetcode/LC852.java)

    给定一个确定为山脉的数组，返回唯一一个满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。

#### 1.2 Find Left Boundary

- [**LeetCode 34 - 在排序数组中查找元素的第一个和最后一个位置**](src/leetcode/LC34.java)

    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

- [LeetCode 278 - 第一个错误的版本](src/leetcode/LC278.java)

#### 1.3 Find Right Boundary

- [LeetCode 744 - 寻找比目标字母大的最小字母](src/leetcode/LC744.java)

#### 1.4 Rotated Sorted Array

- [LeetCode 33 - 搜索旋转排序数组](src/leetcode/LC33.java)

    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。

- [**LeetCode 81 - 搜索旋转排序数组II**](src/leetcode/LC81.java)

    假设按照升序排序的数组在预先未知的某个点上进行了旋转。本题中含有重复元素。
    
- [LeetCode 153 - 寻转旋转排序数组中的最小值](src/leetcode/LC153.java)

    假设按照升序排序的数组在预先未知的某个点上进行了旋转。请找出数组中的最小元素。

- [**LeetCode 154 - 寻转旋转排序数组中的最小值II**](src/leetcode/LC154.java)

    假设按照升序排序的数组在预先未知的某个点上进行了旋转。请找出数组中的最小元素。本题中含有重复元素。

### 2 Dynamic Programming

#### 2.1 1D-DP

- [LeetCode 118  - 杨辉三角](src/leetcode/LC118.java)

    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。

- [**LeetCode 32  - 最长有效括号**](src/leetcode/LC32.java)

    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

#### 2.2 2D-DP

- [**LeetCode 221  - 最大正方形**](src/leetcode/LC221.java)

    在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
    
#### 2.3 KMP

- [**LeetCode 28  - 实现 strStr()**](src/leetcode/LC28.java)

    给定一个 haystack 字符串和一个 needle 字符串，
    在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
    如果不存在，则返回  -1。
    
- [LeetCode 572  - 另一个树的子树](src/leetcode/LC572.java)

    给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
    s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

#### 2.4 Knapsack Problem

- [**LeetCode 377  - 组合总和IV**](src/leetcode/LC377.java)

    给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。
    
    思路：经典0-1背包问题，但顺序不同的序列被认为不同的组合。
    
- [**LeetCode 518  - 零钱兑换II**](src/leetcode/LC518.java)

    给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
    
    思路：经典0-1背包问题。重点：把二维数组优化成一维数组。

- [**LeetCode 面试题08.11 - 硬币**](src/leetcode/LCInterview0811.java)

    给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。

    思路：DP[{c1, c2,... ck}][n] = DP[{c1, c2,... ck}][n - ck.value] + DP[{c1, c2,... ck-1}][n];

- [LeetCode 983  - 最低票价](src/leetcode/LC983.java)

    在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。
    在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。

#### 2.5 Catalan Number

- [**LeetCode 96 - 不同的二叉搜索树**](src/leetcode/LC96.java)

    给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

    思路：G[n] = G[0] * G[n - 1] + G[1] * G[n - 2] + ... + G[n - 1] * G[0]

### 3 Divide & Conquer

- [**LeetCode 23 - 合并K个排序链表**](src/leetcode/LC23.java)

    合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

    思路：类似归并排序

### 4 Bit Operation

#### 4.1 Bit-XOR/OR/AND

- [LeetCode 136 - 只出现一次的数字](src/leetcode/LC136.java)

    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

    思路：两个相等的数异或为0。异或所有数字即可得到唯一只出现一次的数字。

- [**LeetCode 137 - 只出现一次的数字II**](src/leetcode/LC137.java)

    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
    
    思路：3个元素的每位的和必定是3的倍数。

- [LeetCode 231 - 2的幂](src/leetcode/LC231.java)

    给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
    
    思路：2的幂次方数最高位二进制最高位为1，其余皆为0。2的幂次方数-1的最高位为0，其余皆为1。

- [**LeetCode 260 - 只出现一次的数字III**](src/leetcode/LC260.java)

    给定一个整数数组，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
    
    思路：异或所以数字即可得到两个元素只出现一次的元素的异或结果。
    找到异或结果的为1的位，即两个数在这个位上不同。
    遍历每个数字，将这个位上为1的分成一组，为0的分成另外一组，则两个只出现一次的元素必定在两个组里。
    对两个组异或的结果就是要找的元素。

#### 4.3 Binary-ADD/MUL/DIV

- [**LeetCode 50 - Pow(x, n)**](src/leetcode/LC50.java)

    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
    
    思路：快速幂，即幂可以由二进制的形式表示。

#### 4.4 Decimal-ADD/MUL/DIV

- [LeetCode 2 - 两数相加](src/leetcode/LC2.java)

    给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
    
    思路：十进制位运算。

- [LeetCode 7 - 整数反转](src/leetcode/LC7.java)

    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    
    思路：十进制位运算。每次循环要判断累加值乘10以后是否过界，以及乘10以后加余数是否过界。

- [LeetCode 8 - 字符串转换整数](src/leetcode/LC8.java)

    你来实现一个 atoi 函数，使其能将字符串转换成整数。
    
    思路：十进制位运算。要判断正负号，以及每次循环要判断累加值乘10以后是否过界，以及乘10以后加余数是否过界。

- [LeetCode 9 - 回文数](src/leetcode/LC9.java)

    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    
    思路：十进制位运算，只需要判断数的一半是否相等。

- [**LeetCode 43 - 字符串相乘**](src/leetcode/LC43.java)

    给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
    
    思路：十进制乘法位运算，m位数整数*n位数整数的最大位数为m+n

- [**LeetCode 29 - 两数相除**](src/leetcode/LC29.java)

    给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

### 5 DFS/BFS

#### 5.1 DFS

- [LeetCode 79 - 单词搜索](src/leetcode/LC79.java)

    给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    
    思路：DFS+回溯，回溯时状态重置。

- [LeetCode 130 - 被围绕的区域](src/leetcode/LC130.java)

    给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

- [LeetCode 200 - 岛屿数量](src/leetcode/LC200.java)

    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    
    思路：纯DFS，也可以用纯BFS
    
- [LeetCode 695 - 岛屿的最大面积](src/leetcode/LC695.java)

    找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0。）
    
    思路：纯DFS
    
- [LeetCode 207 - 课程表](src/leetcode/LC207.java)

    你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
    在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
    给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
    
    思路：判断有向图是否有环。DFS如果有back edge即为有环

- [LeetCode 210 - 课程表II](src/leetcode/LC210.java)

    给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

#### 5.2 BackTracking

- [LeetCode 22 - 括号生成](src/leetcode/LC22.java)

    数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。

##### 5.2.1 Combination

- [LeetCode 77 - 组合](src/leetcode/LC77.java)

    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

- [LeetCode 39 - 组合总和](src/leetcode/LC39.java)

    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的数字可以无限制重复被选取。
    
- [LeetCode 40 - 组合总和II](src/leetcode/LC40.java)

    给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的每个数字在每个组合中只能使用一次。

- [LeetCode 216 - 组合总和III](src/leetcode/LC216.java)

    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

- [LeetCode 78 - 子集](src/leetcode/LC78.java)

    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    
    思路：子集就是每个元素选择或者不选择的全排列，使用回溯算法。同层的使用交换来实现状态回溯。

- [**LeetCode 90 - 子集II**](src/leetcode/LC90.java)

    给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    
    思路：对于任意一个整数，第一次遍历到这个整数时可以选择添加或者不添加。
    当不是第一次遍历到这个整数时，如果子集里没有这个整数，还是可以选择添加或者不添加。
    但是如果子集里已经有这个整数了，那就必须添加这个整数，不然会造成重复。

##### 5.2.2 Permutation

- [LeetCode 17 - 电话号码的数字组合](src/leetcode/LC17.java)

    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    
    思路：全排列使用回溯算法。同层的使用交换来实现状态回溯。

- [LeetCode 46 - 全排列](src/leetcode/LC46.java)

    给定一个没有重复数字的序列，返回所有不重复的全排列。

    思路：全排列使用回溯算法。同层的使用交换来实现状态回溯。

- [**LeetCode 47 - 全排列II**](src/leetcode/LC47.java)

    给定一个可包含重复数字的序列，返回其所有可能的全排列。

    思路：全排列使用回溯算法。同层的使用交换来实现状态回溯。判断是否和同层的节点值相同从而剪枝

- [LeetCode 面试题08.08 - 有重复字符串的排列组合](src/leetcode/LCInterview0808.java)

    有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
    
    思路：回溯+剪枝

#### 5.3 BFS

- [LeetCode 542 - 01矩阵](src/leetcode/LC200.java)

    给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
    
    思路：多源BFS

##### 5.3.1 Dijkstra

- [LeetCode 743 - 网络延迟时间](src/leetcode/LC743.java)

    给定一个列表 times，表示信号经过有向边的传递时间。 
    times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
    现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
    
    思路：Dijkstra

### 6 Greedy Algorithm

- [LeetCode 55 - 跳跃游戏](src/leetcode/LC55.java)

    给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个位置。

## Data Structures

### 1 Binary Tree

#### 1.1 Iterative Method

- [**LeetCode 114 - 二叉树展开为链表**](src/leetcode/LC114.java)

    给定一个二叉树，原地将它展开为链表。
    
    思路：使用迭代版前序遍历，用一个临时节点保存上一个弹出的节点。

- [**LeetCode 144 - 二叉树的前序遍历**](src/leetcode/LC144.java)

    给定一个二叉树，返回它的前序遍历。

    思路：用栈模拟系统。后进先出，所以先右后左。

- [**LeetCode 94 - 二叉树的中序遍历**](src/leetcode/LC94.java)

    给定一个二叉树，返回它的中序遍历。
    
    思路：用栈模拟系统。尽可能的压左边的节点进栈，没左边节点可压时，就可以打印栈顶节点并向右节点进发了。
    
- [**LeetCode 145 - 二叉树的后序遍历**](src/leetcode/LC145.java)

    给定一个二叉树，返回它的后序遍历。
    
    思路：用栈模拟系统。尽量压左节点，无左节点时如果也无右节点弹出。如果有右节点但右节点已经遍历过也可弹出。如果右节点没有遍历过向右节点迭代。

#### 1.2 Recursive Method

- [**LeetCode 95 - 不同的二叉搜索树II**](src/leetcode/LC95.java)

    给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

    思路：G[n] = G[0] * G[n - 1] + G[1] * G[n - 2] + ... + G[n - 1] * G[0]

- [**LeetCode 98 - 验证二叉搜索树**](src/leetcode/LC98.java)

    给定一个二叉树，判断其是否是一个有效的二叉搜索树。

- [LeetCode 100 - 相同的树](src/leetcode/LC100.java)

    给定两个二叉树，编写一个函数来检验它们是否相同。

- [LeetCode 101 - 对称二叉树](src/leetcode/LC101.java)

    给定一个二叉树，检查它是否是镜像对称的。

- [LeetCode 104 - 二叉树的最大深度](src/leetcode/LC104.java)

    给定一个二叉树，找出其最大深度。

- [LeetCode 108 - 将有序数组转换为二叉搜索树](src/leetcode/LC108.java)

    将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

- [LeetCode 110 - 平衡二叉树](src/leetcode/LC110.java)

    给定一个二叉树，判断它是否是高度平衡的二叉树。

- [LeetCode 111 - 二叉树的最小深度](src/leetcode/LC111.java)

    给定一个二叉树，找出其最小深度。

- [LeetCode 226 - 翻转二叉树](src/leetcode/LC226.java)

    翻转一棵二叉树。

- [LeetCode 235 - 二叉搜索树的最近公共祖先](src/leetcode/LC235.java)

    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

- [**LeetCode 236 - 二叉树的最近公共祖先**](src/leetcode/LC236.java)

    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

- [LeetCode 617 - 合并二叉树](src/leetcode/LC617.java)

    给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

- [**LeetCode 938 - 二叉搜索树的范围和**](src/leetcode/LC938.java)

    给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。

- [**LeetCode 1379 - 找出克隆二叉树中的相同节点**](src/leetcode/LC1379.java)

    给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。

#### 1.3 BFS

- [LeetCode 102 - 二叉树的层次遍历](src/leetcode/LC102.java)

    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

- [LeetCode 103 - 二叉树的锯齿形遍历](src/leetcode/LC103.java)

    给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

    思路：对于从右往左的遍历，可以使用递归完成。

- [LeetCode 107 - 二叉树的层次遍历II](src/leetcode/LC107.java)

    给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

- [LeetCode 199 - 二叉树的右视图](src/leetcode/LC199.java)

    给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

#### 1.4 DFS

- [LeetCode 105 - 前序遍历和中序遍历序列构造二叉树](src/leetcode/LC105.java)

    根据一棵树的前序遍历与中序遍历构造二叉树。

- [LeetCode 106 - 中序和后序遍历序列构造二叉树](src/leetcode/LC106.java)

    根据一棵树的中序遍历与后序遍历构造二叉树。

- [LeetCode 112 - 路径总和](src/leetcode/LC112.java)

    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

- [LeetCode 113 - 路径总和II](src/leetcode/LC113.java)

    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

### 2 Array

- [LeetCode 6 - Z字形变换](src/leetcode/LC6.java)

    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
    
- [LeetCode 38 - 外观数列](src/leetcode/LC38.java)

    「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

- [LeetCode 169 - 多数元素](src/leetcode/LC169.java)

    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

    思路：摩尔投票法

- [LeetCode 31 - 下一个排列](src/leetcode/LC31.java)

    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

    思路：数学分析

- [LeetCode 56 - 合并区间](src/leetcode/LC56.java)

    给出一个区间的集合，请合并所有重叠的区间。
    
    思路：排序 + 双指针

### 3 Hash Table

- [LeetCode 12 - 整数转罗马数字](src/leetcode/LC12.java)

    思路：使用数组代替哈希表

- [LeetCode 36 - 有效的数独](src/leetcode/LC36.java)

    判断一个 9x9 的数独是否有效。
    
    思路：使用数组取代哈希表

- [LeetCode 49 - 字母异位词分组](src/leetcode/LC49.java)

    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

    思路：序列化字母出现次数并哈希

- [LeetCode 187 - 重复的DNA序列](src/leetcode/LC187.java)

    编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。

    思路：滑动窗口+HashSet
    
- [LeetCode 560 - 和为K的子数组](src/leetcode/LC560.java)

    给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

    思路：前缀和，DP+哈希表

### 4 Linked List

#### 4.1 Recursive Method

- [LeetCode 24 - 两两交换链表中的节点](src/leetcode/LC24.java)

    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

    思路：递归的交换两个节点以后的节点，返回当前两个节点的后一个节点。

- [**LeetCode 445 - 两数相加II**](src/leetcode/LC445.java)

    给你两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
    它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。你不能对列表中的节点进行翻转。
    
    思路：计算链表长度差，使尾部对齐，递归的生成新节点（为两个链表的节点和）。

#### 4.2 Double Pointers

- [LeetCode 328 - 奇偶链表](src/leetcode/LC328.java)

    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
    请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

- [LeetCode 19 - 删除链表的倒数第N个节点](src/leetcode/LC19.java)

    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    
    思路：双指针隔开n的距离。

### 5 Disjointed Set Union

- [LeetCode 547 - 朋友圈](src/leetcode/LC547.java)

    班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。
    如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 的朋友。所谓的朋友圈，是指所有朋友的集合。
    给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。
    如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。
    你必须输出所有学生中的已知的朋友圈总数。
    
    思路：并查集

- [LeetCode 684 - 冗余连接](src/leetcode/LC684.java)

    在本问题中, 树指的是一个连通且无环的无向图。
    输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。
    附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
    结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
    返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。
    答案边 [u, v] 应满足相同的格式 u < v。
    
    思路：并查集

- [**LeetCode 721 - 账户合并**](src/leetcode/LC721.java)

    思路：哈希表映射+并查集

### 6 Stack

- [LeetCode 20 - 有效的括号](src/leetcode/LC20.java)

    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

- [LeetCode 155 - 最小栈](src/leetcode/LC155.java)

    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

- [LeetCode 394 - 字符串解码](src/leetcode/LC394.java)

    给定一个经过编码的字符串，返回它解码后的字符串。
    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

### 7 Dictionary Tree

- [LeetCode 208 - 实现Trie](src/leetcode/LC208.java)

    实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

### 8 Matrix

- [LeetCode 48 - 旋转图像](src/leetcode/LC48.java)

    给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。

- [LeetCode 54 - 螺旋矩阵](src/leetcode/LC54.java)

    给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 
- [LeetCode 59 - 螺旋矩阵II](src/leetcode/LC59.java)

    给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

- [LeetCode 73 - 矩阵置零](src/leetcode/LC73.java)

    给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

## Solutions that I failed to understand

29, 560, 95
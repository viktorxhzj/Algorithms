#小盒子 LeetCode 160/1615

- [Algorithms](#algorithms)
  - [1 Binary Search](#1-binary-search)
  - [2 Dynamic Programming](#2-dynamic-programming)
    - [2.1 Knapsack Problem](#21-knapsack-problem)
    - [2.2 Catalan Number](#22-catalan-number)
  - [3 Divide & Conquer](#3-divide--conquer)
  - [4 Bit Operation](#4-bit-operation)
    - [4.1 XOR](#41-xor)
    - [4.2 OR](#42-or)
  - [5 DFS/BackTracking](#5-dfsbacktracking)
  - [6 BFS](#6-bfs)
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

## Algorithms

### 1 Binary Search

- [**LeetCode 33 - 搜索旋转排序数组**](src/LC33.java)

    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。

- [**LeetCode 35 - 搜索插入位置**](src/LC35.java)

    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    你可以假设数组中无重复元素。

- [LeetCode 367 - 有效的完全平方数](src/LC367.java)

    给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

- [LeetCode 704 - 二分查找](src/LC704.java)

    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

- [LeetCode 852 - 山脉数组的峰顶索引](src/LC852.java)

    给定一个确定为山脉的数组，返回唯一一个满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。

### 2 Dynamic Programming

#### 2.1 Knapsack Problem

- [**LeetCode 面试题08.11 - 硬币**](src/LCInterview0811.java)

    给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。

    思路：DP[{c1, c2,... ck}][n] = DP[{c1, c2,... ck}][n - ck.value] + DP[{c1, c2,... ck-1}][n];

#### 2.2 Catalan Number

- [**LeetCode 96 - 不同的二叉搜索树**](src/LC96.java)

    给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

    思路：G[n] = G[0] * G[n - 1] + G[1] * G[n - 2] + ... + G[n - 1] * G[0]

### 3 Divide & Conquer

- [**LeetCode 23 - 合并K个排序链表**](src/LC23.java)

    合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

    思路：类似归并排序

### 4 Bit Operation

#### 4.1 XOR

- [LeetCode 136 - 只出现一次的数字](src/LC136.java)

    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

    思路：两个相等的数异或为0。异或所有数字即可得到唯一只出现一次的数字。

#### 4.2 OR

- [LeetCode 137 - 只出现一次的数字II](src/LC137.java)

    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
    
    思路：3个元素的每位的和必定是3的倍数。

#### 4.3 Decimal-ADD

- [LeetCode 2 - 两数相加](src/LC2.java)

    给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
    
    思路：十进制位运算。

### 5 DFS/BackTracking

- [LeetCode 17 - 电话号码的数字组合](src/LC17.java)

    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    
    思路：全排列使用回溯算法。同层的使用交换来实现状态回溯。

- [LeetCode 46 - 全排列](src/LC46.java)

    给定一个可包含重复数字的序列，返回所有不重复的全排列。

    思路：全排列使用回溯算法。同层的使用交换来实现状态回溯。判断是否和同层的节点值相同从而剪枝

- [LeetCode 47 - 全排列II](src/LC47.java)

    给定一个 没有重复数字的序列，返回其所有可能的全排列。

    思路：全排列使用回溯算法。同层的使用交换来实现状态回溯。

- [LeetCode 78 - 子集](src/LC78.java)

    给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    
    思路：子集就是每个元素选择或者不选择的全排列，使用回溯算法。同层的使用交换来实现状态回溯。

- [LeetCode 79 - 单词搜索](src/LC79.java)

    给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    
    思路：DFS+回溯，回溯时状态重置。

- [LeetCode 90 - 子集II](src/LC90.java)

    给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
    
    思路：对于任意一个整数，第一次遍历到这个整数时可以选择添加或者不添加。
    当不是第一次遍历到这个整数时，如果子集里没有这个整数，还是可以选择添加或者不添加。
    但是如果子集里已经有这个整数了，那就必须添加这个整数，不然会造成重复。

- [LeetCode 200 - 岛屿数量](src/LC200.java)

    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    
    思路：纯DFS，也可以用纯BFS

### 6 BFS

- [LeetCode 542 - 01矩阵](src/LC200.java)

    给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
    
    思路：多源BFS

## Data Structures

### 1 Binary Tree

#### 1.1 Iterative Method

- [**LeetCode 94 - 二叉树的中序遍历**](src/LC94.java)

    给定一个二叉树，返回它的中序遍历。
    
    思路：用栈模拟系统。尽可能的压左边的节点进栈，没左边节点可压时，就可以打印栈顶节点并向右节点进发了。

- [**LeetCode 114 - 二叉树展开为链表**](src/LC114.java)

    给定一个二叉树，原地将它展开为链表。
    
    思路：使用迭代版前序遍历，用一个临时节点保存上一个弹出的节点。

- [**LeetCode 144 - 二叉树的前序遍历**](src/LC144.java)

    给定一个二叉树，返回它的前序遍历。

    思路：用栈模拟系统。后进先出，所以先右后左。
    
- [**LeetCode 145 - 二叉树的后序遍历**](src/LC145.java)

    给定一个二叉树，返回它的后序遍历。
    
    思路：用栈模拟系统。尽量压左节点，无左节点时如果也无右节点弹出。如果有右节点但右节点已经遍历过也可弹出。如果右节点没有遍历过向右节点迭代。

#### 1.2 Recursive Method

- [**LeetCode 95 - 不同的二叉搜索树II**](src/LC95.java)

    给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

    思路：G[n] = G[0] * G[n - 1] + G[1] * G[n - 2] + ... + G[n - 1] * G[0]

- [**LeetCode 98 - 验证二叉搜索树**](src/LC98.java)

    给定一个二叉树，判断其是否是一个有效的二叉搜索树。

- [LeetCode 100 - 相同的树](src/LC100.java)

    给定两个二叉树，编写一个函数来检验它们是否相同。

- [LeetCode 101 - 对称二叉树](src/LC101.java)

    给定一个二叉树，检查它是否是镜像对称的。

- [LeetCode 104 - 二叉树的最大深度](src/LC104.java)

    给定一个二叉树，找出其最大深度。

- [LeetCode 108 - 将有序数组转换为二叉搜索树](src/LC108.java)

    将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

- [LeetCode 110 - 平衡二叉树](src/LC110.java)

    给定一个二叉树，判断它是否是高度平衡的二叉树。

- [LeetCode 111 - 二叉树的最小深度](src/LC111.java)

    给定一个二叉树，找出其最小深度。

- [LeetCode 226 - 翻转二叉树](src/LC226.java)

    翻转一棵二叉树。

- [LeetCode 235 - 二叉搜索树的最近公共祖先](src/LC235.java)

    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

- [**LeetCode 236 - 二叉树的最近公共祖先**](src/LC236.java)

    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

- [LeetCode 617 - 合并二叉树](src/LC617.java)

    给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

- [**LeetCode 938 - 二叉搜索树的范围和**](src/LC938.java)

    给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。

- [**LeetCode 1379 - 找出克隆二叉树中的相同节点**](src/LC1379.java)

    给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original 中的目标节点 target。

#### 1.3 BFS

- [LeetCode 102 - 二叉树的层次遍历](src/LC102.java)

    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

- [LeetCode 103 - 二叉树的锯齿形遍历](src/LC103.java)

    给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

    思路：对于从右往左的遍历，可以使用递归完成。

- [LeetCode 107 - 二叉树的层次遍历II](src/LC107.java)

    给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

- [LeetCode 199 - 二叉树的右视图](src/LC199.java)

    给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

#### 1.4 DFS

- [LeetCode 105 - 前序遍历和中序遍历序列构造二叉树](src/LC105.java)

    根据一棵树的前序遍历与中序遍历构造二叉树。

- [LeetCode 106 - 中序和后序遍历序列构造二叉树](src/LC106.java)

    根据一棵树的中序遍历与后序遍历构造二叉树。

- [LeetCode 112 - 路径总和](src/LC112.java)

    给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

- [LeetCode 113 - 路径总和II](src/LC113.java)

    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

### 2 Array

- [LeetCode 6 - Z字形变换](src/LC6.java)

    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

- [LeetCode 169 - 多数元素](src/LC169.java)

    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

    思路：摩尔投票法

### 3 Hash Table

- [LeetCode 187 - 重复的DNA序列](src/LC187.java)

    编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。

    思路：滑动窗口+HashSet

### 4 Linked List

#### 4.1 Recursive Method

- [LeetCode 24 - 两两交换链表中的节点](src/LC24.java)

    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

    思路：递归的交换两个节点以后的节点，返回当前两个节点的后一个节点。

- [**LeetCode 445 - 两数相加II**](src/LC445.java)

    给你两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。
    它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。你不能对列表中的节点进行翻转。
    
    思路：计算链表长度差，使尾部对齐，递归的生成新节点（为两个链表的节点和）。

#### 4.2 Double Pointers

- [LeetCode 19 - 删除链表的倒数第N个节点](src/LC19.java)

    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
    
    思路：双指针隔开n的距离。


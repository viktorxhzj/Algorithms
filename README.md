# 小盒子的算法题

- [小盒子的算法题](#%e5%b0%8f%e7%9b%92%e5%ad%90%e7%9a%84%e7%ae%97%e6%b3%95%e9%a2%98)
  - [1 二分查找](#1-%e4%ba%8c%e5%88%86%e6%9f%a5%e6%89%be)
  - [2 二叉树](#2-%e4%ba%8c%e5%8f%89%e6%a0%91)
    - [2.1 迭代](#21-%e8%bf%ad%e4%bb%a3)
    - [2.2 递归](#22-%e9%80%92%e5%bd%92)
    - [2.2 BFS（层次遍历）](#22-bfs%e5%b1%82%e6%ac%a1%e9%81%8d%e5%8e%86)
    - [2.3 DFS（前序遍历、中序遍历、后序遍历）](#23-dfs%e5%89%8d%e5%ba%8f%e9%81%8d%e5%8e%86%e4%b8%ad%e5%ba%8f%e9%81%8d%e5%8e%86%e5%90%8e%e5%ba%8f%e9%81%8d%e5%8e%86)
  - [3 动态规划](#3-%e5%8a%a8%e6%80%81%e8%a7%84%e5%88%92)
    - [3.1 背包问题](#31-%e8%83%8c%e5%8c%85%e9%97%ae%e9%a2%98)
    - [3.2 卡塔兰数](#32-%e5%8d%a1%e5%a1%94%e5%85%b0%e6%95%b0)
  - [4 位运算](#4-%e4%bd%8d%e8%bf%90%e7%ae%97)
    - [4.1 异或](#41-%e5%bc%82%e6%88%96)
    - [4.2 与](#42-%e4%b8%8e)
  - [5 数组](#5-%e6%95%b0%e7%bb%84)
    - [5.1 模拟矩阵](#51-%e6%a8%a1%e6%8b%9f%e7%9f%a9%e9%98%b5)
  - [6 哈希表](#6-%e5%93%88%e5%b8%8c%e8%a1%a8)
  - [7 链表](#7-%e9%93%be%e8%a1%a8)
    - [7.1 递归](#71-%e9%80%92%e5%bd%92)
    - [7.2 双指针](#72-%e5%8f%8c%e6%8c%87%e9%92%88)

## 1 二分查找

- [**LeetCode 35 - 搜索插入位置**](src/LC35.java)

    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    你可以假设数组中无重复元素。

- [LeetCode 704 - 二分查找](src/LC704.java)

    给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

- [LeetCode 852 - 山脉数组的峰顶索引](src/LC852.java)

    给定一个确定为山脉的数组，返回唯一一个满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。

## 2 二叉树

### 2.1 迭代

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

### 2.2 递归

- [**LeetCode 95 - 不同的二叉搜索树II**](src/LC95.java)

    给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

    思路：G[n] = G[0] * G[n - 1] + G[1] * G[n - 2] + ... + G[n - 1] * G[0]

- [**LeetCode 98 - 验证二叉搜索树**](src/LC98.java)

    给定一个二叉树，判断其是否是一个有效的二叉搜索树。

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

### 2.2 BFS（层次遍历）

- [LeetCode 102 - 二叉树的层次遍历](src/LC102.java)

    给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

- [LeetCode 103 - 二叉树的锯齿形遍历](src/LC103.java)

    给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

- [LeetCode 199 - 二叉树的右视图](src/LC199.java)

    给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

### 2.3 DFS（前序遍历、中序遍历、后序遍历）

- [LeetCode 105 - 前序遍历和中序遍历序列构造二叉树](src/LC105.java)

    根据一棵树的前序遍历与中序遍历构造二叉树。

- [LeetCode 106 - 中序和后序遍历序列构造二叉树](src/LC106.java)

    根据一棵树的中序遍历与后序遍历构造二叉树。

- [LeetCode 113 - 路径总和II](src/LC113.java)

    给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

## 3 动态规划

### 3.1 背包问题

- [**LeetCode 面试题08.11 - 硬币**](src/LCInterview0811.java)

    给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。

    思路：DP[{c1, c2,... ck}][n] = DP[{c1, c2,... ck}][n - ck.value] + DP[{c1, c2,... ck-1}][n];

### 3.2 卡塔兰数

- [**LeetCode 96 - 不同的二叉搜索树**](src/LC96.java)

    给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

    思路：G[n] = G[0] * G[n - 1] + G[1] * G[n - 2] + ... + G[n - 1] * G[0]

## 4 位运算

### 4.1 异或

- [LeetCode 136 - 只出现一次的数字](src/LC136.java)

    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

    思路：两个相等的数异或为0。异或所有数字即可得到唯一只出现一次的数字。

### 4.2 与

- [LeetCode 137 - 只出现一次的数字II](src/LC137.java)

    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
    
    思路：3个元素的每位的和必定是3的倍数。

## 5 数组

### 5.1 模拟矩阵

- [LeetCode 6 - Z字形变换](src/LC6.java)

    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

- [LeetCode 169 - 多数元素](src/LC169.java)

    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

    思路：摩尔投票法

## 6 哈希表

- [LeetCode 187 - 重复的DNA序列](src/LC187.java)

    编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。

    思路：滑动窗口+HashSet

## 7 链表

### 7.1 递归

- [LeetCode 24 - 两两交换链表中的节点](src/LC24.java)

    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

    思路：递归的交换两个节点以后的节点，返回当前两个节点的后一个节点。

### 7.2 双指针

- [LeetCode 19 - 删除链表的倒数第N个节点](src/LC19.java)

    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。


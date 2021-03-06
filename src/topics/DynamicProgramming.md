# Dynamic Programming

## 1 从1到i的最大/最小...
```java
/* 
dp[n]即是问题的答案。
关键点是思考状态转移，即递归公式。
*/
```
|序号|题目|
|:----|:----|
|[1458](/leetcode/LC1458.java)|两个子序列的最大点积|

## 2 以i结尾的最大/最小...
```java
/*
记录每一个以i结尾的值，同步更新最大最小。Result = Max(dp[1], dp[2], ... dp[n])
关键点是思考状态转移，即递归公式。
*/
```
|序号|题目|
|:----|:----|
|[221](/leetcode/LC221.java)|最大正方形|

## 3 KMP算法 [算法代码](/algorithms/KMP.java)
```java
/*
1. 计算next数组
2. 根据next数组，在遍历发现不同时，移动指针
*/
```

## 4 背包问题
```java
/*
0-1背包问题
dp[i][j] = dp[i - 1][j] + dp[i][j - value(i)]
*/

/*
完全背包问题
dp[j] = dp[j - value(1)] + dp[j - value(2)]... + dp[j - value(i)]
*/
```
## 5 卡塔兰数
```java
/*
G[n] n个节点组成的二叉搜索树的数量
G[n] = f[1][n] + ... + f[n][n]

f[i][n] 以i节点为根节点的n个节点组成的二叉搜索树的数量
f[i][n] = G[i - 1] * G[n - i]

G[n] = G[0] * G[n - 1] + G[1] * G[n - 2] + ... + G[n - 1] * G[0]
*/
```
|序号|题目|
|:----|:----|
|[96](/leetcode/LC96.java)|不同的二叉搜索树|
|[95](/leetcode/LC95.java)|不同的二叉搜索树II|

## 6 正则表达式匹配

|序号|难度|题目|
|:----|:----|:----|
|[10](/leetcode/LC10.java)|困难|正则表达式匹配|
|[44](/leetcode/LC44.java)|困难|通配符匹配|

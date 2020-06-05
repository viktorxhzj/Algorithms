# Binary Search

## 1 单值二分查找

```java
class Demo {
    public int binarySearch(int[] arr, int T) {
        int L = 0, R = arr.length - 1;
        while (L < R) {
            int M = (L + R) >> 1;
            if (arr[M] == T) return M;
            if (arr[M] > T) R = M - 1;
            if (arr[M] < T) L = M + 1;
        }
        return arr[L] == T? L: -1;
    }
}
```

|序号|题目|
|:----|:----|
|[704](/leetcode/LC704.java)|二分查找|
|[852](/leetcode/LC852.java)|山脉数组的峰顶索引|

## 2 寻找单边界

```java
class Demo {
    /* 寻找左边界 */
    public static int leftBound(int[] arr, int T) { 
        // [L, R)
        int L = 0, R = arr.length;

        while (L < R) {
            int M = L + ((R - L) >> 1);
            if (arr[M] == T) R = M;
            if (arr[M] > T) R = M;
            if (arr[M] < T) L = M + 1;
        }
        // L = arr.length, 代表 T > arr[arr.length - 1]
        // 其他，T <= arr[L]
        // L = 小于T的元素有几个。

        if (L == arr.length) return -1;
        return T == arr[L]? L: -1;
    }
    
    /* 寻找右边界 */
    public static int rightBound(int[] arr, int T) { 
        // [L, R)
        int L = 0, R = arr.length;

        while (L < R) {
            int M = L + ((R - L) >> 1);
            // L所在位置绝不可能是T，但L-1可能是
            if (arr[M] == T) L = M + 1;
            if (arr[M] > T) R = M;
            if (arr[M] < T) L = M + 1;
        }
        
        // L = 0, T < arr[0]
        // T >= arr[L - 1]
        // T < arr[L]     

        if (L == 0) return -1;
        
        return arr[L - 1] == T? L - 1: -1;
    }
}
```

|序号|题目|
|:----|:----|
|[35](/leetcode/LC35.java)|搜索插入位置|
|[278](/leetcode/LC278.java)|第一个错误的版本|
|[34](/leetcode/LC34.java)|在排序数组中查找元素的第一个和最后一个位置|
|[744](/leetcode/LC744.java)|寻找比目标字母大的最小字母|

## 3 平方二分查找

|序号|题目|
|:----|:----|
|[69](/leetcode/LC69.java)|x的平方根|
|[367](/leetcode/LC367.java)|有效的完全平方数|
||||

## 4 旋转数组

- [LeetCode 33 - 搜索旋转排序数组](/leetcode/LC33.java)

    假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回-1。

- [**LeetCode 81 - 搜索旋转排序数组II**](/leetcode/LC81.java)

    假设按照升序排序的数组在预先未知的某个点上进行了旋转。本题中含有重复元素。
    
- [LeetCode 153 - 寻转旋转排序数组中的最小值](/leetcode/LC153.java)

    假设按照升序排序的数组在预先未知的某个点上进行了旋转。请找出数组中的最小元素。

- [**LeetCode 154 - 寻转旋转排序数组中的最小值II**](/leetcode/LC154.java)

    假设按照升序排序的数组在预先未知的某个点上进行了旋转。请找出数组中的最小元素。本题中含有重复元素。
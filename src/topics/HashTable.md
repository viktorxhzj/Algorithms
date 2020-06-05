# Hash Table

## 1 前缀和

- 前缀和为从第一个元素到当前元素的和。
    preSum[i] = arr[0] + arr[1] + ... + arr[i]
- 如果两个元素前缀和之差为target，则这两个节点之间的元素总和为target。
    if preSum[i] - preSum[j] == target
    then arr[j + 1] + arr[j + 2] + ... + arr[i] = target
- 使用哈希表存储[前缀和，前缀和数量]。
- 遍历的时候，如果当前元素前缀和 - target 存在于哈希表中，则对应的前缀和数量为元素总和为target的以当前元素为结尾的子数组的数量。


|序号|题目|
|:----|:----|
|[525](/leetcode/LC525.java)|连续数组|
|[560](/leetcode/LC560.java)|和为K的子数组|
|[437](/leetcode/LC437.java)|路径总和III|
|[1248](/leetcode/LC1248.java)|统计优美子数组|
|[454](/leetcode/LC454.java)|四数相加II|


560
525
30
41
437
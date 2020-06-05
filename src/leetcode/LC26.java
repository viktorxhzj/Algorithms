package leetcode;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class LC26 {
    public int removeDuplicates(int[] arr) {
        /*
        循环不变量
        j = 当前遍历到的位置
        i = 可以被下一个数去取代的位置
        */
        if (arr.length < 2) return arr.length;


        int i = 1, j = 1;
        while (j < arr.length) {
            // 遍历到的数和之前的数不同，则是第一次遍历到这个数
            // 将该数放到可以取代的位置
            if (arr[j] != arr[j - 1]) {
                arr[i] = arr[j];
                i++;
            }
            // 遍历到的数和之前的数相同，则不是第一次遍历到这个数，跳过
            j++;
        }
        return i;
    }
}

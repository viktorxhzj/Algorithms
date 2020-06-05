package leetcode;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 */
public class LC80 {
    public int removeDuplicates(int[] arr) {
        /*
        j - 遍历元素的下标
        i - 可以用于替换元素的下标
        */

        int i = 1, j = 1, count = 1;
        while (j < arr.length) {
            // 第一次遍历到，可以扔过去替换
            if (arr[j] != arr[j - 1]) {
                count = 1;
                arr[i] = arr[j];
                i++;
                j++;
            }
            // 如果不是第一次遍历到
            else {
                count++;
                // 第二次遍历到还是可以扔过去替换
                if (count == 2) {
                    arr[i] = arr[j];
                    i++;
                }
                // 第二次以上，跳过
                j++;
            }
        }
        return i;
    }
}

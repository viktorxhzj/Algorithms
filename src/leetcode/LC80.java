package leetcode;

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
                arr[i++] = arr[j++];
            }
            // 如果不是第一次遍历到
            else {
                count++;
                // 第二次遍历到还是可以扔过去替换
                if (count == 2) arr[i++] = arr[j++];
                // 第二次以上，跳过
                else j++;
            }
        }
        return i;
    }
}

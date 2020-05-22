package leetcode;

public class LC26 {
    public int removeDuplicates(int[] arr) {
        /*
        j = 当前遍历到的位置
        i = 可以被下一个数去取代的位置
        */
        if (arr.length < 2) return arr.length;


        int i = 0, j = 1;
        while (j < arr.length) {
            // 遍历到的数和之前的数不同，则是第一次遍历到这个数
            // 将该数放到可以取代的位置
            if (arr[j] != arr[j - 1]) {
                arr[++i] = arr[j++];
            }
            // 遍历到的数和之前的数相同，则不是第一次遍历到这个数，跳过
            else j++;
        }
        // i 为下标，长度应+1
        return i + 1;
    }
}

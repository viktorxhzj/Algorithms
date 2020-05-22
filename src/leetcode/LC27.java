package leetcode;

public class LC27 {
    public int removeElement(int[] arr, int val) {
         /*
        j = 当前遍历到的位置
        i = 可以被取代的位置
        */

        int i = 0, j = 0;


        while (j < arr.length) {
            if (arr[j] == val) j++;
            else arr[i++] = arr[j++];
        }

        return i;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        if (arr == null || arr.length < 3) return result;

        Arrays.sort(arr);
        /*
        k = element 1;
        i = left boundary;
        j = right boundary;
        arr[k] + arr[i] + arr[j] == 0
        */
        for (int k = 0; k < arr.length - 2; k++) {
            // 去重
            if (k > 0 && arr[k] == arr[k - 1]) continue;

            int i = k + 1, j = arr.length - 1;
            while (i < j) {
                if (arr[k] + arr[i] + arr[j] == 0) {
                    result.add(Arrays.asList(arr[k], arr[i], arr[j]));
                    i++;
                    j--;
                    // 去重
                    while (i < j && arr[i] == arr[i - 1]) i++;
                    while (i < j && arr[j] == arr[j + 1]) j--;
                }
                else if (arr[k] + arr[i] + arr[j] > 0) {
                    j--;
                }
                else {
                    i++;
                }
            }
        }

        return result;
    }
}

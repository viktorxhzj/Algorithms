package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        // 极端情况1：x小于第一个元素
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) res.add(arr[i]);
            return res;
        }

        // 极端情况2：x大于最后一个元素
        if (x > arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) res.add(arr[i]);
            return res;
        }

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                left = mid;
                break;
            }
            if (arr[mid] < x) left = mid + 1;
            if (arr[mid] > x) right = mid - 1;
        }

        LinkedList<Integer> ans = new LinkedList<>();

        int count = 0;
        if (arr[left] == x) {
            ans.offerFirst(arr[left]);
            right = left--;
            right++;
            count++;
        }
        else {
            right = left--;
        }
        while (count++ < k) {
            if (left < 0) {
                ans.offerLast(arr[right++]);
            }
            else if (right >= arr.length) {
                ans.offerFirst(arr[left--]);
            }

            else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                ans.offerFirst(arr[left--]);
            }
            else {
                ans.offerLast(arr[right++]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] t = new int[]{0,1,1,1,2,3,6,7,8,9};
        LC658 algo = new LC658();
        algo.findClosestElements(t, 9, 4);
    }
}

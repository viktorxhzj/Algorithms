package leetcode;

import datastructure.ListNode;

import java.util.Arrays;

public class LC725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] list = new ListNode[k];
        int[] size = new int[k];

        int len = 0;
        ListNode ptr = root;
        while (ptr != null) {
            len++;
            ptr = ptr.next;
        }

        if (len <= k) {
            ptr = root;
            int i = 0;
            while (ptr != null) {
                ListNode end = ptr;
                ptr = ptr.next;
                end.next = null;
                list[i] = end;
                i++;
            }
            return list;
        }

        Arrays.fill(size, len / k);
        for (int i = 0; i < len % k; i++) {
            size[i]++;
        }

        ptr = root;
        for (int i = 0; i < k; i++) {
            ListNode head = ptr;
            for (int j = 0; j < size[i] - 1; j++) {
                ptr = ptr.next;
            }
            ListNode end = ptr;
            ptr = ptr.next;
            end.next = null;
            list[i] = head;
        }

        return list;
    }
}

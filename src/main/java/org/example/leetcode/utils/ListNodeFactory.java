package org.example.leetcode.utils;

import java.util.Arrays;

public class ListNodeFactory {

    public static ListNode create(String str) {
        String numsStr = str.replace("[", "").replace("]", "").replace(" ", "");
        if (str.isEmpty()) return null;
        return create(Arrays.stream(numsStr.split(",")).mapToInt(Integer::parseInt).toArray());
    }

    public static ListNode create(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        if (arr.length == 1) return head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
}

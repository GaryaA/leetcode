package org.example.leetcode.recursion;

import org.example.leetcode.utils.ListNode;
import org.example.leetcode.utils.ListNodeUtils;

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = head;
        ListNode end = head;
        ListNode prevMid = null;
        while (end != null && end.next != null) {
            prevMid = mid;
            mid = mid.next;
            end = end.next.next;
        }
        prevMid.next = null;
        ListNode reversed = ListNodeUtils.reverseList(mid);
        merge(head, reversed);
    }

    private void merge(ListNode node1, ListNode node2) {
        if (node1.next == null) {
            node1.next = node2;
            return;
        }
        if (node2.next == null) {
            return;
        }
        ListNode tmp1 = node1.next;
        node1.next = node2;
        ListNode tmp2 = node2.next;
        node2.next = tmp1;
        merge(tmp1, tmp2);
    }


}

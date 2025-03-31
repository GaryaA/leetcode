package org.example.leetcode.lists;

import org.example.leetcode.utils.ListNode;
import org.example.leetcode.utils.ListNodeUtils;

public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(1);
            head.next.next = new ListNode(1);
            head.next.next.next = new ListNode(2);
            head.next.next.next.next = new ListNode(3);
            ListNodeUtils.print(head);
            ListNodeUtils.print(new RemoveDuplicatesfromSortedListII().deleteDuplicates(head));
        }
        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(3);
            head.next.next.next.next = new ListNode(4);
            head.next.next.next.next.next = new ListNode(4);
            head.next.next.next.next.next.next = new ListNode(5);
            ListNodeUtils.print(head);
            ListNodeUtils.print(new RemoveDuplicatesfromSortedListII().deleteDuplicates(head));
        }
        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(1);
            ListNodeUtils.print(new RemoveDuplicatesfromSortedListII().deleteDuplicates(head));
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        if (head.val == head.next.val) {
            while (node != null && node.next != null && node.val == node.next.val) {
                while (node.next != null && node.val == node.next.val) {
                    node = node.next;
                }
                node = node.next;
            }
            head = node;
        }

        if (head == null) return head;

        ListNode prev = head;
        while (prev.next != null) {
            ListNode curr = prev.next;
            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }

}

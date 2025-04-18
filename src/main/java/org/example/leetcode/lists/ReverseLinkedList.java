package org.example.leetcode.lists;

import org.example.leetcode.utils.ListNode;
import org.example.leetcode.utils.ListNodeUtils;

public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNodeUtils.print(head);

        ListNodeUtils.print(reverseList(head));

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode pointer = new ListNode(head.val);

        while (head.next != null) {
            ListNode tmp = pointer;
            pointer = new ListNode(head.next.val);
            pointer.next = tmp;
            head = head.next;
        }

        return pointer;
    }
}

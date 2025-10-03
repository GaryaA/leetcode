package org.example.leetcode.lists;

import org.example.leetcode.utils.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode fast = head;
        ListNode mid = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }
        ListNode middlePointer = mid;
        while (middlePointer != null) {
            stack.push(middlePointer.val);
            middlePointer = middlePointer.next;
        }
        while (head != mid) {
            if (head.val != stack.pop()) return false;
            head = head.next;
        }
        return true;
    }
}

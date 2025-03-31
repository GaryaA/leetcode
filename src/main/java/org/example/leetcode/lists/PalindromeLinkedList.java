package org.example.leetcode.lists;

import utils.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(2);
            head.next.next.next.next = new ListNode(1);
            System.out.println(new PalindromeLinkedList().isPalindrome(head));
        }
//        {
//            ListNode head = new ListNode(1);
//            head.next = new ListNode(2);
//            System.out.println(new PalindromeLinkedList().isPalindrome(head));
//        }
    }

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

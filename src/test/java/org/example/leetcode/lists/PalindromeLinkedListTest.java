package org.example.leetcode.lists;

import org.example.leetcode.utils.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeLinkedListTest {

    private PalindromeLinkedList pObj = new PalindromeLinkedList();

    @Test
    void isPalindrome() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        Assertions.assertTrue(pObj.isPalindrome(head));
    }

    @Test
    void isPalindrome1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        Assertions.assertFalse(pObj.isPalindrome(head));
    }

    @Test
    void isPalindrome2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        Assertions.assertTrue(pObj.isPalindrome(head));
    }
}
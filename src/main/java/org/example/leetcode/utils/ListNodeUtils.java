package org.example.leetcode.utils;

public class ListNodeUtils {

    public static void print(ListNode head) {
        System.out.println(toString(head));
    }

    public static String toString(ListNode head) {
        if (head == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val + " -> ");
            head = head.next;
        }
        sb.delete(sb.length() - 4, sb.length());
        return sb.toString();
    }

    public static boolean deepEquals(ListNode head1, ListNode head2) {
        if (head1 == head2) return true;
        if (head1 == null || head2 == null) return false;
        if (head1.val != head2.val) return false;
        return deepEquals(head1.next, head2.next);
    }
}

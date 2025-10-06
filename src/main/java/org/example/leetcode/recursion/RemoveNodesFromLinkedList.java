package org.example.leetcode.recursion;

import org.example.leetcode.utils.ListNode;

public class RemoveNodesFromLinkedList {

//    public ListNode removeNodes(ListNode head) {
//        if (head == null) return null;
//        int max = 0;
//        ListNode resHead = null;
//        while (head != null) {
//            if (head.val > max) {
//                resHead = head;
//                max = head.val;
//            }
//            head = head.next;
//        }
//        resHead.next = removeNodes(resHead.next);
//        return resHead;
//    }

//    public ListNode removeNodes(ListNode head) {
//        if (head == null || head.next == null) return head;
//
//        Stack<ListNode> stack = new Stack<>();
//
//        while (head != null) {
//            if (!stack.isEmpty()) {
//                try {
//                    ListNode todelete;
//                    while ((todelete = stack.pop()).val < head.val) {
//                    }
//                    stack.push(todelete);
//                } catch (EmptyStackException e) {
//                }
//            }
//            stack.push(head);
//            head = head.next;
//        }
//
//        ListNode curr = null;
//        ListNode next = null;
//
//        while (!stack.isEmpty()) {
//            curr = stack.pop();
//            curr.next = next;
//            next = curr;
//        }
//        return curr;
//    }


    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }


}

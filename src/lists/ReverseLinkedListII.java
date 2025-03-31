package lists;

import utils.ListNode;
import utils.ListNodeUtils;

public class ReverseLinkedListII {

    public static void main(String[] args) {

        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
            ListNodeUtils.print(head);
            int left = 2, right = 4;
            ListNodeUtils.print(new ReverseLinkedListII().reverseBetween(head, left, right));
        }

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;
        ListNode node = head;
        ListNode prev = node;
        if (left > 1) {
            for (int i = 1; i < left; i++) {
                prev = node;
                node = node.next;
            }
        }
        ListNode pointerHead = new ListNode(node.val);
        ListNode pointerTail = pointerHead;

        for (int i = left; i < right; i++) {
            ListNode tmp = pointerHead;
            pointerHead = new ListNode(node.next.val);
            pointerHead.next = tmp;
            node = node.next;
        }

        if (left > 1) prev.next = pointerHead;
        else head = pointerHead;

        pointerTail.next = node.next;

        return head;
    }



}

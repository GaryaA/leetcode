package trees;

import utils.ListNode;
import utils.TreeNode;
import utils.TreeNodePrinter;

public class ConvertSortedListtoBinarySearchTree {

    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNodePrinter.print(new ConvertSortedListtoBinarySearchTree().sortedListToBST(head));

    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        if (head.next.next == null) {
            TreeNode r = new TreeNode(head.next.val);
            r.left = new TreeNode(head.val);
            return r;
        }
        ListNode middle = head;
        ListNode prevMiddle = head;
        ListNode end = head;
        while (end != null && end.next != null) {
            prevMiddle = middle;
            middle = middle.next;
            end = end.next.next;
        }
        ListNode rightList = middle.next;
        prevMiddle.next = null;

        TreeNode root = new TreeNode(middle.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rightList);
        return root;
    }
}

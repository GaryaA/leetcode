package org.example.leetcode.lists;

import utils.ListNode;
import utils.ListNodeUtils;

public class MergekSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNodeUtils.print(new MergekSortedLists().mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        Integer nextMin = getNextMinValue(lists);
        if (nextMin == null) {
            return null;
        }
        ListNode r = new ListNode(nextMin);
        ListNode head = r;
        while ((nextMin = getNextMinValue(lists)) != null) {
            head = head.next = new ListNode(nextMin);
        }
        return r;
    }

    private Integer getNextMinValue(ListNode[] lists) {
        Integer min = null;
        int minIdx = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (min == null) {
                min = lists[i].val;
                minIdx = i;
            }
            if (lists[i].val < min) {
                min = lists[i].val;
                minIdx = i;
            }
        }
        if (min == null) {
            return null;
        }
        lists[minIdx] = lists[minIdx].next;
        return min;
    }

}

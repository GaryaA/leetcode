package org.example.leetcode.twopointers

import org.example.leetcode.utils.ListNode

fun partition(head: ListNode?, x: Int): ListNode? {
    if (head == null) return null

    var curr = head
    var list1: ListNode? = null
    var list2: ListNode? = null
    var headList1: ListNode? = null
    var headList2: ListNode? = null

    while (curr != null) {
        if (curr.`val` < x) {
            if (list1 == null) {
                list1 = ListNode(curr.`val`)
                headList1 = list1
            } else {
                list1.next = ListNode(curr.`val`)
                list1 = list1.next
            }
        } else {
            if (list2 == null) {
                list2 = ListNode(curr.`val`)
                headList2 = list2
            } else {
                list2.next = ListNode(curr.`val`)
                list2 = list2.next
            }
        }
        curr = curr.next
    }

    list1?.next = headList2

    return headList1 ?: headList2
}
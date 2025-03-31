package org.example.leetcode.twopointers

import org.example.leetcode.utils.ListNode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    if (head.next == null) if (n == 0) return head else return null

    var cur = head!!
    var prev = cur
    var prevCount = 1
    while (cur.next != null) {
        cur = cur.next
        if (prevCount > n) {
            prev = prev.next
        }
        prevCount++
    }
    if (prevCount == n) {
        return head.next
    }

    val pointer1 = prev
    val pointer2 = prev.next
    pointer1.next = pointer2?.next

    return head
}
package twopointers

import utils.ListNode
import utils.ListNodeFactory
import utils.ListNodeUtils

fun main() {
    val head = ListNodeFactory.create("0,1,2")
    ListNodeUtils.print(rotateRight(head, 4))
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (k == 0 || head == null || head.next == null) return head

    var start = head!!
    var cur = head!!
    var prev = cur
    var prevCount = 0

    val size = listSize(head)

    if (k % size == 0) return head

    while (cur.next != null) {
        cur = cur.next
        if (prevCount >= k % size) {
            prev = prev.next
        }
        prevCount++
    }
    cur.next = start
    val tail = prev
    val newHead = prev.next
    tail.next = null
    return newHead
}

fun listSize(head: ListNode?): Int {
    if (head == null) return 0
    var r = 1
    var cur = head!!
    while (cur.next != null) {
        cur = cur.next
        r++
    }
    return r
}
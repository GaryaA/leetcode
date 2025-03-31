package org.example.leetcode.twopointers

import org.example.leetcode.utils.ListNodeFactory
import org.example.leetcode.utils.ListNodeUtils
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RemoveNthNodeFromEndofListKtTest {

    @Test
    fun removeNthFromEnd1() {
        val r = removeNthFromEnd(ListNodeFactory.create("1,2,3,4,5"), 2)
        ListNodeUtils.print(r)
        assertTrue(
            ListNodeUtils.deepEquals(
                ListNodeFactory.create("1,2,3,5"), r
            )
        )
    }

    @Test
    fun removeNthFromEnd2() {
        val r = removeNthFromEnd(ListNodeFactory.create("1"), 1)
        ListNodeUtils.print(r)
        assertTrue(
            ListNodeUtils.deepEquals(
                null, r
            )
        )
    }

    @Test
    fun removeNthFromEnd3() {
        val r = removeNthFromEnd(ListNodeFactory.create("1,2"), 1)
        ListNodeUtils.print(r)
        assertTrue(
            ListNodeUtils.deepEquals(
                ListNodeFactory.create("1"), r
            )
        )
    }

    @Test
    fun removeNthFromEnd4() {
        val r = removeNthFromEnd(ListNodeFactory.create("1,2"), 2)
        ListNodeUtils.print(r)
        assertTrue(
            ListNodeUtils.deepEquals(
                ListNodeFactory.create("2"), r
            )
        )
    }

}
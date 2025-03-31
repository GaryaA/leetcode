package org.example.leetcode.twopointers

import org.example.leetcode.utils.ListNodeFactory
import org.example.leetcode.utils.ListNodeUtils
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PartitionListKtTest {
    @Test
    fun partition() {
        val created = ListNodeFactory.create("1,4,3,2,5,2")
        val r = partition(created, 3)
        println(r)
        assertTrue(
            ListNodeUtils.deepEquals(
                ListNodeFactory.create("1,2,2,4,3,5"),
                r,
            )
        )
    }

    @Test
    fun partition1() {
        val created = ListNodeFactory.create("2,1")
        assertTrue(
            ListNodeUtils.deepEquals(
                ListNodeFactory.create("1,2"),
                partition(created, 2),
            )
        )
    }

}
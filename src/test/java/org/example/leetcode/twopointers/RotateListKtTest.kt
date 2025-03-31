package org.example.leetcode.twopointers

import org.example.leetcode.utils.ListNodeFactory
import org.example.leetcode.utils.ListNodeUtils
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RotateListKtTest {
    @Test
    fun rotateRight() {
        val head = ListNodeFactory.create("0,1,2")
        assertTrue(
            ListNodeUtils.deepEquals(
                rotateRight(head, 4),
                ListNodeFactory.create("2,0,1")
            )
        )
    }

}
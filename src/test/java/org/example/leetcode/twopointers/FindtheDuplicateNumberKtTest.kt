package org.example.leetcode.twopointers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindtheDuplicateNumberKtTest {
    @Test
    fun findDuplicate() {
        val nums = intArrayOf(1, 3, 4, 2, 2)
        assertEquals(2, findDuplicate(nums))
    }

    @Test
    fun findDuplicate1() {
        val nums = intArrayOf(3, 1, 3, 4, 2)
        assertEquals(3, findDuplicate(nums))
    }

    @Test
    fun findDuplicate2() {
        val nums = intArrayOf(3, 3, 3, 3, 3)
        assertEquals(3, findDuplicate(nums))
    }

}
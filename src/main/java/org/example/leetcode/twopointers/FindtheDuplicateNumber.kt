package org.example.leetcode.twopointers

import kotlin.math.abs

fun findDuplicate(nums: IntArray): Int {
    for (n in nums) {
        val absN = abs(n)
        nums[absN] = -nums[absN]
        if (nums[absN] > 0) return absN
    }
    return -1
}
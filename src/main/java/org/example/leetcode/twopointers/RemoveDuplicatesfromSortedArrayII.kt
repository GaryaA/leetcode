package org.example.leetcode.twopointers

fun main() {
    var arr = intArrayOf(1, 1, 1, 1, 2, 2, 2, 2, 3)
    println(removeDuplicates(arr))
}

fun removeDuplicates(nums: IntArray): Int {
    if (nums.size < 3) return nums.size
    var p = 2
    for (i in 2 until nums.size) {
        if (nums[i] != nums[p - 2]) {
            nums[p++] = nums[i]
        }
    }
    return p
}
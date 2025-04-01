package org.example.leetcode.twopointers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CompareVersionNumbersKtTest {
    @Test
    fun compareVersion() {
        val version1 = "1.2"
        val version2 = "1.10"
        assertEquals(-1, compareVersion(version1, version2))
    }

    @Test
    fun compareVersion1() {
        val version1 = "1.01"
        val version2 = "1.001"
        assertEquals(0, compareVersion(version1, version2))
    }

    @Test
    fun compareVersion2() {
        val version1 = "1.0"
        val version2 = "1.0.0.0"
        assertEquals(0, compareVersion(version1, version2))
    }

}
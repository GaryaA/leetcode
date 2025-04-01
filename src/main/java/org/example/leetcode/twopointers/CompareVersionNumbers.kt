package org.example.leetcode.twopointers

//fun compareVersion(version1: String, version2: String): Int {
//    val versionArr1 = version1.split(".").map { it.toInt() }
//    val versionArr2 = version2.split(".").map { it.toInt() }
//
//    val equalsArrs = versionArr1.zip(versionArr2).find { it.first != it.second }
//        ?.let { it.first.compareTo(it.second) } ?: 0
//    if (equalsArrs != 0) return equalsArrs
//
//    return when (versionArr1.size.compareTo(versionArr2.size)) {
//        1 -> versionArr1.subList(versionArr2.size, versionArr1.size).find { it > 0 }?.compareTo(0) ?: 0
//        -1 -> 0.compareTo(versionArr2.subList(versionArr1.size, versionArr2.size).find { it > 0 } ?: 0)
//        0 -> 0
//        else -> throw IllegalStateException()
//    }
//}

fun compareVersion(version1: String, version2: String): Int {
    val versionArr1 = version1.split(".").map { it.toInt() }
    val versionArr2 = version2.split(".").map { it.toInt() }
    var p1 = -1
    var p2 = -1
    while (p1 + 1 < versionArr1.size || p2 + 1 < versionArr2.size) {
        p1++
        p2++
        if (p1 >= versionArr1.size) {
            if (versionArr2[p2] > 0) return -1
            else continue
        }
        if (p2 >= versionArr2.size) {
            if (versionArr1[p1] > 0) return 1
            else continue
        }
        if (versionArr1[p1] != versionArr2[p2]) return versionArr1[p1].compareTo(versionArr2[p2])
    }
    return 0
}

//fun compareVersion(version1: String, version2: String): Int {
//    var p1 = 0
//    var p2 = 0
//    while (p1 != -1 || p2 != -1) {
//        var p1Next = version1.indexOf(".", p1)
//        if (p1Next == -1 && p1 < version1.length) p1Next = version1.length
//
//        var p2Next = version2.indexOf(".", p2)
//        if (p2Next == -1 && p2 < version2.length) p2Next = version2.length
//
//        if (p1Next == -1 && p2Next == -1) return 0
//
//        if (p1Next == -1) {
//            if (version2.slice(p2 until p2Next).toInt() > 0) return -1
//        } else if (p2Next == -1) {
//            if (version1.slice(p1 until p1Next).toInt() > 0) return 1
//        } else {
//            val subV1 = version1.slice(p1 until p1Next).toInt()
//            val subV2 = version2.slice(p2 until p2Next).toInt()
//            if (subV1 != subV2) return subV1.compareTo(subV2)
//        }
//        p1 = if (p1Next != -1) p1Next + 1 else version1.length
//        p2 = if (p2Next != -1) p2Next + 1 else version2.length
//    }
//    return 0
//}
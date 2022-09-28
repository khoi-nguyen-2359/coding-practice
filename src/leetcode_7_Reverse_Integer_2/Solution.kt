package leetcode_7_Reverse_Integer_2

import kotlin.test.assertEquals

class Solution {
    fun reverse(x: Int): Int {
        var c = x
        var res = 0
        while (c != 0) {
            val v = c % 10
            if ((res > 0 && (Int.MAX_VALUE - v) / 10 < res) || (res < 0 && (Int.MIN_VALUE - v) / 10 > res)) {
                return 0
            }
            res = res * 10 + v
            c /= 10
        }
        return res
    }
}

fun main() {
    arrayOf(
            123 to 321,
            -123 to -321,
            120 to 21,
            Int.MAX_VALUE to 0
    ).forEach {
        assertEquals(it.second, Solution().reverse(it.first))
    }
}
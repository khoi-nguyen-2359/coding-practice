package leetcode_69_sqrtx

import kotlin.test.assertEquals

class Solution {
    fun mySqrt(x: Int): Int {
        if (x < 2) {
            return x
        }
        var l = 0
        var h = x
        var m = (l + h) / 2
        while (l != m) {
            val k = x / m
            if (k == m) {
                return m
            }
            if (k < m) {
                h = m
            } else {
                l = m
            }
            m = (l + h) / 2
        }

        return m
    }
}

fun main() {
    arrayOf(
        0 to 0,
        1 to 1,
        2 to 1,
        4 to 2,
        8 to 2,
        13 to 3,
        37 to 6,
        50 to 7,
        125 to 11,
        11890 to 109
    ).forEach { (i, o) ->
        assertEquals(o, Solution().mySqrt(i))
    }
}
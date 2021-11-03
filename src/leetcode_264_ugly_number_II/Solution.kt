package leetcode_264_ugly_number_II

import java.util.*

class Solution {
    fun nthUglyNumber(n: Int): Long {
        if (n == 1)
            return 1

        var k = 0
        var p = 1L
        val remember = TreeSet<Long>()
        remember.add(1)
        while (k < n) {
            p = remember.pollFirst() ?: p
            ++k
            remember.add(p * 2)
            remember.add(p * 3)
            remember.add(p * 5)
        }
        return p
    }
}

fun main() {
    Solution().nthUglyNumber(1407).let(::println)
}
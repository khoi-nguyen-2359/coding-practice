package leetcode_128_Longest_Consecutive_Sequence_2

import kotlin.math.min
import kotlin.math.max

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val exists = mutableMapOf<Int, Pair<Int, Int>>()
        var result = 0
        for (n in nums) {
            if (exists.containsKey(n)) {
                continue
            }

            val prev = exists[n-1]
            val next = exists[n+1]
            val min = min(min(prev?.first ?: Int.MAX_VALUE, next?.first ?: Int.MAX_VALUE), n)
            val max = max(max(prev?.second ?: Int.MIN_VALUE, next?.second ?: Int.MIN_VALUE), n)
            exists[min] = min to max
            exists[max] = min to max
            exists[n] = min to max
            if (result < max - min + 1) {
                result = max - min + 1
            }
        }

        return result
    }
}

fun main() {
    arrayOf(
        intArrayOf(100, 4, 200, 1, 3, 2),
        intArrayOf(0,3,7,2,5,8,4,6,0,1),
        intArrayOf(100,4,200,1,3,2,7,6,5),
    ).forEach {
        Solution().longestConsecutive(it).let(::println)
        println()
    }
}
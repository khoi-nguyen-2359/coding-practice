package leetcode_1405_Longest_Happy_String

import java.lang.Integer.min

class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val counters = mutableMapOf(
                'a' to a,
                'b' to b,
                'c' to c
        )
        return buildString {
            do {
                var maxCount = 0
                var next: Map.Entry<Char, Int>? = null
                for (entry in counters) {
                    if (entry.value > maxCount && entry.key != lastOrNull()) {
                        next = entry
                        maxCount = entry.value
                    }
                }
                next ?: return@buildString
                if (next.value == 0) {
                    break
                }
                val occur = if (next.value < (counters[lastOrNull()] ?: 0)) {
                    min(1, next.value)
                } else {
                    min(2, next.value)
                }
                counters[next.key] = next.value - occur
                repeat(occur) {
                    append(next.key)
                }
            } while (true)
        }
    }
}

fun main() {
    Solution().longestDiverseString(1,1,7).let(::println)
}
/*
Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
 */
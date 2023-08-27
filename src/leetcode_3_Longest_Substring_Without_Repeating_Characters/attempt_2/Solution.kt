package leetcode_3_Longest_Substring_Without_Repeating_Characters.attempt_2

import kotlin.test.assertEquals

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        val existed = mutableMapOf<Char?, Int>()
        var start = 0
        for (i in 0 .. s.length) {
            val char = s.getOrNull(i)
            val lastPos = existed[char]
            if ((lastPos != null && lastPos >= start) || i == s.length) {
                result = Math.max(result, i - start)
                start = (lastPos ?: 0) + 1
            }
            existed[char] = i
        }
        return result
    }
}

fun main() {
    arrayOf(
            "abcabcbb" to 3,
            "bbbbb" to 1,
            "pwwkew" to 3,
            "abba" to 2,
    ).forEach { (inp, exp) ->
        assertEquals(exp, Solution().lengthOfLongestSubstring(inp))
    }
}

/*
Input: s = "abcabcbb"

[abc] a => 3, a [bca...
a[bca] b => 3, ab[cab...
ab[cab] c => 3, abc[abc...
abc[abc] b => 3, abcab[cb..
abcab[cb] b => 2, abcabcb[b..



Input: s = "bbbbb"
[b] b => 1,

 */
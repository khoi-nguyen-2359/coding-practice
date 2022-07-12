package leetcode_424_Longest_Repeating_Character_Replacement

import kotlin.test.assertEquals

class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var left = 0
        var last = 0
        var currK = k
        var max = 0
        var i = 0
        while (i <= s.length) {
            if (i < s.length && s[i] != s[left]) {
                if (currK == k) {
                    last = i
                }
                currK = --currK
            }
            if (i == s.length || currK < 0) {
                max = Math.max(max, Math.min(s.length, i - left + Math.max(currK, 0)))
            }
            if (currK < 0) {
                left = last
                i = left + 1
                currK = k
            } else {
                ++i
            }
        }

        return max
    }
}

fun main() {
    arrayOf(
            "ABAB" to 2 to 4,
            "AABABBA" to 1 to 4,
            "AAAA" to 1 to 4,
            "AAAAB" to 1 to 5,
            "AAAAB" to 0 to 4,
            "ABBB" to 2 to 4,
            "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF" to 4 to 7
    ).forEach { (input, expect) ->
        assertEquals(expect, Solution().characterReplacement(input.first, input.second), input.first)
    }
}
package leetcode_5_Longest_Palindromic_Substring_2

import java.lang.Integer.max

class Solution {
    fun longestPalindrome(s: String): String {
        var max = 0
        var start = 0
        var end = 0
        for (i in s.indices) {
            // assume i is a center
            // len1: odd case
            //      i is the center:
            //          expand to left from i
            //          expand to right from i
            val len1 = expand(s, i, i)

            // len2: even case
            //      i and i + 1 are the centers
            //          expand to left from i
            //          expand to right from i + 1
            val len2 = expand(s, i, i + 1)
            val len = max(len1, len2)

            // compare len1, len2 with max len
            if (len > max) {
                max = len
                start = i - (len - 1) / 2
                end = start + len
            }
        }

        return s.substring(start, end)
    }

    private fun expand(s: String, left: Int, right: Int): Int {
        var L = left
        var R = right
        while (L >= 0 && R < s.length && s[L] == s[R]) {
            --L
            ++R
        }
        return R - L - 1
    }
}

fun main() {
    arrayOf(
            "abababa",
            "babad",
            "cbbd"
    ).forEach {
        Solution().longestPalindrome(it).let(::println)
    }
}

/*
Input: "abababa"

Input: "abaababa"
1st: L = 0, R = 1
2nd: L = -1, R = 2 => R - L - 1 = 2

Input: "abcba"
1st: L = 0, R = 0
2nd: L = -1, R = 1 => R - L - 1 = 1

 */
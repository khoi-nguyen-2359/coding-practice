package leetcode_696_Count_Binary_Substrings

import java.lang.Integer.min

class Solution {
    fun countBinarySubstrings(s: String): Int {
        var prevLen = 0
        var currLen = 0
        var result = 0
        for (i in 0..s.length) {
            if (i == 0 || i == s.length || s[i] != s[i - 1]) {
                result += min(currLen, prevLen)
                prevLen = currLen
                currLen = 1
            } else {
                ++currLen
            }
        }

        return result
    }
}
// 00 (2) 11 (2) => 2
// 00 (2) 1 (1) => 1
// 0 (1) 11 (2) => 1
fun main() {
    arrayOf(
            "00110011",
            "10101",
            "1",
            "0",
            "0100110",
    ).forEach {
        Solution().countBinarySubstrings(it).let(::println)
    }
}

/*
Input: 00110011

 */
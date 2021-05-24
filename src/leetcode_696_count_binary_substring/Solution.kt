package leetcode_696_count_binary_substring

class Solution {
    fun countBinarySubstrings(s: String): Int {
        var prevConsecLen = 0
        var currConsecLen = 0
        var counter = 0
        for (i in 0..s.length) {
            if (i == 0 || i == s.length || s[i] != s[i - 1]) {
                counter += Math.min(prevConsecLen, currConsecLen)
                prevConsecLen = currConsecLen
                currConsecLen = 0
            }

            ++currConsecLen
        }

        return counter
    }
}

fun main() {
    val res = Solution().countBinarySubstrings("10101")
    println(res)
}
package leetcode_541_reverse_string_II

import java.lang.Integer.min
import java.lang.StringBuilder

class Solution {
    fun reverseStr(s: String, k: Int): String {
        val result = StringBuilder()
        var start = 0
        var end = 0
        while (end < s.length) {
            end += k
            if (end % (2 * k) != 0) {
                result.append(s.substring(start, Integer.min(end, s.length)).reversed())
            } else {
                result.append(s.substring(start, Integer.min(end, s.length)))
            }

            start = end
        }

        return result.toString()
    }
}

fun main() {
    val content = ""
    val k = 2
    Solution().reverseStr(content, k).also {
        println(it)
    }
}
package leetcode_171_Excel_Sheet_Column_Number

import java.lang.Math.pow

class Solution {
    fun titleToNumber(columnTitle: String): Int {
        var k = 0.0
        var result = 0.0
        for (i in columnTitle.length - 1 downTo 0) {
            result += (columnTitle[i] - 64).toInt() * pow(26.0, k)
            k++
        }
        return result.toInt()
    }
}

fun main() {
    Solution().titleToNumber("A").let(::println)
}
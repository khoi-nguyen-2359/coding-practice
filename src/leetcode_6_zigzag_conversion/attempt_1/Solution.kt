package leetcode_6_zigzag_conversion.attempt_1

import java.lang.StringBuilder

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1)
            return s

        val zzLen = numRows * 2 - 2
        val result = StringBuilder()
        for (i in 0 until numRows) {
            val step1 = zzLen - 2 * i
            val step2 = 2 * i
            var j = i
            while (j < s.length) {
                result.append(s[j])

                if (j + step1 < s.length && step1 != 0 && step2 != 0) {
                    result.append(s[j + step1])
                }

                j += step1 + step2
            }
        }

        return result.toString()
    }
}
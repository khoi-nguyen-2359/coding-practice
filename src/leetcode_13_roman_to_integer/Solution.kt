package leetcode_13_roman_to_integer

class Solution {
    fun romanToInt(s: String): Int {
        val valueMap = mapOf(
                'I' to 1,
                'V' to 5,
                'X' to 10,
                'L' to 50,
                'C' to 100,
                'D' to 500,
                'M' to 1000
        )
        var result = 0
        for (i in s.indices) {
            val currVal = valueMap.getOrDefault(s[i], 0)
            if (s[i] in charArrayOf('I', 'X', 'C') && i < s.length - 1 && valueMap.getOrDefault(s[i + 1], 0) > currVal) {
                result -= currVal
            } else {
                result += currVal
            }
        }

        return result
    }
}
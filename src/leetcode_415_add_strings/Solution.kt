package leetcode_415_add_strings

class Solution {
    fun addStrings(num1: String, num2: String): String {
        val maxLen = Integer.max(num1.length, num2.length)
        var carrier = 0
        val result = CharArray(maxLen + 1)
        for (i in 0 until maxLen) {
            val n1 = num1.getOrNull(num1.length - i - 1)?.minus('0') ?: 0
            val n2 = num2.getOrNull(num2.length - i - 1)?.minus('0') ?: 0
            val s = n1 + n2 + carrier
            result[maxLen - i] = ((s % 10) + '0'.code).toChar()
            carrier = s / 10
        }

        if (carrier != 0) {
            result[0] = (carrier + '0'.code).toChar()
        } else {
            result[0] = ' '
        }
        return String(result).trim()
    }
}

fun main() {
    val num1 = "604125"
    val num2 = "055555"
    Solution().addStrings(num1, num2).also(::println)
}
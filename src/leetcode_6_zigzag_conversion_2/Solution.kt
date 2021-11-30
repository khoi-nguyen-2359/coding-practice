package leetcode_6_zigzag_conversion_2

class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val k = 2 * numRows - 2
        val result = List(numRows) { mutableListOf<Char>() }
        for (i in s.indices) {
            val j = (i % k) - ((i % k) / numRows) * ((i % k) % numRows + 1) * 2
            result[j].add(s[i])
        }
        return buildString {
            result.forEach {
                append(String(it.toCharArray()))
            }
        }
    }
}

fun main() {
    Solution().convert("PAYPALISHIRING", 2).let(::println)
}
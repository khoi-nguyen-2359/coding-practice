package leetcode_91_decode_ways.attempt_1

class Solution {
    private var memo = mutableMapOf<Int, Int>()

    fun numDecodings(s: String): Int {
        return doNumDecodings(s, 0)
    }

    private fun doNumDecodings(s: String, startIndex: Int): Int {
        if (startIndex >= s.length) {
            return 1
        }

        if (s[startIndex] !in '1'..'9') {
            return 0
        }

        memo[startIndex] ?. let {
            return it
        }

        var result = doNumDecodings(s, startIndex + 1)

        if (startIndex < s.length - 1) {
            if (s.substring(startIndex, startIndex + 2).toInt() in 10..26) {
                result += doNumDecodings(s, startIndex + 2)
            }
        }

        memo[startIndex] = result

        return result
    }
}

fun main() {
    val input = "01"
    Solution().numDecodings(input).also {
        println(it)
    }
}
package leetcode_67_add_binary

import java.lang.StringBuilder

class Solution {

    fun addBinary(a: String, b: String): String {
        val maxLen = Integer.max(a.length, b.length)
        val result = StringBuilder()
        var c = 0
        for (i in 0 until maxLen) {
            val ia = a.getOrElse(a.length - i - 1) { '0' } - '0'
            val ib = b.getOrElse(b.length - i - 1) { '0' } - '0'
            val s = when (c) {
                0 -> if (ia == ib)
                    0
                else
                    1
                else -> if (ia == ib)
                    1
                else
                    0
            }
            c = when (c) {
                0 -> if (ia == 1 && ib == 1)
                    1
                else
                    0
                else -> if (ia == 0 && ib == 0)
                    0
                else
                    1
            }
            result.insert(0, s)
        }

        if (c != 0) {
            result.insert(0, (c + '0'.code).toChar())
            return result.toString()
        }

        return result.toString()
    }
}

fun main() {
    val a = "1010"
    val b = "1011"
    Solution().addBinary(a, b).also(::println)
}
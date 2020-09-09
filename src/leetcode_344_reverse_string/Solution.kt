package leetcode_344_reverse_string

class Solution {
    fun reverseString(s: CharArray): Unit {
        for (i in 0 until s.size / 2) {
            val tmp = s[i]
            s[i] = s[s.size - i - 1]
            s[s.size - i - 1] = tmp
        }
    }
}

fun main() {
    val s = "".toCharArray()
    Solution().reverseString(s).also {
        println(s)
    }
}
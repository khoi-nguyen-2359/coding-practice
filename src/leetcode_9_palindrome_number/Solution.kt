package leetcode_9_palindrome_number

class Solution {
    private fun getDigitAt(x: Int, k: Int, i: Int): Int =
            (x / Math.pow(10.0, (k - i - 1).toDouble()).toInt()) % 10

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        var k = 0
        var rememberX = x
        while (rememberX != 0) {
            ++k
            rememberX /= 10
        }
        for (i in 0 until k / 2) {
            if (getDigitAt(x, k, i) != getDigitAt(x, k, k - i - 1)) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val res = Solution().isPalindrome(121)
    println(res)
}
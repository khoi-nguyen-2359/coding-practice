package leetcode_125_valid_palindrome.attempt_1

class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        while (i < j) {
            while (i < j && !s[i].isLetterOrDigit()) {
                ++i
            }
            while (i < j && !s[j].isLetterOrDigit()) {
                --j
            }
            if (!s[i].equals(s[j], ignoreCase = true)) {
                return false
            }
            ++i
            --j
        }

        return true
    }
}

fun main() {
    val result = Solution().isPalindrome("nurses run")
    println(result)
}
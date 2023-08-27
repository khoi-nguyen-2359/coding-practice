package leetcode_125_valid_palindrome.attempt_2

class Solution {
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            while (l < s.length && !s[l].isLetterOrDigit()) {
                ++l
            }
            while (r >= 0 && !s[r].isLetterOrDigit()) {
                --r
            }
            if (l >= r) {
                break
            }
            if (s[l].toLowerCase() != s[r].toLowerCase()) {
                return false
            }
            ++l
            --r
        }

        return true
    }
}

fun main() {
    arrayOf(
            "A man, a plan, a canal: Panama",
            "race a car",
            " ",
            ".,",
            "",
            "a.",
    ).forEach {
        Solution().isPalindrome(it).let(::println)
    }
}

/*
Input: s = "A man, a plan, a canal: Panama"
Input: s = " man  "
l = 0, r = 5 -> l = 1, r = 3 -> 0 ? 2
 */
package leetcode_5_longest_palindromic_substring

class Solution {
    fun spread(l: Int, r: Int, s: String): IntRange {
        var resL = l
        var resR = r
        while (resL - 1 >= 0 && resR + 1 < s.length && s[resL - 1] == s[resR + 1]) {
            --resL
            ++resR
        }

        return IntRange(resL, resR)
    }

    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) {
            return s
        }

        var max = 0
        var res: IntRange = IntRange(0, 0)

        for (i in s.indices) {
            var l = i
            var r = i
            if (i - 1 >= 0 && i + 1 < s.length && s[i - 1] == s[i + 1]) {
                spread(i - 1, i + 1, s).let {
                    if (it.count() > max) {
                        max = it.count()
                        res = it
                    }
                }

            }

            if (i + 1 < s.length && s[i] == s[i + 1]) {
                spread(i, i + 1, s).let {
                    if (it.count() > max) {
                        max = it.count()
                        res = it
                    }
                }
            }
        }

        return s.substring(res)
    }
}

fun main() {
    Solution().longestPalindrome("").also {
        println(it)
    }
}
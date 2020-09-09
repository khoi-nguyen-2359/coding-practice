package leetcode_186_reverse_words_in_a_string_II

class Solution {
    private fun reverseString(s: CharArray, start: Int, end: Int) {
        var left = start
        var right = end - 1
        while (left < right) {
            val tmp = s[left]
            s[left] = s[right]
            s[right] = tmp

            ++left
            --right
        }
    }

    fun reverseWords(s: CharArray) {
        reverseString(s, 0, s.size)
        var start = 0
        var end = 0
        for (i in s.indices) {
            if (s[i] == ' ' || i == s.size - 1) {
                end = if (i == s.size - 1)
                    s.size
                else
                    i

                reverseString(s, start, end)
                start = i + 1
            }
        }
    }
}

fun main() {
    val words = "toChar Array()".toCharArray()
    Solution().reverseWords(words).also {
        println(words.joinToString())
    }
}
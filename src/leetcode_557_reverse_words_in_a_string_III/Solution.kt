package leetcode_557_reverse_words_in_a_string_III

import java.lang.StringBuilder

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

    private fun reverseWords(s: CharArray) {
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

    private fun reverseString(s: String): String {
        val reversed = StringBuilder()
        for (i in s.indices) {
            reversed.append(s[s.length - i - 1])
        }
        return reversed.toString()
    }

    fun reverseWords(s: String): String {
        val words = splitWords(s)
        val result = StringBuilder()
        words.forEachIndexed { index, word ->
            result.append(reverseString(word))
            if (index != words.size - 1) {
                result.append(' ')
            }
        }
        return result.toString()
    }

    private fun splitWords(s: String): List<String> {
        val words = mutableListOf<String>()
        var start = 0
        var end = 0
        for (i in s.indices) {
            if (s[i] == ' ' || i == s.length - 1) {
                end = if (i == s.length - 1) s.length else i
                words.add(s.substring(start, end))
                start = i + 1
            }
        }

        return words
    }
}

fun main() {
    val content = "let's make some noise"
    Solution().reverseWords(content).also {
        println(it)
    }
}
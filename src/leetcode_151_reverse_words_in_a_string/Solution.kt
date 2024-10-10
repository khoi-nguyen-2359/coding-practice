package leetcode_151_reverse_words_in_a_string

import java.lang.StringBuilder
import kotlin.test.assertEquals

class Solution {
    fun reverseWords(s: String): String = s.trim()
        .split(" ")
        .filter { it.isNotBlank() }
        .reversed()
        .joinToString(" ")
}

class SolutionWithoutUtils {
    fun reverseWords(s: String): String {
        val result = StringBuilder()
        var last = -1
        var i = s.length - 1
        while (i >= 0) {
            if (s[i] != ' ' && last == -1) {
                last = i
                if (i > 0) {
                    continue
                }
            }

            if ((i == 0 || s[i] == ' ') && last != -1) {
                if (result.length > 0) {
                    result.append(' ')
                }
                val first = if (s[i] == ' ') {
                    i + 1
                } else {
                    i
                }
                var j = first
                while (j <= last) {
                    result.append(s[j])
                    ++j
                }
                last = -1
            }
            --i
        }

        return result.toString()
    }
}

fun main() {
    arrayOf(
        "a b  c   d" to "d c b a",
        "a  bc   def    " to "def bc a",
    ).forEach { (inp, outp) ->
        assertEquals(outp, SolutionWithoutUtils().reverseWords(inp))
    }
}
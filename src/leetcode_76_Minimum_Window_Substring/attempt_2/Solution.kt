package leetcode_76_Minimum_Window_Substring.attempt_2;

class Solution {
    fun minWindow(s: String, t: String): String {
        val dictionary = mutableMapOf<Char, Int>()
        t.forEach {
            dictionary[it] = (dictionary[it] ?: 0) + 1
        }
        var i = 0
        var j = 0
        var ansi = 0
        var ansj = -1
        var min = Int.MAX_VALUE
        var count = 0
        val windowChars = mutableMapOf<Char, Int>()
        do {
            if (dictionary[s[j]] != null) {
                // find the large window
                windowChars[s[j]] = (windowChars[s[j]] ?: dictionary[s[j]] ?: 0) - 1
                if (windowChars[s[j]] == 0) {
                    ++count
                }

                if (count == dictionary.size) {
                    // reduce window length by moving start point
                    do {
                        ++i
                        if (windowChars[s[i - 1]] != null) {
                            windowChars[s[i - 1]] = (windowChars[s[i - 1]] ?: 0) + 1
                        }
                    } while (windowChars[s[i - 1]] == null || (windowChars[s[i - 1]] ?: 0) <= 0)

                    // found the min length of this window, store it
                    if (windowChars[s[i - 1]] != null) {
                        --count
                        if (j - i + 2 < min) {
                            ansi = i - 1
                            ansj = j
                            min = ansj - ansi + 1
                        }
                    }
                }
            }
            ++j
        } while (j < s.length)

        return s.substring(ansi, ansj + 1)
    }
}

fun main() {
    arrayOf(
            "ABDABC" to "ABC",
            "ABDABC" to "AABC",
            "ABCDDDDDDEEAFFBC" to "ABC",
            "ABAACBAB" to "ABC",
            "ADOBECODEBANC" to "ABC",
            "a" to "aa"
    ).forEach {
        Solution().minWindow(it.first, it.second).let(::println)
    }
}
/*
Input: ABDABC | ABC
 */
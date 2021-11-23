package leetcode_28_strstr

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }

        val prefixes = prefixTable(needle)
//        prefixes.forEach(::println)
        var i = 0
        var j = 0
        while (i < haystack.length) {
            if (needle[j] == haystack[i]) {
                ++j
                ++i
                if (j == needle.length) {
                    return i - j
                }
            } else {
                if (j == 0) {
                    ++i
                } else {
                    j = prefixes[j - 1]
                }
            }
        }
        return -1
    }

    private fun prefixTable(pattern: String): IntArray {
        val prefixes = IntArray(pattern.length)
        var curr = 0
        var i = 1
        while (i < pattern.length) {
            if (pattern[curr] == pattern[i]) {
                prefixes[i] = ++curr
                ++i
            } else {
                if (curr == 0) {
                    prefixes[i++] = 0
                } else {
                    curr = prefixes[curr - 1]
                }
            }
        }
        return prefixes
    }
}

fun main() {
    Solution().strStr("mississippi", "issip").let(::println)
}
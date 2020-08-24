package leetcode_3_longest_substring_without_repeating_characters

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val mapOfChars = mutableMapOf<Char, Int>()
        var subLen = 0
        var res = 0
        var clearIndex = 0
        for (i in s.indices) {
            var charSavedIndex = mapOfChars[s[i]]
            if (charSavedIndex != null && charSavedIndex < clearIndex) {
                charSavedIndex = null
            }

            if (charSavedIndex == null) {
                ++subLen
            }

            if (charSavedIndex != null || i == s.length - 1) {
                if (subLen > res) {
                    res = subLen
                }
            }

            if (charSavedIndex != null) {
                subLen = i - charSavedIndex
                clearIndex = charSavedIndex + 1
            }

            mapOfChars[s[i]] = i
        }

        return res
    }
}

fun main() {
    Solution().lengthOfLongestSubstring("a").also {
        println(it)
    }
}
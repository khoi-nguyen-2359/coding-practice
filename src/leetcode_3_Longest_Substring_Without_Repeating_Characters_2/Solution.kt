package leetcode_3_Longest_Substring_Without_Repeating_Characters_2

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        val checkMap = mutableMapOf<Char, Int>()
        var subStart = 0
        for (i in s.indices) {
            val lastPos = checkMap[s[i]]
            if ((lastPos != null && lastPos >= subStart) || i == s.length - 1) {
                // duplicated!
                var subLen = i - subStart
                if (lastPos == null || lastPos < subStart) {
                    subLen++
                }
                if (subLen > result) {
                    result = subLen
                }
                subStart = (lastPos ?: -1) + 1
            }
            checkMap[s[i]] = i
        }
        return result
    }
}

fun main() {
    Solution().lengthOfLongestSubstring("bab").let(::println)
}

/*
Input: s = "abcabcbb"

[abc] a => 3, a [bca...
a[bca] b => 3, ab[cab...
ab[cab] c => 3, abc[abc...
abc[abc] b => 3, abcab[cb..
abcab[cb] b => 2, abcabcb[b..



Input: s = "bbbbb"
[b] b => 1,

 */
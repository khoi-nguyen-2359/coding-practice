package leetcode_14_longest_common_prefix.attempt_2

// n * min_len
class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var i = 0
        while (true) {
            var mismatched = false
            for (s in strs) {
                if (strs[0].length <= i || s.length <= i || s[i] != strs[0][i]) {
                    mismatched = true
                    break
                }
            }
            if (mismatched) {
                break
            }
            ++i
        }
        return strs[0].substring(0, i)
    }
}
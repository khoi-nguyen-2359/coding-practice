package leetcode_58_Length_of_Last_Word

class Solution {
    fun lengthOfLastWord(s: String): Int {
        var result = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i] != ' ') {
                ++result
            }
            if (s[i] != ' ' && (i == 0 || s[i - 1] == ' ')) {
                return result
            }
        }
        return result
    }
}
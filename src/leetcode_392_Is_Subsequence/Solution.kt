package leetcode_392_Is_Subsequence

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        var i = -1
        for (ti in t) {
            if (i < s.length - 1 && ti == s[i + 1]) {
                ++i
            }
        }
        return i == s.length - 1
    }
}

/*
Input: s = "abc", t = "ahbgdc"
Output: true
 */
package leetcode_205_Isomorphic_Strings

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val s2tMap = mutableMapOf<Char, Char>()
        val t2sMap = mutableMapOf<Char, Char>()
        for (i in s.indices) {
            if (s2tMap[s[i]] != null) {
                if (s2tMap[s[i]] != t[i]) {
                    return false
                }
            } else {
                if (t2sMap[t[i]] != null) {
                    return false
                }
                s2tMap[s[i]] = t[i]
                t2sMap[t[i]] = s[i]
            }
        }

        return true
    }
}

fun main() {
    Solution().isIsomorphic("egg", "baa").let(::println)
}

/*
"badc"
"baba"
 */
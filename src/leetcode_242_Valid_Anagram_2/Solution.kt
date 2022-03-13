package leetcode_242_Valid_Anagram_2

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val counters = mutableMapOf<Char, Int>()
        s.forEach {
            counters[it] = (counters[it] ?: 0) + 1
        }
        t.forEach {
            val updated = (counters[it] ?: 0) - 1
            if (updated < 0) {
                return false
            }
            counters[it] = updated
        }
        return counters.filterValues { it != 0 }.isEmpty()
    }
}

fun main() {
    Solution().isAnagram("cat", "car").let(::println)
}

/*
Input: s = "anagram", t = "nagaram"
 */
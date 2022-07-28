package leetcode_242_Valid_Anagram

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val counters = mutableMapOf<Char, Int>()
        s.forEach { c -> counters[c] = (counters[c] ?: 0) + 1 }
        var reachZero = counters.size
        t.forEach { c ->
            val counter = counters[c]
            if (counter == null || counter == 0) {
                return false
            }
            if (counter == 1) {
                --reachZero
            }
            counters[c] = counter - 1
        }

        return reachZero == 0
    }
}
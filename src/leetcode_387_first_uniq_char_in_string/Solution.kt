package leetcode_387_first_uniq_char_in_string

class Solution {
    fun firstUniqChar(s: String): Int {
        val counters = mutableMapOf<Char, Int>()
        for (i in s.indices) {
            counters[s[i]] = counters.getOrDefault(s[i], 0) + 1
        }
        for (i in s.indices) {
            if (counters[s[i]] == 1) {
                return i
            }
        }

        return -1
    }
}

fun main() {
    val res = Solution().firstUniqChar("leetcode")
    println(res)
}
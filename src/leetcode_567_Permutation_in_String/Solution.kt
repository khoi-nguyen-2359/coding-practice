package leetcode_567_Permutation_in_String

import java.lang.Integer.min

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val counter1 = mutableMapOf<Char, Int>()
        val counter2 = mutableMapOf<Char, Int>()
        for (i in 0 until min(s1.length, s2.length)) {
            counter1[s1[i]] = (counter1[s1[i]] ?: 0) + 1
            counter2[s2[i]] = (counter2[s2[i]] ?: 0) + 1
        }
        for (i in 0 .. s2.length - s1.length) {
            if (i >= 1) {
                counter2[s2[i - 1]] = (counter2[s2[i - 1]] ?: 0) - 1
                counter2[s2[i + s1.length - 1]] = (counter2[s2[i + s1.length - 1]] ?: 0) + 1
            }
            if (matches(counter1, counter2)) {
                return true
            }
        }
        return false
    }

    private fun matches(counter1: Map<Char, Int>, counter2: Map<Char, Int>): Boolean {
        counter1.forEach {
            if (counter2[it.key] != it.value) {
                return false
            }
        }
        return true
    }
}

fun main() {
    arrayOf(
            "ab" to "eidbaooo",
            "ab" to "eidboaoo",
            "abc" to "eidbcaooo",
            "a" to "ab",
            "adc" to "dcda",
    ).forEach {
        Solution().checkInclusion(it.first, it.second).let(::println)
    }
}
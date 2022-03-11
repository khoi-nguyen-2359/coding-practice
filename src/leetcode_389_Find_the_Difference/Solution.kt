package leetcode_389_Find_the_Difference

class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val counters = mutableMapOf<Char, Int>()
        s.forEach {
            counters[it] = (counters[it] ?: 0) + 1
        }

        t.forEach {
            val counter = (counters[it] ?: 0) - 1
            if (counter < 0) {
                return it
            }
            counters[it] = counter
        }

        return ' '
    }
}

class SolutionBitManipulation {
    fun findTheDifference(s: String, t: String): Char {
        var result = 0
        s.forEach {
            result = result xor it.toInt()
        }
        t.forEach {
            result = result xor it.toInt()
        }
        return result.toChar()
    }
}

fun main() {
    SolutionBitManipulation().findTheDifference("abcd", "abcde").let(::println)
}

/**
Input: s = "abcd", t = "abcde"
Output: "e"
*/
package leetcode_916_Word_Subsets

import kotlin.test.assertEquals

class SolutionBF {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val result = mutableListOf<String>()
        for (a in words1) {
            if (isUniversal(a, words2)) {
                result.add(a)
            }
        }
        return result
    }

    private fun isUniversal(a: String, words2: Array<String>): Boolean {
        for (b in words2) {
            if (!isSubset(a, b)) {
                return false
            }
        }

        return true
    }

    private fun isSubset(a: String, b: String): Boolean {
        val charCounter = mutableMapOf<Char, Int>()
        for (char in b) {
            charCounter[char] = (charCounter[char] ?: 0) + 1
        }
        var reachZero = charCounter.size
        for (char in a) {
            val count = charCounter[char] ?: 0
            if (count > 0) {
                charCounter[char] = count - 1
                if (count - 1 == 0) {
                    --reachZero
                    if (reachZero == 0) {
                        return true
                    }
                }
            }
        }

        return false
    }
}

class Solution {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val bCharMaxCounter = mutableMapOf<Char, Int>()
        for (b in words2) {
            val bCharCounter = mutableMapOf<Char, Int>()
            for (char in b) {
                val count = (bCharCounter[char] ?: 0) + 1
                bCharCounter[char] = count
                bCharMaxCounter[char] = Math.max(count, bCharMaxCounter[char] ?: 0)
            }
        }

//        println(bCharMaxCounter)

        val result = mutableListOf<String>()
        for (a in words1) {
            val aCharCounter = mutableMapOf<Char, Int>()
            for (char in a) {
                if (bCharMaxCounter.containsKey(char)) {
                    aCharCounter[char] = (aCharCounter[char] ?: 0) + 1
                }
            }
//            println(aCharCounter)
            if (aCharCounter.size == bCharMaxCounter.size && aCharCounter.all { it.value >= (bCharMaxCounter[it.key] ?: 0) }) {
                result.add(a)
            }
        }
        return result
    }
}

data class TestCase(val words1: Array<String>, val words2: Array<String>, val output: List<String>)

fun main() {
    arrayOf(
            TestCase(
                    arrayOf("amazon","apple","facebook","google","leetcode"),
                    arrayOf("e", "o"),
                    listOf("facebook", "google", "leetcode")
            ),
            TestCase(
                    arrayOf("amazon","apple","facebook","google","leetcode"),
                    arrayOf("e", "ooe"),
                    listOf("facebook", "google")
            ),
    ).forEach { (w1, w2, o) ->
        assertEquals(o, Solution().wordSubsets(w1, w2))
    }
}
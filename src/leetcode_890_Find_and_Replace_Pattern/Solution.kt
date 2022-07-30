package leetcode_890_Find_and_Replace_Pattern

import kotlin.test.assertEquals

class Solution {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val p2wMap = mutableMapOf<Char, Char>()
        val w2pMap = mutableMapOf<Char, Char>()
        val result = mutableListOf<String>()
        for (word in words) {
            p2wMap.clear()
            w2pMap.clear()
            if (isMatched(pattern, p2wMap, w2pMap, word)) {
                result.add(word)
            }
        }

        return result
    }

    private fun isMatched(pattern: String, p2wMap: MutableMap<Char, Char>, w2pMap: MutableMap<Char, Char>, word: String): Boolean {
        for (i in pattern.indices) {
            when (p2wMap[pattern[i]]) {
                null -> {
                    if (w2pMap[word[i]] != null) {
                        return false
                    }
                    p2wMap[pattern[i]] = word[i]
                    w2pMap[word[i]] = pattern[i]
                }
                word[i] -> { }
                else -> return false
            }
        }
        return true
    }
}

class SolutionNoExtraSpace {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        // encode pattern to 1,2,3 ... marker for chars. Ex: abc -> 123, abb -> 122
        // loop through each word
            // encode the word
            // compare encoded word vs. encoded pattern
        // end loop
        return emptyList()
    }
}

fun main() {
    arrayOf(
            arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc") to "abb" to listOf("mee", "aqq"),
            arrayOf("a", "b", "c") to "a" to listOf("a", "b", "c"),
    ).forEach {
        assertEquals(it.second, Solution().findAndReplacePattern(it.first.first, it.first.second))
    }
}

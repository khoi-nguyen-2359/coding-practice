package leetcode_140_Word_Break_II

import java.util.Stack

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val wordSet = HashSet(wordDict)
        val stack = Stack<Int>()
        stack.add(0)
        val result = mutableListOf<String>()
        val sentence = Stack<String>()
        while (stack.isNotEmpty()) {
            val breakIndex = stack.pop()
            if (breakIndex >= s.length) {
                // make a sentence from stack
                val sentence = buildSentence(stack, s)
                result.add(sentence)
            }
            for (i in breakIndex until s.length) {
                val word = s.substring(breakIndex, i + 1)
                if (wordSet.contains(word)) {
//                    println("add ${i + 1}")
                    stack.add(i + 1)
                }
            }
        }

        return result
    }

    private fun buildSentence(stack: Stack<Int>, s: String): String = buildString {
        var lastBreak = 0
        for (k in stack) {
//            println(k)
            append(s.substring(lastBreak, k))
            append(' ')
            lastBreak = k
        }
        removeSuffix(" ")
    }
}

fun main() {
    arrayOf(
            "catsanddog" to listOf("cat", "cats", "and", "sand", "dog"),
            "pineapplepenapple" to listOf("apple", "pen", "applepen", "pine", "pineapple"),
            "catsandog" to listOf("cats", "dog", "sand", "and", "cat"),
    ).forEach { (s, wordDict) ->
        Solution().wordBreak(s, wordDict).forEach {
            println(it)
        }
        println()
    }
}
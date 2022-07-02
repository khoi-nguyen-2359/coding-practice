package leetcode_140_Word_Break_II

import java.util.LinkedList
import java.util.Stack

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val wordSet = HashSet(wordDict)
        val stack = Stack<Node>()
        stack.add(Node(0))
        val result = mutableListOf<String>()
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            val breakIndex = top.index
            if (breakIndex >= s.length) {
                val sentence = buildSentence(top, s)
                result.add(sentence)
            }
            for (i in breakIndex until s.length) {
                val word = s.substring(breakIndex, i + 1)
                if (wordSet.contains(word)) {
                    stack.add(Node(i + 1, top))
                }
            }
        }

        return result
    }

    private fun buildSentence(node: Node, s: String): String {
        var curr: Node? = node
        val words = LinkedList<String>()
        do {
            words.add(0, s.substring(curr?.prev?.index ?: 0, curr?.index ?: 0))
            curr = curr?.prev
        } while (curr != null)
        return words.joinToString(" ").trim()
    }

    class Node(val index: Int, val prev: Node? = null)
}

class SolutionRecursive {
    private val wordSet = mutableSetOf<String>()
    private val memo = mutableMapOf<Int, MutableList<MutableList<String>>>()
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        wordSet.addAll(wordDict)
        wordBreakRecursive(s, 0)
        val ans = mutableListOf<String>()
        val sentences = memo[0] ?: return ans
        for (sentence in sentences) {
            println(sentence)
            val build = buildString {
                for (i in sentence.size - 1 downTo 0) {
                    append(sentence[i])
                    append(' ')
                }
            }
            ans.add(build.trim())
        }
        return ans
    }

    private fun wordBreakRecursive(s: String, start: Int): MutableList<MutableList<String>> {
        memo[start] ?. let {
            return it
        }

        memo[start] = if (start >= s.length) {
            mutableListOf(mutableListOf())
        } else {
            mutableListOf()
        }

        for (i in start until s.length) {
            val word = s.substring(start, i + 1)
            if (wordSet.contains(word)) {
                val subSentences = wordBreakRecursive(s, i + 1)
                for (subSent in subSentences) {
                    val cloneSent = subSent.toMutableList()
                    cloneSent.add(word)
                    memo[start]?.add(cloneSent)
                }
            }
        }

        return memo[start] ?: mutableListOf()
    }
}

fun main() {
    arrayOf(
            "catsanddog" to listOf("cat", "cats", "and", "sand", "dog"),
            "pineapplepenapple" to listOf("apple", "pen", "applepen", "pine", "pineapple"),
            "catsandog" to listOf("cats", "dog", "sand", "and", "cat"),
    ).forEach { (s, wordDict) ->
        SolutionRecursive().wordBreak(s, wordDict).forEach {
            println(it)
        }
        println()
    }
}
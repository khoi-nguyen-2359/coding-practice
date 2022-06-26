package leetcode_139_Word_Break_2

import java.util.LinkedList

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val wordHashSet = wordDict.toHashSet()
        val queue = LinkedList<Int>()
        queue.addLast(0)
        val visited = HashSet<Int>()

        while (queue.isNotEmpty()) {
            val start = queue.pollFirst()
            for (i in start until s.length) {
                val nextWord = s.substring(start, i + 1)
                if (wordHashSet.contains(nextWord) && !visited.contains(i + 1)) {
                    if (i == s.length - 1) {
                        return true
                    }
                    queue.addLast(i + 1)
                    visited.add(i + 1)
                }
            }
        }
        return false
    }
}

fun main() {
    arrayOf(
            "leetcode" to listOf("leet", "code"),
            "applepenapple" to listOf("apple", "pen"),
            "applepenapple" to listOf("apple", "pen1"),
            "aaaaaaa" to listOf("aaaa", "aaa")
    ).forEach { (s, wordDict) ->
        Solution().wordBreak(s, wordDict).let(::println)
    }
}

/*
- start breaking
- find a word in the dict
- start breaking on substring after that word
 */
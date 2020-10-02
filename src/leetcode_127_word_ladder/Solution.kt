package leetcode_127_word_ladder

import java.util.ArrayDeque

class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val queuedSet = mutableSetOf<String>()
        val wordQueue = ArrayDeque<String>()
        val stepQueue = ArrayDeque<Int>()
        wordQueue.add(beginWord)
        stepQueue.add(1)
        val adjacentWordMap = mutableMapOf<String, MutableList<String>>()
        wordList.forEach { word ->
            for (i in word.indices) {
                val genericWord = word.substring(0, i) + '?' + word.substring(i + 1)
                if (!adjacentWordMap.containsKey(genericWord)) {
                    adjacentWordMap[genericWord] = mutableListOf()
                }
                adjacentWordMap[genericWord]?.add(word)
            }
        }

        while (wordQueue.isNotEmpty()) {
            val currentWord = wordQueue.poll()
            val currentStep = stepQueue.poll()

            for (i in currentWord.indices) {
                val genericWord = currentWord.substring(0, i) + '?' + currentWord.substring(i + 1)
                for (adjacentWord in adjacentWordMap.getOrDefault(genericWord, mutableListOf())) {
                    if (queuedSet.contains(adjacentWord)) {
                        continue
                    }

                    if (adjacentWord == endWord) {
                        return currentStep + 1
                    }

                    queuedSet.add(adjacentWord)
                    wordQueue.add(adjacentWord)
                    stepQueue.add(currentStep + 1)
                }
            }
        }

        return 0
    }
}
fun main() {
    Solution().ladderLength("hit", "cog", listOf(
            "hot","dot","dog","lot","log","cog"
    )).also(::println)
}
package leetcode_734_Sentence_Similarity

class Solution {
    fun areSentencesSimilar(sentence1: Array<String>, sentence2: Array<String>, similarPairs: List<List<String>>): Boolean {
        if (sentence1.size != sentence2.size) {
            return false
        }

        val similarMap = mutableMapOf<String, MutableSet<String>>()
        similarPairs.forEach {
            similarMap[it[0]] = (similarMap[it[0]] ?: mutableSetOf()).apply {
                add(it[1])
            }
        }

        for (i in sentence1.indices) {
            if (sentence1[i] == sentence2[i]) {
                continue
            }

            val similarS1 = similarMap[sentence1[i]]
            if (similarS1?.contains(sentence2[i]) == true) {
                continue
            }

            val similarS2 = similarMap[sentence2[i]]
            if (similarS2?.contains(sentence1[i]) == true) {
                continue
            }

            return false
        }

        return true
    }
}

fun main() {
    Solution().areSentencesSimilar(
        arrayOf("great", "acting", "skills"),
        arrayOf("fine", "drama", "talent"),
        listOf(
            listOf("great", "fine"),
            listOf("drama", "acting"),
            listOf("skills", "talent")
        )
    ).let(::println)
}
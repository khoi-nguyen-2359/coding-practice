package leetcode_49_group_anagrams

import java.lang.StringBuilder

class Solution {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = mutableMapOf<String, MutableList<String>>()
        strs.forEach { word ->
            val anagramKeyBuilder = StringBuilder()
            for (c in 'a'..'z') {
                val charCount = word.count { it == c }
                anagramKeyBuilder.append('#')
                if (charCount > 0)
                    anagramKeyBuilder.append(charCount)
            }

            val anagramKey = anagramKeyBuilder.toString()
            if (groups[anagramKey] == null) {
                groups[anagramKey] = mutableListOf()
            }
            groups[anagramKey]?.add(word)
        }

        return groups.map { entry -> entry.value }
    }
}

fun main() {
    Solution().groupAnagrams(arrayOf(
            "bdddddddddd", "bbbbbbbbbbc"
    )).also(::println)
}
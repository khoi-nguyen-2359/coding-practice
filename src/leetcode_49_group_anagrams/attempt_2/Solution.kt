package leetcode_49_group_anagrams.attempt_2

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val charMapListMap = mutableMapOf<Int, MutableList<MutableMap<Char, Int>>>()
        val anagramListMap = mutableMapOf<Int, MutableList<MutableList<String>>>()
        for (s in strs) {
            val charMap = mutableMapOf<Char, Int>()
            for (c in s) {
                charMap[c] = (charMap[c] ?: 0) + 1
            }
            val charMapList = charMapListMap.computeIfAbsent(s.length) { mutableListOf() }
            val anagramGroup = anagramListMap.computeIfAbsent(s.length) { mutableListOf() }
            var isComplete = false
            for (i in charMapList.indices) {
                val map = charMapList[i]
                if (map.size == charMap.size && map.all { e -> e.value == charMap[e.key] }) {
                    anagramGroup[i].add(s)
                    isComplete = true
                    break
                }
            }

            if (!isComplete) {
                charMapList.add(charMap)
                anagramGroup.add(mutableListOf(s))
            }
        }

        return anagramListMap.flatMap { it.value }
    }
}

class SolutionGroupByKey {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagramGroupByKey = mutableMapOf<String, MutableList<String>>()
        for (s in strs) {
            val key = makeKey(s)
            val group = anagramGroupByKey.computeIfAbsent(key) { mutableListOf() }
            group.add(s)
        }
        return anagramGroupByKey.map { it.value }
    }

    private fun makeKey(s: String): String = buildString {
        val charCount = mutableMapOf<Char, Int>()
        for (c in s) {
            charCount[c] = (charCount[c] ?: 0) + 1
        }
        // key pattern: a1b2c3d0e0... <=> abcbcc etc.
        for (c in 'a'..'z') {
            val count = charCount[c] ?: 0
            append(c)
            append(count)
        }
    }
}

fun main() {
    val result1 = SolutionGroupByKey().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","batu","buta"))
    val result2 = Solution().groupAnagrams(arrayOf("a"))
}

/*
Input: strs = ["eat","tea","tan","ate","nat","bat"]

 */
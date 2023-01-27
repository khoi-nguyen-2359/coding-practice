package leetcode_49_group_anagrams_3

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groups = mutableMapOf<String, MutableList<String>>()
        strs.forEach {
            val groupKey = makeGroupKey(it)
            if (groups[groupKey] == null) {
                groups[groupKey] = mutableListOf()
            }
            groups[groupKey]?.add(it)
        }
        return groups.values.toList()
    }

    private fun makeGroupKey(str: String): String {
        val letters = Array(26) { 0 }
        str.forEach {
            letters[it-'a'] += 1
        }
        return buildString {
            letters.forEachIndexed { index, count ->
                if (count > 0) {
                    append('a' + index)
                    append(count)
                }
            }
        }
    }
}

fun main() {
    arrayOf(
        arrayOf("eat","tea","tan","ate","nat","bat") to
    )
}
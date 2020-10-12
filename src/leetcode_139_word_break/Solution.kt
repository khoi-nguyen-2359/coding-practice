package leetcode_139_word_break

class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) {
            return false
        }

        val breaks = mutableListOf(0)
        var start: Int? = 0
        var end = 1
        val wordSet = wordDict.toHashSet()
        val memo = Array(s.length) { true }
        while (start != null) {
            if (memo[start] && wordSet.contains(s.substring(start, end))) {
                breaks.add(end)

                if (end == s.length) {
                    return true
                }

                start = end
                end = start + 1
            } else {
                if (!memo[start] || end == s.length) {
                    memo[start] = false
                    end = breaks.removeAt(breaks.size - 1)
                    start = breaks.lastOrNull()
                }

                ++end
            }
        }

        return false
    }
}

fun main() {
    val wordDict = listOf("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")
    Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict).also(::println)
}
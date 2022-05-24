package leetcode_76_Minimum_Window_Substring

class Solution {
    fun minWindow(s: String, t: String): String {
        val counterMap = mutableMapOf<Char, Int>()
        t.forEach {
            counterMap[it] = (counterMap[it] ?: 0) + 1
        }
        var i = 0
        var charCount = 0
        var min = Int.MAX_VALUE
        val windowIndices = mutableListOf<Int>()
        var k = 0
        var start = 0
        var end = 0
        while (i < s.length) {
            if (counterMap.contains(s[i])) {
                counterMap[s[i]] = (counterMap[s[i]] ?: 0) - 1
                windowIndices.add(i)
                if ((counterMap[s[i]] ?: 0) >= 0) {
                    ++charCount
                }
            }

            if (charCount == t.length) {
                // reduce window len
                while ((counterMap[s[windowIndices[k]]] ?: 0) < 0) {
                    counterMap[s[windowIndices[k]]] = (counterMap[s[windowIndices[k]]] ?: 0) + 1
                    ++k
                }

                if (i - windowIndices[k] + 1 < min) {
                    min = i - windowIndices[k] + 1
                    start = windowIndices[k]
                    end = i + 1
                }

                counterMap[s[windowIndices[k]]] = (counterMap[s[windowIndices[k]]] ?: 0) + 1
                ++k // jump to the next start point

                --charCount // decrease window length
            }
            ++i
        }

        return s.substring(start, end)
    }
}

fun main() {
    arrayOf(
            arrayOf("ADOBECODEBANC", "ABC"),
            arrayOf("a", "a"),
            arrayOf("a", "aa"),
            arrayOf("bba", "ab"),
    ).forEach {
        Solution().minWindow(it[0], it[1]).let(::println)
    }
}

/*
ADO BCCAODEBA  NC

ADOBEC -> BEC : [0, 3, 5] k = 1
BEC0DEBA -> CODEBA : [0, 3, 5, 10] K = 2
 */
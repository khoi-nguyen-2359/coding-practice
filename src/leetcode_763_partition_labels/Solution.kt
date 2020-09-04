package leetcode_763_partition_labels

import java.lang.Math.max

class Solution {
    fun partitionLabels1(S: String): List<Int> {
        val traceStack = mutableListOf<Int>()
        val lastPosMap = mutableMapOf<Char, Int>()
        for (i in S.indices) {
            val lastPos = lastPosMap[S[i]]
            if (lastPos == null) {
                lastPosMap[S[i]] = i
                traceStack.add(i)
            } else {
                while (traceStack.last() > lastPos) {
                    traceStack.removeAt(traceStack.size - 1)
                }
            }
        }

        val result = mutableListOf<Int>()
        for (i in 0 until traceStack.size) {
            if (i == traceStack.size - 1) {
                result.add(S.length - traceStack[i])
            } else {
                result.add(traceStack[i + 1] - traceStack[i])
            }
        }
        return result
    }

    fun partitionLabelsGreedy(S: String): List<Int> {
        val lastPosMap = IntArray(24)
        for (i in S.indices) {
            lastPosMap[S[i] - 'a'] = i
        }

        var start = 0
        var end = 0
        val result = mutableListOf<Int>()
        for (i in S.indices) {
            end = end.coerceAtLeast(lastPosMap[S[i] - 'a'])
            if (i == end) {
                result.add(i - start + 1)
                start = i + 1
            }
        }

        return result
    }
}

fun main() {
    Solution().partitionLabelsGreedy("eccbbbbdec").also {
        it.forEach {
            println(it)
        }
    }
}
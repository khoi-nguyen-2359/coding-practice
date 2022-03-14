package leetcode_42_Trapping_Rain_Water

import java.lang.Integer.max
import java.lang.Integer.min

class Solution {
    fun trap(height: IntArray): Int {
        val stack = mutableListOf<Int>()
        val traps = mutableListOf<IntArray>()
        for (i in height.indices) {
            if (stack.isNotEmpty() && height[i] >= height[stack.last()]) {
                var last = -1
                while (stack.isNotEmpty() && height[i] >= height[stack.last()]) {
                    last = stack.removeAt(stack.lastIndex)
                }
                if (stack.isNotEmpty()) {
                    last = stack.last()
                }
                if (last != -1 && height[last] > 0) {
                    traps.add(intArrayOf(last, i))
                }
            }
            stack.add(i)
            print("stack: ")
            stack.forEach {
                print("$it ")
            }
            println()
            print("traps: ")
            traps.forEach {
                print("${it[0]} ${it[1]}  ")
            }
            println()
            println()
        }
        val mergedTraps = mergeOverlapping(traps)
        mergedTraps.forEach {
            println(it[0])
            println(it[1])
        }
        var water = 0
        mergedTraps.forEach { trap ->
            for (i in trap[0] + 1 until trap[1]) {
                water += min(height[trap[0]], height[trap[1]]) - height[i]
            }
        }

        return water
    }

    private fun mergeOverlapping(traps: List<IntArray>): List<IntArray> {
        if (traps.isEmpty()) {
            return emptyList()
        }
        val sorted = traps.sortedBy { it[0] }
        var start = sorted[0][0]
        var end = sorted[0][1]
        val merged = mutableListOf<IntArray>()
        for (i in sorted.indices) {
            if (end > sorted[i][0]) {
                start = min(start, sorted[i][0])
                end = max(end, sorted[i][1])
            } else {
                merged.add(intArrayOf(start, end))
                start = sorted[i][0]
                end = sorted[i][1]
            }

            if (i == sorted.lastIndex) {
                merged.add(intArrayOf(start, end))
            }
        }
        return merged
    }
}

fun main() {
    Solution().trap(intArrayOf(4,2,3)).let(::println)
}
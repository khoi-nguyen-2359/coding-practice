package leetcode_739_daily_temperatures

import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        return dailyTemperatures_MonopolicStack(temperatures)
    }

    private fun dailyTemperatures_BruteForce(temperatures: IntArray): IntArray {
        val answer = IntArray(temperatures.size) { 0 }
        for (i in 0 until temperatures.size - 1) {
            for (j in i + 1 until temperatures.size) {
                if (temperatures[j] - temperatures[i] > 0) {
                    answer[i] = j - i
                    break
                }
            }
        }
        return answer
    }

    private fun dailyTemperatures_MonopolicStack(temperatures: IntArray): IntArray {
        val stack: Deque<Int> = java.util.ArrayDeque()
        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                val prev = stack.pop()
                temperatures[prev] = i - prev
            }
            stack.push(i)
        }

        stack.forEach { temperatures[it] = 0 }

        return temperatures
    }
}
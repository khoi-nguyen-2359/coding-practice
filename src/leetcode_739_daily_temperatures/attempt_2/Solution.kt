package leetcode_739_daily_temperatures.attempt_2

import java.util.Stack

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val stack = Stack<Int>()
        val ans = IntArray(temperatures.size) { 0 }
        for (i in temperatures.indices) {
            while (stack.isNotEmpty()) {
                val j = stack.peek()
                if (temperatures[j] < temperatures[i]) {
                    ans[j] = i - j
                    stack.pop()
                } else {
                    break
                }
            }
            stack.push(i)
        }

        return ans
    }
}

fun main() {
    arrayOf(
        intArrayOf(73, 74, 75, 71, 69, 72, 76, 73) to intArrayOf(1,1,4,2,1,1,0,0),
        intArrayOf(3,4,5,6) to intArrayOf(1,1,1,0),
        intArrayOf(3,6,9) to intArrayOf(1,1,0)
    ).forEach {
        Solution().dailyTemperatures(it.first).forEach {
            print(it)
            print(" ")
        }
        println()
    }
}
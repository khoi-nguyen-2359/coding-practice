package leetcode_70_climb_stars

class Solution {
    private var top: Int = 0
    private val memory = mutableMapOf<Int, Int>()
    private fun countStep(n: Int): Int {
        if (n > top) {
            return 0
        }
        if (n == top) {
            return 1
        }

        val stepOne = memory[n + 1] ?: countStep(n + 1)
        val stepTwo = memory[n + 2] ?: countStep(n + 2)

        memory[n] = stepOne + stepTwo

        return stepOne + stepTwo
    }
    fun climbStairs(n: Int): Int {
        top = n
        return countStep(0)
    }
}

fun main() {
    val res = Solution().climbStairs(44)
    println(res)
}
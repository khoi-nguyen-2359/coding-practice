package leetcode_70_climb_stars.attempt_2

class Solution {
    fun climbStairs(n: Int): Int {
        when (n) {
            1 -> return 1
            2 -> return 2
        }
        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 2
        for (i in 3..n) {
            dp[i] = dp[i-1] + dp[i-2]
        }
        return dp[n]
    }
}

fun main() {
    arrayOf(1, 2, 3, 4, 5, 6).forEach {
        Solution().climbStairs(it).let(::println)
    }
}
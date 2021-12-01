package leetcode_198_house_robber

import java.lang.Integer.max

class Solution {
    private var memory: MutableList<Int> = mutableListOf()
    fun rob(nums: IntArray): Int {
        return robDP(nums)
    }

    fun rob1(nums: IntArray): Int {
        memory = MutableList(nums.size) { -1 }
        var max = 0
        for (i in nums.indices) {
            val robbed = robRecursive(nums, i)
            if (robbed > max) {
                max = robbed
            }
        }

        return max
    }

    private fun robRecursive(nums: IntArray, start: Int): Int {
        if (memory[start] != -1) {
            return memory[start]
        }
        var max = 0
        for (i in start + 2 until nums.size) {
            val robbed = robRecursive(nums, i)
            if (robbed > max) {
                max = robbed
            }
        }
        return (nums[start] + max).also {
            memory[start] = it
        }
    }

    private fun robDP(nums: IntArray): Int {
        val maxRobbed = MutableList(nums.size + 3) { 0 }
        var max = 0
        for (i in nums.size - 1 downTo 0) {
            val curr = nums[i] + max(maxRobbed[i + 2], maxRobbed[i + 3])
            println("curr=$curr")
            max = max(curr, max)
            maxRobbed[i] = curr
        }
        return max
    }
}

fun main() {
    Solution().rob(intArrayOf(2, 7, 0, 3, 1)).let(::println)
}
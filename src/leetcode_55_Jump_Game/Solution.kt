package leetcode_55_Jump_Game

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var lastReachable = nums.size - 1
        for (i in nums.size - 2 downTo 0) {
            if (i + nums[i] >= lastReachable) {
                lastReachable = i
            }
        }

        return lastReachable == 0
    }
}

fun main() {
    arrayOf(
            intArrayOf(2, 3, 1, 1, 4),
            intArrayOf(3, 2, 1, 0, 4),
    ).forEach {
        Solution().canJump(it).let(::println)
    }
}

/*
Input: nums = [2,3,1,1,4]
Output: true


 */
package leetcode_674_Longest_Continuous_Increasing_Subsequence

import kotlin.test.assertEquals

class Solution {
    fun findLengthOfLCIS(nums: IntArray): Int {
        var l = 0
        var r = 0
        var ans = 0
        while (r < nums.size) {
            if (r == nums.size - 1 || nums[r] >= nums[r + 1]) {
                ans = Math.max(ans, r - l + 1)
                l = r + 1
                r = l
            } else {
                ++r
            }
        }
        return ans
    }
}

fun main() {
    arrayOf(
            intArrayOf(1, 3, 5, 4, 7) to 3,
            intArrayOf(2, 2, 2, 2, 2) to 1,
            intArrayOf(2) to 1,
            intArrayOf(1, 2, 2, 3, 3, 4, 5, 5) to 3,
    ).forEach { (inp, exp) ->
        assertEquals(exp, Solution().findLengthOfLCIS(inp))
    }
}
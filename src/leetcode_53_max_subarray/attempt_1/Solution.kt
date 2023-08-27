package leetcode_53_max_subarray.attempt_1

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var currSum = nums[0]
        var max = nums[0]
        for (i in 1..nums.size - 1) {
            val n = nums[i]
            if (n > currSum) {
                currSum = n
            } else {
                currSum += n
            }
            if (currSum > max) {
                max = currSum
            }
        }

        return max
    }
}
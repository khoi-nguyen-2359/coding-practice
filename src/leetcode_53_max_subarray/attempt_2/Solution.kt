package leetcode_53_max_subarray.attempt_2

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var max = nums[0]
        var currSum = 0
        for (i in nums.indices) {
            currSum += nums[i]
            if (nums[i] > currSum) {
                currSum = nums[i]
            }
            if (currSum > max) {
                max = currSum
            }
        }
        return max
    }
}

// [-2,1,-3,4,-1,2,1,-5,4]
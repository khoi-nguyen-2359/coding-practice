package leetcode_1929_Concatenation_of_Array

class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val ans = IntArray(nums.size * 2)
        for (i in nums.indices) {
            ans[i] = nums[i]
            ans[i + nums.size] = nums[i]
        }
        return ans
    }
}

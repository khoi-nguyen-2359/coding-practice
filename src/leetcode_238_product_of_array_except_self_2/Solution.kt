package leetcode_238_product_of_array_except_self_2

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size) {
            result[i] = result[i - 1] * nums[i - 1]
        }

        var R = nums[nums.size - 1]
        for (i in nums.size - 2 downTo 0) {
            result[i] = result[i] * R
            R *= nums[i]
        }

        return result
    }
}
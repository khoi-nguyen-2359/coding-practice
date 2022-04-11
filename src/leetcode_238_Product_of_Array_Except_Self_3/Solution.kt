package leetcode_238_Product_of_Array_Except_Self_3

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        var product = 1
        for (i in nums.indices) {
            result[i] = product
            product *= nums[i]
        }
        product = 1
        for (i in nums.size - 1 downTo 0) {
            result[i] = result[i] * product
            product *= nums[i]
        }
        return result
    }
}

fun main() {
    Solution().productExceptSelf(intArrayOf(1,2,3,4)).forEach(::println)
}
/*
Input: nums = [1,2,3,4]
 */
package leetcode_238_product_of_array_except_self.attempt_1

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        var productAll = 1
        var zeroCount = 0
        var productExceptZero = 1
        for (i in nums.indices) {
            productAll *= nums[i]
            if (nums[i] == 0) {
                ++zeroCount
            }

            if (nums[i] != 0 || zeroCount != 1) {
                productExceptZero *= nums[i]
            }
        }

        for (i in nums.indices) {
            if (nums[i] != 0)
                nums[i] = productAll / nums[i]
            else if (zeroCount > 1)
                nums[i] = 0
            else
                nums[i] = productExceptZero
        }

        return nums
    }
}

fun main() {
    Solution().productExceptSelf(intArrayOf(0,0)).also {
        it.forEach { println(it) }
    }
}
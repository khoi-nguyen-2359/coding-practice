package leetcode_238_product_of_array_except_self.attempt_4

import kotlin.test.assertContentEquals

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        result[0] = 1
        for (i in 1 until nums.size) {
            result[i] = result[i - 1] * nums[i - 1]
        }
        var right = nums.last()
        for (i in nums.size - 2 downTo 0) {
            result[i] *= right
            right *= nums[i]
        }
        return result
    }
}

fun main() {
    // 1    2   3   4
    // 24   12  8   6
    // left:    1    1     2   6
    // right:                  6
    arrayOf(
        intArrayOf(1,2,3,4) to intArrayOf(24,12,8,6),
        intArrayOf(-1,1,0,-3,3) to intArrayOf(0,0,9,0,0),
    ).forEach { (inp, outp)->
        assertContentEquals(outp, Solution().productExceptSelf(inp))
    }
}
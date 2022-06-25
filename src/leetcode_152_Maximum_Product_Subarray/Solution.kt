package leetcode_152_Maximum_Product_Subarray

class Solution {
    fun maxProduct(nums: IntArray): Int {
        var max = nums[0]
        var currMin = nums[0]
        var currMax = nums[0]

        for (i in 1 until nums.size) {
            val tmpMax = Math.max(Math.max(currMax * nums[i], currMin * nums[i]), nums[i])
            currMin = Math.min(nums[i], Math.min(currMax * nums[i], currMin * nums[i]))
            currMax = tmpMax
            max = Math.max(max, currMax)
            println("$max $currMin $currMax")
        }

        return max
    }
}

fun main() {
    arrayOf(
            intArrayOf(2, 3, -2, 4),
            intArrayOf(2, 3, -2, 4, -1),
            intArrayOf(2, 3, -2, 4, -1, 2),
            intArrayOf(-2, 0, -1),
            intArrayOf(0, 2),
            intArrayOf(2, -5, -2, -4, 3),
    ).forEach {
        Solution().maxProduct(it).let(::println)
    }
}
/*
Input: nums = [2,3,-2,4]

 */
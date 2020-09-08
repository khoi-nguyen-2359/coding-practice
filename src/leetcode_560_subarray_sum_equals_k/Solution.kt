package leetcode_560_subarray_sum_equals_k

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val sumMap = mutableMapOf<Int, Int>()
        var count = 0
        var sum = 0
        sumMap[0] = 1
        nums.forEach { num ->
            sum += num
            sumMap[sum - k] ?. let {
                count += it
            }
            sumMap[sum] = sumMap.getOrDefault(sum, 0) + 1
        }

        return count
    }
}

fun main() {
    val nums = intArrayOf(1,1,1)
    val k = 2
    Solution().subarraySum(nums, k).also {
        println(it)
    }
}
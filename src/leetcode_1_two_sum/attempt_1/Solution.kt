package leetcode_1_two_sum.attempt_1

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val mapValToPos = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            mapValToPos[target - nums[i]]?.let { pos ->
                if (pos != i) {
                    return intArrayOf(i, pos)
                }
            }

            mapValToPos[nums[i]] = i
        }

        return intArrayOf()
    }
}

fun main() {
    Solution().twoSum(intArrayOf(1,2,3,4), 3).also {
        it.forEach {
            println(it)
        }
    }
}
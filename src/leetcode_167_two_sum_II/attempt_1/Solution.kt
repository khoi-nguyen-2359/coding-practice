package leetcode_167_two_sum_II.attempt_1

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var low = 0
        var high = nums.size - 1
        while (low < high) {
            val sum = nums[low] + nums[high]
            if (sum == target) {
                return intArrayOf(low + 1, high + 1)
            } else if (sum < target) {
                ++low
            } else {
                --high
            }
        }

        return intArrayOf()
    }
}

fun main() {
    Solution().twoSum(intArrayOf(1, 2, 3, 4), 3).also {
        it.forEach {
            println(it)
        }
    }
}
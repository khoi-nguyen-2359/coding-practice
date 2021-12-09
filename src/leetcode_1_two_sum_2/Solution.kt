package leetcode_1_two_sum_2

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val memory = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, n ->
            if (memory.contains(target - n)) {
                return intArrayOf(memory[target - n] ?: 0, index)
            }
            memory[n] = index
        }

        return intArrayOf()
    }
}
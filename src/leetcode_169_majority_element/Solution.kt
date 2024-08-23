package leetcode_169_majority_element

class Solution {
    fun majorityElement(nums: IntArray): Int {
        val counters = mutableMapOf<Int, Int>()
        var max = 0
        var majority = 0
        for (n in nums) {
            val newCount = (counters[n] ?: 0) + 1
            counters[n] = newCount
            if (newCount > max) {
                majority = n
                max = newCount
            }
        }

        return majority
    }
}

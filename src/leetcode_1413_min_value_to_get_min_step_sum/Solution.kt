package leetcode_1413_min_value_to_get_min_step_sum

class Solution {
    fun minStartValue(nums: IntArray): Int {
        var min = Integer.MAX_VALUE
        var stepSum = 0
        nums.forEach { n ->
            stepSum += n
            if (stepSum < min) {
                min = stepSum
            }
        }
        return (1 - min).coerceAtLeast(1)
    }
}
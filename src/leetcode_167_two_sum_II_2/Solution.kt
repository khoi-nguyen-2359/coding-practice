package leetcode_167_two_sum_II_2

class Solution {
    fun twoSumII(numbers: IntArray, target: Int): IntArray {
        val helper = mutableMapOf<Int, Int>()
        numbers.forEachIndexed { index, n ->
            helper[n] = index
        }
        numbers.forEachIndexed { index, n ->
            val h = helper[target - n]
            if (h != null) {
                return if (index < h) {
                    intArrayOf(index + 1, h + 1)
                } else {
                    intArrayOf(h + 1, index + 1)
                }
            }
        }
        return intArrayOf()
    }
}
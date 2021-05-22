package leetcode_453_min_moves_to_equal_array_elements


class Solution {
    fun minMoves(nums: IntArray): Int {
        var moves = 0
        var min = Int.MAX_VALUE
        for (i in nums.indices) {
            min = min.coerceAtMost(nums[i])
        }
        for (i in nums.indices) {
            moves += nums[i] - min
        }
        return moves
    }
}

fun main() {
    val move = Solution().minMoves(intArrayOf(1, 2, 3))
    println(move)
}
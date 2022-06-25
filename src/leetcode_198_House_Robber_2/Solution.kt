package leetcode_198_House_Robber_2

class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        var max = Math.max(nums[0], nums[1])
        nums[1] = max
        for (i in 2 until nums.size) {
            if (nums[i] + nums[i - 2] > max) {
                max = nums[i] + nums[i - 2]
            }
            nums[i] = max
        }
        return max
    }
}

fun main() {
    arrayOf(
            intArrayOf(7, 2, 3, 1, 1, 2, 3, 0),
            intArrayOf(2, 7, 9, 3, 1),
            intArrayOf(1, 2, 3, 1),
            intArrayOf(2, 1, 1, 2),
    ).forEach {
        Solution().rob(it).let(::println)
    }
}

/*
Input:
nums = [7,2,3, 1, 1, 2, 3, 0]
max =  [7,2,10,10,11,12,14,14]

2   1   1   2
2   1   3   3
 */
package leetcode_704_Binary_Search

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l <= r) {
            val m = (l + r) / 2
            if (target == nums[m]) {
                return m
            }
            if (target < nums[m]) {
                r = m - 1
            } else {
                l = m + 1
            }
        }
        return -1
    }
}

fun main() {
    Solution().search(
            intArrayOf(-1,0,3,5,9,12),
            target = 9
    ).let(::println)
}

/*
Input: nums = [-1,0,3,5,9,12], target = 9

 */
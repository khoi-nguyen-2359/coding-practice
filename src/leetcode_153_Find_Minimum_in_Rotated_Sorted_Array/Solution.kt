package leetcode_153_Find_Minimum_in_Rotated_Sorted_Array

class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        var m: Int
        while (l <= r) {
            m = (l + r) / 2
            if (m < nums.size - 1 && nums[m] > nums[m + 1]) {
                return nums[m + 1]
            }
            if (m == 0) {
                return nums[0]
            }
            if (nums[l] > nums[m]) {
                r = m
            } else if (nums[m] > nums[r]) {
                l = m
            } else if (nums[l] < nums[m]) {
                r = m
            }
        }
        return -1
    }
}

fun main() {
    arrayOf(
            intArrayOf(3,4,0,1,2,3),
            intArrayOf(3,4,5,6,7,0,1),
            intArrayOf(3,4,5,6,7),
            intArrayOf(2,1),
            intArrayOf(3,4),
            intArrayOf(),
    ).forEach {
        Solution().findMin(it).let(::println)
    }
}

/*
Input: nums = [3,4,5,6,7,0,1]
left > mid -> right = mid
mid > right -> left = mid
left < mid -> right = mid
 */
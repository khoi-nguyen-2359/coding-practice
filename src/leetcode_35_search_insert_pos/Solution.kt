package leetcode_35_search_insert_pos

class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var low = 0
        var high = nums.size - 1
        var mid: Int
        var pivot: Int = -1
        while (low <= high) {
            mid = (low + high) / 2
            if (target > nums[mid]) {
                low = mid + 1
                pivot = low
            } else if (target < nums[mid]) {
                high = mid - 1
                pivot = mid
            } else {
                return mid
            }
        }

        return pivot
    }
}

fun main() {
    Solution().searchInsert(intArrayOf(1,3,5,6), 2).let(::println)
}
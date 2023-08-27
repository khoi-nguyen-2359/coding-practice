package leetcode_33_search_in_rotated_sorted_array.attempt_1

class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val pivot = searchPivot(nums)
        println(pivot)
        var index = - 1
        if (pivot == -1) {
            index = nums.binarySearch(target, 0, nums.size)
            if (index >= 0)
                return index

            return -1
        }

        index = nums.binarySearch(target, 0, pivot)
        if (index >= 0)
            return index

        index = nums.binarySearch(target, pivot, nums.size)
        if (index >= 0)
            return index

        return -1
    }

    private fun searchPivot(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        var m: Int
        while (l <= r) {
            m = (l + r) / 2
            if (nums[m] >= nums[l]) {
                if (m == nums.size - 1) {
                    return l
                }

                if (nums[m] <= nums[m + 1]) {
                    l = m + 1
                    continue
                }

                return m + 1
            }

            if (nums[m] <= nums[r]) {
                if (m == 0 || nums[m] < nums[m - 1]) {
                    return m
                }

                r = m - 1
                continue
            }
        }

        return -1
    }
}

fun main() {
    val nums = intArrayOf(3,4,5,6,1,2)
    val target = 3
    Solution().search(nums, target).also(::println)
}
package leetcode_33_search_in_rotated_sorted_array.attempt_2

class Solution {
    fun search(nums: IntArray, target: Int): Int {
//        1. if a is not rotated, do binary search on original array
        if (nums[0] <= nums[nums.size - 1]) {
            return binarySearch(nums, 0, nums.size - 1, target)
        }

//        2. if a is rotated, use binary search to find k
//        a[l] < a[m] -> find the end points on the right of a[m]
//        a[l] > a[m] -> find the end points on the left of a[m]
        val k = binarySearchPivotPoint(nums)
//        println("k=$k")
        if (k == -1) {
            return -1
        }

        // binary search on the left part
        val foundLeft = binarySearch(nums, 0, nums.size - k - 1, target)
//        println("found left =$foundLeft")
        if (foundLeft != -1) {
            return foundLeft
        }

        // binary search on the right part
        return binarySearch(nums, nums.size - k, nums.size - 1, target)
    }

    private fun binarySearchPivotPoint(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        var mid: Int
        while (left < right) {
            mid = (left + right) / 2
            if (left == right - 1 && nums[left] > nums[right]) {
                return nums.size - right
            }
            if (nums[left] < nums[mid]) {
                left = mid
            } else {
                right = mid
            }
        }
        return -1
    }


    private fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
        var left = start
        var right = end
        var mid: Int
        while (left <= right) {
            mid = (left + right) / 2
            if (target < nums[mid]) {
                right = mid - 1
            } else if (target > nums[mid]) {
                left = mid + 1
            } else {
                return mid
            }
        }
        return -1
    }
}

fun main() {
    arrayOf(
            intArrayOf(4,5,6,7,0,1,2) to 0,
            intArrayOf(4,5,6,7,0,1,2) to 3,
            intArrayOf(4,5,6,7,8,1,2) to 8,
            intArrayOf(4,5,6,7,0,1,2) to 5,
    ).forEach { (nums, target) ->
        Solution().search(nums, target).let(::println)
    }
}
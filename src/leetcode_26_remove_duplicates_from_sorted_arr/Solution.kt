package leetcode_26_remove_duplicates_from_sorted_arr

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var k = 0
        for (i in 1 until nums.size) {
            if (nums[i] == nums[i - 1]) {
                ++k
            } else {
                nums[i - k] = nums[i]
            }
        }
        return k
    }
}
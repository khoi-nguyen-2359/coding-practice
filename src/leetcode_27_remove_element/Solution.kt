package leetcode_27_remove_element

class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        for (j in nums.indices) {
            if (nums[j] != `val`) {
                nums[i++] = nums[j]
            }
        }
        return i
    }
}

fun main() {
    val nums = intArrayOf(6)
    Solution().removeElement(nums, 6).let(::println)
    nums.forEach { println(it) }
}
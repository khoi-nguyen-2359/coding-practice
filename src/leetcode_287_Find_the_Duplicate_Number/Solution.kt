package leetcode_287_Find_the_Duplicate_Number

/**
 * Linear time
 * no extra space
 * modify input
 */
class Solution1 {
    fun findDuplicate(nums: IntArray): Int {
        var k = 0
        while (true) {
            if (nums[k] < 0) {
                ++k
                continue
            }
            val nextK = nums[k] - 1
            if (nums[nextK] < 0) {
                if (nums[nextK] == - nums[k]) {
                    return nums[k]
                } else {
                    ++k
                    continue
                }
            } else {
                val tmp = nums[k]
                nums[k] = nums[nextK]
                nums[nextK] = - tmp
            }
        }
    }
}

// 3 2 4 1 3
// 4 2 -3 1 3
// 1 2 -3 -4 3
// -1 -2 -3 -4 3

fun main() {
    arrayOf(
        intArrayOf(1,3,4,2,2) to 2,
        intArrayOf(3,1,3,4,2) to 3,
        intArrayOf(3,2,4,1,4) to 4
    ).forEach { (inp, _) ->
        Solution1().findDuplicate(inp).let(::println)
    }
}
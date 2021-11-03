package leetcode_75_sort_colors

class Solution {
    fun sortColors(nums: IntArray) {
        val counters = mutableMapOf(
                0 to 0,
                1 to 0,
                2 to 0
        )

        nums.forEach { n ->
            counters[n] = counters.getOrDefault(n, 0) + 1
        }

        for (i in nums.indices) {
            val counter = counters.entries.first { it.value > 0 }
            nums[i] = counter.key
            counters[counter.key] = counter.value - 1
        }
    }

    fun sortColorsOnePass(nums: IntArray) {
        var pos0 = -1
        var pos2 = nums.size

        var i = 0
        while (i < nums.size) {
            when {
                nums[i] == 2 && i < pos2 -> {
                    pos2 -= 1
                    val tmp = nums[i]
                    nums[i] = nums[pos2]
                    nums[pos2] = tmp
                }

                nums[i] == 0 && i > pos0 -> {
                    pos0 += 1
                    val tmp = nums[i]
                    nums[i] = nums[pos0]
                    nums[pos0] = tmp
                }

                else -> ++i
            }
        }
    }
}

fun main() {
    val nums = intArrayOf(1)
    Solution().sortColorsOnePass(nums)
    nums.forEach { print(it) }
}
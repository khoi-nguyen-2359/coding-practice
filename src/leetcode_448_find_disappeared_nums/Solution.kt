package leetcode_448_find_disappeared_nums

class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val list = MutableList(nums.size) { it + 1 }
        nums.forEach { n ->
            list[n-1] = -1
        }
        return list.filter { it != -1 }
    }
}

fun main() {
    Solution().findDisappearedNumbers(intArrayOf(1, 2, 2, 1)).let(::println)
}
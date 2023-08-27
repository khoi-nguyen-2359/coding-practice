package leetcode_11_Container_With_Most_Water.attempt_3

import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0
        while (left < right) {
            val area = (right - left) * min(height[left], height[right])
            if (area > max) {
                max = area
            }
            if (height[left] < height[right]) {
                ++left
            } else {
                --right
            }
        }
        return max
    }
}

fun main() {
    arrayOf(
        intArrayOf(1,8,6,2,5,4,8,3,7),
        intArrayOf(1,1),
        intArrayOf(2,3,10,5,7,8,9),
        intArrayOf(2,3,4,5,18,17,6)
    ).forEach {
        Solution().maxArea(it).let(::println)
    }
}
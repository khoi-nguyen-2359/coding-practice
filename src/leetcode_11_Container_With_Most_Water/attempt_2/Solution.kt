package leetcode_11_Container_With_Most_Water.attempt_2

import java.lang.Integer.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var result = 0
        while (l < r) {
            val amount = (r - l) * min(height[l], height[r])
            if (amount > result) {
                result = amount
            }
            if (height[l] < height[r]) {
                ++l
            } else {
                --r
            }
        }

        return result
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

/*
Input: height = [1,8,6,2,5,4,8,3,7]

1,7 -> 8 => 8
=> move left => 8,7 -> 49 => 49
=> move right => 8,3 -> 18 => [X]
=> move right => 8,8 -> 40 => [X]
=> move right => 8,4 -> 16 => [X]
=> move right => 8,5 -> 15 => [X]
=> move right => 8,2 -> 4 => [X]
=> move right => 8,6 -> 6 => [X] => STOP


 */
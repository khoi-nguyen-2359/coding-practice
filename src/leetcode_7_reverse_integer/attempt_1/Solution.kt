package leetcode_7_reverse_integer.attempt_1

class Solution {
    fun reverse(x: Int): Int {
        var current = x
        var reversed = 0
        while (current != 0) {
            val pop = current % 10
            current /= 10

            if ((reversed > Int.MAX_VALUE / 10 || (reversed == Int.MAX_VALUE / 10 && pop > 7))
                    || (reversed < - Int.MAX_VALUE / 10 || (reversed == - Int.MAX_VALUE / 10 && pop < -8)))
                return 0

            reversed = reversed * 10 + pop
        }

        return reversed
    }
}

fun main() {
    Solution().reverse(1534236469).also(::println)
}
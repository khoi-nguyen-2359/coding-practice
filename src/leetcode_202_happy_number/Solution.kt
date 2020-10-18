package leetcode_202_happy_number

class Solution {
    private fun happilySum(num: Int): Int {
        var current = num
        var sum = 0
        while (current != 0) {
            sum += (current % 10) * (current % 10)
            current /= 10
        }

        return sum
    }

    fun isHappy(n: Int): Boolean {
        var current = n
        val isExists = mutableSetOf<Int>()
        while (current != 1) {
            current = happilySum(current)
            println(current)
            if (isExists.contains(current)) {
                return false
            }

            isExists.add(current)
        }
        
        return true
    }
}

fun main() {
    Solution().isHappy(12).also(::println)
}
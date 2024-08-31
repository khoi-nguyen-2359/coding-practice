package leetcode_202_happy_number_2

/**
 * Implement a loop in which each step is to sum all squares of the digits.
 * If the sum equals to 1, return that the input is a happy number.
 * Otherwise, continue the loop until running into an old sum value to conclude input is not a happy number.
 */
class Solution {
    fun isHappy(n: Int): Boolean {
        var i = n
        val seen = mutableSetOf<Int>()
        seen.add(n)
        while (true) {
            var sum = 0
            while (i != 0) {
                val d = i % 10
                sum += d * d
                i /= 10
            }
//            println(sum)
            if (sum == 1) {
                return true
            }
            if (seen.contains(sum)) {
                return false
            }
            seen.add(sum)
            i = sum
        }
    }
}

fun main() {
    for (i in 1..100) {
        val res = Solution().isHappy(i)
        println("$i: $res")
    }
}
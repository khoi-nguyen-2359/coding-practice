package leetcode_1342_Number_of_Steps_to_Reduce_a_Number_to_Zero

class Solution {
    fun numberOfSteps(num: Int): Int {
        var curr = num
        var result = 0
//        println(curr)
        while (curr != 0) {
            if (curr % 2 == 0) {
                curr /= 2
            } else {
                --curr
            }
//            println(curr)
            ++result
        }

        return result
    }
}

fun main() {
    Solution().numberOfSteps(27).let(::println)
}
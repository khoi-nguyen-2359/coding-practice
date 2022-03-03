package leetcode_1688_Count_of_Matches_in_Tournament

class Solution {
    fun numberOfMatches(n: Int): Int {
        var curr = n
        var result = 0
        while (curr > 1) {
            if (curr % 2 == 0) {
                result += curr / 2
                curr /= 2
            } else {
                result += (curr - 1) / 2
                curr = (curr - 1) / 2 + 1
            }
        }
        return result
    }
}

fun main() {
    Solution().numberOfMatches(7).let(::println)
}
package leetcode_1431_kids_with_the_greatest_number_of_candies

class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        var max = 0
        for (c in candies) {
            if (c >= max) {
                max = c
            }
        }
        return candies.map { it + extraCandies >= max }
    }
}
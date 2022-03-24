package leetcode_881_Boats_to_Save_People


class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var i = 0
        var j = people.size - 1
        var boat = 0
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                ++i
            }
            --j
            ++boat
        }
        return boat
    }
}

fun main() {
    Solution().numRescueBoats(
            intArrayOf(8, 3, 8, 3, 10, 2, 9, 1, 3, 6, 6, 4, 2, 3, 3, 8, 10, 6, 1, 8, 4, 4, 6, 3, 10, 2, 5, 3, 6, 6, 7, 6, 5, 7, 5, 8, 8, 3, 4, 7, 2, 7, 4, 6, 2, 7, 4, 5, 5, 5, 7, 4, 7, 1, 4, 8, 1, 7, 1, 5, 9, 1, 6, 1, 9, 7, 8, 7, 1, 1, 7, 10, 9, 7, 8, 3, 8, 3, 2, 5, 4, 2, 5, 9, 5, 5, 8, 6, 2, 10, 5, 8, 4, 9, 4, 3, 2, 10, 6, 1),
            10,
    ).let(::println)
}

/*
5 5 3 1     |   7
5 4 3 3     |   5
 */
package leetcode_1560_Most_Visited_Sector_in_a_Circular_Track

class Solution {
    fun mostVisited(n: Int, rounds: IntArray): List<Int> {
        var i = 0
        var c = rounds[0] - 1
        val counters = mutableMapOf<Int, Int>()
        var max = 0
        while (i < rounds.size) {
            counters[c + 1] = (counters[c + 1] ?: 0) + 1
            if (max < (counters[c + 1] ?: 0)) {
                max = counters[c + 1] ?: 0
            }
            if (c + 1 == rounds[i]) {
                ++i
            }
            c = (c + 1) % n
        }
        return counters.filterValues { it == max }.keys.sorted()
    }
}

fun main() {
    Solution().mostVisited(5, intArrayOf(3, 2)).let(::println)
}
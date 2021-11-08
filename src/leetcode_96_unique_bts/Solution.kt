package leetcode_96_unique_bts

class Solution {
    private var remember: IntArray = intArrayOf()
    fun numTrees(n: Int): Int {
        remember = IntArray(n + 1) { index ->
            when (index) {
                0, 1 -> 1
                else -> 0
            }
        }
        return numTreesRecursive(n)
    }
    private fun numTreesRecursive(n: Int): Int {
        val rem = remember[n]
        if (rem != 0) {
            return rem
        }

        println("??$n: 0")
        var sum = 0
        for (i in 1..n) {
            val rootIResult = numTreesRecursive(i - 1) * numTreesRecursive(n - i)
            sum += rootIResult
        }

        remember[n] = sum
        println("!!$n: $sum")

        return sum
    }
}

fun main() {
    Solution().numTrees(8).let(::println)
}
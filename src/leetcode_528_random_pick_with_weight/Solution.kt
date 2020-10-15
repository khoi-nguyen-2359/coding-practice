package leetcode_528_random_pick_with_weight

class Solution(w: IntArray) {

    private val totalSum: Int
    private val prefixSums = IntArray(w.size)

    init {
        var sum = 0
        w.forEachIndexed { index, item ->
            sum += item
            prefixSums[index] = sum
        }

        this.totalSum = sum
    }

    fun pickIndex(): Int {
        val target = totalSum * Math.random()
        var low = 0
        var hight = prefixSums.size
        while (low < hight) {
            val mid = (hight + low) / 2
            if (target > prefixSums[mid]) {
                low = mid + 1
            } else {
                hight = mid
            }
        }

        return low
    }
}

fun main() {
    val solution = Solution(intArrayOf(1, 3))
    solution.pickIndex().also(::println)
    solution.pickIndex().also(::println)
    solution.pickIndex().also(::println)
    solution.pickIndex().also(::println)
}
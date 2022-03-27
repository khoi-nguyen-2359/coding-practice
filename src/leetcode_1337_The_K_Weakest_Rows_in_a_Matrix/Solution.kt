package leetcode_1337_The_K_Weakest_Rows_in_a_Matrix

import java.util.PriorityQueue

class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val priorityQueue = PriorityQueue<Pair<Int, Int>> { i1, i2 ->
            val diff = i1.second - i2.second
            if (diff == 0) {
                i1.first - i2.first
            } else {
                diff
            }
        }
        for (i in mat.indices) {
            val split = binarySearchTheFirstZero(mat[i])
            println("$i $split")
            priorityQueue.add(i to split)
        }
        return IntArray(k) { priorityQueue.poll().first }
    }

    private fun binarySearchTheFirstZero(input: IntArray): Int {
        var l = 0
        var r = input.size
        while (l < r) {
            val m = (l + r) / 2
            if (input[m] == 1) {
                l = m + 1
            } else {
                r = m
            }
        }
        return l
    }
}

fun main() {
//    Solution().kWeakestRows(
//            arrayOf(
//                    intArrayOf(1,1,0,0,0),
//                    intArrayOf(1,1,1,1,0),
//                    intArrayOf(1,0,0,0,0),
//                    intArrayOf(1,1,0,0,0),
//                    intArrayOf(1,1,1,1,1),
//            ),
//            3
//    ).forEach(::println)

    Solution().kWeakestRows(
            arrayOf(
                    intArrayOf(1,0),
                    intArrayOf(0,0),
                    intArrayOf(1,0),
            ),
            2
    ).forEach(::println)
}
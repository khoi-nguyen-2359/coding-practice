package leetcode_417_Pacific_Atlantic_Water_Flow

import java.util.LinkedList
import java.util.Queue
import kotlin.test.assertEquals

class Solution {
    private val directions = arrayOf(
            arrayOf(1, 0), // down
            arrayOf(-1, 0), // up
            arrayOf(0, 1), // right
            arrayOf(0, -1) // left
    )

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val results = mutableListOf<List<Int>>()
        for (i in heights.indices) {
            for (j in heights[i].indices) {
                if (canFlow(heights, i, j)) {
                    results.add(listOf(i, j))
                }
            }
        }

        return results
    }

    private fun canFlow(heights: Array<IntArray>, r: Int, c: Int): Boolean {
        val oceans = Array(2) { false }
        val queue = LinkedList<Pair<Int, Int>>()
        queue.addLast(r to c)
        val visited = mutableSetOf<Pair<Int, Int>>()
        visited.add(r to c)
        while (queue.isNotEmpty()) {
            val (ri, ci) = queue.pollFirst()
            if (ri == 0 || ci == 0) {
                oceans[0] = true
            }
            if (ri == heights.size - 1 || ci == heights[ri].size - 1) {
                oceans[1] = true
            }

            if (heights[ri][ci] < 0 || (oceans[0] && oceans[1])) {
                heights[r][c] = -heights[r][c]
                return true
            }

            // flow to lower neighbor cells:
            for (d in directions) {
                val rNext = ri + d[0]
                val cNext = ci + d[1]
                if (!visited.contains(rNext to cNext) &&
                        rNext >= 0 &&
                        rNext < heights.size &&
                        cNext >= 0 &&
                        cNext < heights[rNext].size &&
                        Math.abs(heights[rNext][cNext]) <= Math.abs(heights[ri][ci])
                ) {
                    // return early if there's a neighbor can flow
                    if (heights[rNext][cNext] < 0) {
                        return true
                    }
                    queue.addLast(rNext to cNext)
                    visited.add(rNext to cNext)
                }
            }
        }

        return false
    }
}

class SolutionStartFromOceans {
    private val directions = arrayOf(
            arrayOf(1, 0), // down
            arrayOf(-1, 0), // up
            arrayOf(0, 1), // right
            arrayOf(0, -1) // left
    )

    private var n = 0
    private var m = 0
    private val result = mutableListOf<List<Int>>()
    private lateinit var marker: Array<Array<Boolean>>

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        n = heights.size
        m = heights[0].size
        marker = Array(n) { Array(m) { false } }
        val pacificOcean = LinkedList<Pair<Int, Int>>()
        val atlanticOcean = LinkedList<Pair<Int, Int>>()
        for (r in 0 until n) {
            pacificOcean.addLast(r to 0)
            atlanticOcean.addLast(r to m - 1)
        }
        for (c in 1..m - 2) {
            pacificOcean.addLast(0 to c)
            atlanticOcean.addLast(n - 1 to c)
        }
        if (m > 1) {
            pacificOcean.addLast(0 to m - 1)
            atlanticOcean.addLast(n - 1 to 0)
        }
        bfs(heights, pacificOcean)
        bfs(heights, atlanticOcean)
        return result
    }

    private fun bfs(heights: Array<IntArray>, queue: Queue<Pair<Int, Int>>) {
        val visited = mutableSetOf<Int>()
        queue.forEach { visited.add(it.first * m + it.second) }
        while (queue.isNotEmpty()) {
            val (r, c) = queue.poll()
            if (marker[r][c]) {
                result.add(listOf(r, c))
            } else {
                marker[r][c] = true
            }
            for (d in directions) {
                val rNext = r + d[0]
                val cNext = c + d[1]
                if (!visited.contains(rNext * m + cNext) &&
                        rNext >= 0 &&
                        cNext >= 0 &&
                        rNext < n &&
                        cNext < m &&
                        Math.abs(heights[rNext][cNext]) >= Math.abs(heights[r][c])
                ) {
                    visited.add(rNext * m + cNext)
                    queue.add(rNext to cNext)
                }
            }
        }
    }
}

fun main() {
    arrayOf(
            arrayOf(
                    intArrayOf(1)
            ) to listOf(listOf(0, 0)),
            arrayOf(
                    intArrayOf(3, 3, 3),
                    intArrayOf(3, 1, 3),
                    intArrayOf(0, 2, 4),
            ) to listOf(listOf(0, 0),listOf(0, 1),listOf(0, 2),listOf(1, 0),listOf(1, 2),listOf(2, 0),listOf(2, 1),listOf(2, 2)),
            arrayOf(
                    intArrayOf(0),
                    intArrayOf(9),
                    intArrayOf(4),
            ) to listOf(listOf(0, 0),listOf(1, 0),listOf(2, 0)),
    ).forEach { (input, exp) ->
        assertEquals(exp.toSet(), SolutionStartFromOceans().pacificAtlantic(input).toSet())
    }
}
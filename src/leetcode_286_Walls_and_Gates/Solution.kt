package leetcode_286_Walls_and_Gates

class Solution {
    private val directions = arrayOf(
            0 to 1,
            1 to 0,
            0 to -1,
            -1 to 0
    )

    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        val n = rooms.size
        val m = rooms[0].size
        /*
        1. set gates as start points of bfs: add gate positions to queue
         */
        var queue = mutableListOf<Int>()
        for (i in rooms.indices) {
            for (j in rooms[i].indices) {
                if (rooms[i][j] == 0) {
                    queue.add(i * m + j)
                }
            }
        }

        /*
        2. bfs
         */
        while (queue.isNotEmpty()) {
            val nextLevelQueue = mutableListOf<Int>()

            for (cell in queue) {
                val r = cell / m
                val c = cell % m
                for ((dr, dc) in directions) {
                    val rNext = r + dr
                    val cNext = c + dc
                    if (rNext in 0 until n && cNext in 0 until m && rooms[rNext][cNext] > rooms[r][c] + 1) {
                        rooms[rNext][cNext] = rooms[r][c] + 1
                        nextLevelQueue.add(rNext * m + cNext)
                    }
                }
            }
            queue = nextLevelQueue
        }
    }
}

fun main() {
    arrayOf(
            arrayOf(intArrayOf(2147483647, -1, 0, 2147483647),
                    intArrayOf(2147483647, 2147483647, 2147483647, -1),
                    intArrayOf(2147483647, -1, 2147483647, -1),
                    intArrayOf(0, -1, 2147483647, 2147483647)
            )
    ).forEach { input ->
        Solution().wallsAndGates(input)
    }
}
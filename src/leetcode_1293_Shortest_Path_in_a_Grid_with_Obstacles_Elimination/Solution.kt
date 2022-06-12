package leetcode_1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination

import java.util.LinkedList
import java.util.PriorityQueue


class Solution {
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val queue = LinkedList<State>()
        val initState = State(0, 0, 0, k)
        queue.addLast(initState)
        val seens = mutableSetOf<State>()
        seens.add(initState)
        val moves = intArrayOf(0,1,1,0,0,-1,-1,0)
        val m = grid.size
        val n = grid[0].size

        while (queue.isNotEmpty()) {
            val currState = queue.pollFirst()
            if (currState.row == m - 1 && currState.col == n - 1) {
                return currState.step
            }

            for (x in moves.indices step 2) {
                val nexti = currState.row + moves[x]
                val nextj = currState.col + moves[x + 1]
                if (nexti < 0 || nextj < 0 || nexti == m || nextj == n) {
                    continue
                }
                val nextk = currState.k - grid[nexti][nextj]
                val nextState = State(currState.step + 1, nexti, nextj, nextk)
                if (nextk < 0 || seens.contains(nextState)) {
                    continue
                }
                seens.add(nextState)
                queue.addLast(nextState)
            }
        }
        return -1
    }

    private class State(
            val step: Int,
            val row: Int,
            val col: Int,
            val k: Int
    ) {
        /**
         * only (row, col, k) matters as the state info
         */
        override fun hashCode(): Int {
            return (row + 1) * (col + 1) * k
        }

        override fun equals(other: Any?): Boolean {
            if (other !is State) {
                return false
            }
            return row == other.row && col == other.col && k == other.k
        }
    }
}

class SolutionAStar {
    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val queue = PriorityQueue<State>()
        val seens = mutableSetOf<State>()
        val startState = State(m, n, 0, 0, 0, k)
        queue.add(startState)
        seens.add(startState)
        val moves = intArrayOf(0,1,1,0,0,-1,-1,0)
        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            if (curr.estimation - curr.steps <= curr.k) {
                return curr.estimation
            }

            for (x in moves.indices step 2) {
                val nextRow = curr.row + moves[x]
                val nextCol = curr.col + moves[x + 1]
                if (nextRow < 0 || nextRow == m || nextCol < 0 || nextCol == n) {
                    continue
                }

                val nextK = curr.k - grid[nextRow][nextCol]
                val nextState = State(m, n, curr.steps + 1, nextRow, nextCol, nextK)
                if (nextK < 0 || seens.contains(nextState)) {
                    continue
                }
                seens.add(nextState)
                queue.add(nextState)
            }
        }

        return -1
    }

    private class State(
            m: Int,
            n: Int,
            val steps: Int,
            val row: Int,
            val col: Int,
            val k: Int,
    ): Comparable<State> {
        val estimation: Int = m + n - 2 - row - col + steps

        override fun compareTo(other: State): Int {
            return this.estimation - other.estimation
        }

        /**
         * only (row, col, k) matters as the state info
         */
        override fun hashCode(): Int {
            return (row + 1) * (col + 1) * k
        }

        override fun equals(other: Any?): Boolean {
            if (other !is State) {
                return false
            }
            return row == other.row && col == other.col && k == other.k
        }
    }
}

fun main() {
    arrayOf(
            arrayOf(
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
            ) to 5,

            arrayOf(
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 0, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 1, 0),
                    intArrayOf(0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 0, 1, 1, 1, 1, 1, 1, 1),
                    intArrayOf(0, 1, 0, 1, 1, 1, 1, 0, 0, 0),
                    intArrayOf(0, 1, 0, 0, 0, 0, 0, 0, 1, 0),
                    intArrayOf(0, 1, 1, 1, 1, 1, 1, 0, 1, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 1, 0)
            ) to 1,

            arrayOf(
                    intArrayOf(0,0,1,0,1,1,1,0),
                    intArrayOf(1,1,0,1,0,1,0,0),
                    intArrayOf(1,1,0,0,1,0,1,1),
                    intArrayOf(1,1,0,1,0,1,0,0),
                    intArrayOf(1,0,0,1,0,1,0,1),
                    intArrayOf(0,0,1,1,1,0,0,1),
                    intArrayOf(0,1,0,1,1,1,1,0),
                    intArrayOf(1,0,0,0,1,1,1,0),
                    intArrayOf(0,0,0,1,0,0,0,1),
                    intArrayOf(1,0,1,0,0,0,1,0),
                    intArrayOf(1,0,1,0,1,1,1,1),
                    intArrayOf(1,1,1,0,0,0,0,1),
                    intArrayOf(0,0,1,1,1,1,0,0),
                    intArrayOf(0,1,0,1,0,1,0,1),
                    intArrayOf(1,1,0,0,1,0,0,0),
                    intArrayOf(0,1,1,1,0,0,1,1),
                    intArrayOf(0,1,0,0,0,0,1,0),
                    intArrayOf(1,1,1,0,1,0,0,0),
                    intArrayOf(1,0,1,1,1,1,1,0),
                    intArrayOf(0,1,0,1,0,0,1,0),
                    intArrayOf(1,1,1,1,0,1,0,1),
                    intArrayOf(0,0,0,0,0,0,1,1),
                    intArrayOf(0,1,0,0,0,0,1,1),
                    intArrayOf(1,1,1,0,0,0,1,1),
                    intArrayOf(0,1,0,0,1,0,0,1),
                    intArrayOf(1,0,0,1,0,1,0,0),
                    intArrayOf(0,0,0,0,1,1,0,1),
                    intArrayOf(0,0,1,0,1,0,1,0),
                    intArrayOf(0,1,1,1,1,0,1,0)
            ) to 3
    ).forEach { (grid, k) ->
        SolutionAStar().shortestPath(grid, k).let(::println)
    }
    //20 + 41 * 8 + 39 = 387
}
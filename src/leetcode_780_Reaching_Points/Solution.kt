package leetcode_780_Reaching_Points

import java.util.Stack

class SolutionIterative {
    fun reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
        val stack = Stack<Pair<Int, Int>>()
        stack.push(sx to sy)
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            if (top.first == tx && top.second == ty) {
                return true
            }

            if (top.first + top.second <= tx && top.second <= ty) {
                stack.push(top.first + top.second to top.second)
            }
            if (top.first <= tx && top.first + top.second <= ty) {
                stack.push(top.first to top.first + top.second)
            }
        }

        return false
    }
}

fun main() {
    arrayOf(
            arrayOf(1,1,3,5),
            arrayOf(1,1,2,2),
            arrayOf(1,1,1,1),
    ).forEach {
        SolutionIterative().reachingPoints(it[0], it[1], it[2], it[3]).let(::println)
    }
}

/*
Input: sx = 1, sy = 1, tx = 3, ty = 5
Output: true
Explanation:
One series of moves that transforms the starting point to the target is:
(1, 1) -> (1, 2)
(1, 2) -> (3, 2)
(3, 2) -> (3, 5)

(1,1) -> (2,1)
 */
package leetcode_1971_Find_if_Path_Exists_in_Graph

import java.util.*
import kotlin.collections.HashSet

class Solution {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val connectedMap = mutableMapOf<Int, MutableList<Int>>()
        edges.forEach {
            if (connectedMap[it[0]] == null) {
                connectedMap[it[0]] = mutableListOf()
            }
            if (connectedMap[it[1]] == null) {
                connectedMap[it[1]] = mutableListOf()
            }
            connectedMap[it[0]]?.add(it[1])
            connectedMap[it[1]]?.add(it[0])
        }
        val stack = Stack<Int>()
        stack.add(source)
        val visitedSet = HashSet<Int>()
        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            if (pop == destination) {
                return true
            }
            visitedSet.add(pop)
            connectedMap[pop]?.forEach {
                if (!visitedSet.contains(it))
                    stack.push(it)
            }
        }

        return false
    }
}

fun main() {
    Solution().validPath(
            n = 6,
            edges = arrayOf(intArrayOf(0,1),intArrayOf(0,2),intArrayOf(3,5),intArrayOf(5,4),intArrayOf(4,3)),
            source = 0,
            destination = 5
    ).let(::println)

    Solution().validPath(
            n = 3,
            edges = arrayOf(intArrayOf(0,1),intArrayOf(1,2),intArrayOf(2,0)),
            source = 0,
            destination = 2
    ).let(::println)
}

/*
Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
 */
package leetcode_323_Number_of_Connected_Components_in_an_Undirected_Graph

import kotlin.test.assertEquals

class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val groupMap = IntArray(n) { it }
        val rank = IntArray(n) { 1 }
        var ans = n
        for (e in edges) {
            val groupA = findGroup(groupMap, e[0])
            val groupB = findGroup(groupMap, e[1])

            if (rank[groupA] < rank[groupB]) {
                groupMap[groupA] = groupB
            } else {
                groupMap[groupB] = groupA
                if (rank[groupA] == rank[groupB]) {
                    ++rank[groupA]
                }
            }

            if (groupA != groupB) {
                --ans
            }
        }

        return ans
    }

    private fun findGroup(group: IntArray, k: Int): Int {
        var curr = k
        while (curr != group[curr]) {
            group[curr] = group[group[curr]]
            curr = group[curr]
        }
        group[k] = curr
        return curr
    }
}

class SolutionDFS {
    private val visited = mutableSetOf<Int>()
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val adjList = List(n) { mutableListOf<Int>() }
        for (i in edges.indices) {
            adjList[edges[i][0]].add(edges[i][1])
            adjList[edges[i][1]].add(edges[i][0])
        }

        var component = 0
        for (i in 0 until n) {
            if (!visited.contains(i)) {
                ++component
                dfs(adjList, i)
            }
        }

        return component
    }

    private fun dfs(adjList: List<List<Int>>, node: Int) {
        visited.add(node)
        for (nb in adjList[node]) {
            if (!visited.contains(nb)) {
                dfs(adjList, nb)
            }
        }
    }
}

fun main() {
    arrayOf(
            5 to arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(3,4)) to 2,
            5 to arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(3,4), intArrayOf(2,3)) to 1,
            5 to arrayOf(intArrayOf(0,1), intArrayOf(1,2), intArrayOf(0,2), intArrayOf(3,4)) to 2,
    ).forEach { (input, expect) ->
        assertEquals(expect, SolutionDFS().countComponents(input.first, input.second))
//        Solution().countComponents(input.first, input.second)
    }
}
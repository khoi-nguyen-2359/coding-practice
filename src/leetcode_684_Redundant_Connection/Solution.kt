package leetcode_684_Redundant_Connection

class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val adjList = mutableMapOf<Int, MutableList<Int>>()
        for (e in edges) {
            adjList.computeIfAbsent(e[0]) { mutableListOf() }.add(e[1])
            adjList.computeIfAbsent(e[1]) { mutableListOf() }.add(e[0])
        }

        val ans = IntArray(2)
        val visited = mutableSetOf<Int>()
        for (e in edges) {
            adjList[e[0]]?.remove(e[1])
            adjList[e[1]]?.remove(e[0])
            visited.clear()
            if (dfs(adjList, visited, e[0], e[1])) {
                ans[0] = e[0]
                ans[1] = e[1]
            }
            adjList[e[0]]?.add(e[1])
            adjList[e[1]]?.add(e[0])
        }

        return ans
    }

    private fun dfs(adjList: MutableMap<Int, MutableList<Int>>, visited: MutableSet<Int>, src: Int, des: Int): Boolean {
        visited.add(src)
        if (src == des) {
            return true
        }
        val neighbors = adjList[src] ?: return false
        for (nb in neighbors) {
            if (!visited.contains(nb)) {
                visited.add(nb)
                if (dfs(adjList, visited, nb, des)) {
                    return true
                }
            }
        }

        return false
    }
}

class SolutionDSU {
    private val MAX_V = 1001
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val dsu = DSU(MAX_V)
        for (e in edges) {
            if (!dsu.union(e[0], e[1])) {
                return e
            }
        }

        return intArrayOf(-1,-1)
    }

    class DSU(n: Int) {
        private val parent = IntArray(n) { index -> index }
        private val rank = IntArray(n) { 0 }

        fun find(a: Int): Int {
            var curr = a
            while (parent[curr] != curr) {
                parent[curr] = parent[parent[curr]]
                curr = parent[curr]
            }
            parent[a] = curr
            return curr
        }

        fun union(a: Int, b: Int): Boolean {
            val pa = find(a)
            val pb = find(b)
            if (pa == pb) {
                return false
            }

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb
            } else {
                parent[pb] = pa
                if (rank[pa] == rank[pb]) {
                    ++rank[pa]
                }
            }

            return true
        }
    }
}
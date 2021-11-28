package leetcode_797_all_possible_paths

class Solution {
    private var result = mutableListOf<List<Int>>()
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        result.clear()
        allPathsSourceTargetRecursive(graph, 0, mutableListOf(0))
        return result
    }

    private fun allPathsSourceTargetRecursive(graph: Array<IntArray>, n: Int, path: MutableList<Int>) {
        if (n == graph.size - 1) {
            result.add(path.toList())
            return
        }

        for (i in graph[n].indices) {
            path.add(graph[n][i])
            allPathsSourceTargetRecursive(graph, graph[n][i], path)
            path.removeAt(path.size - 1)
        }
    }
}

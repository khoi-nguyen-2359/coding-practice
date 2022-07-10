package leetcode_133_Clone_Graph

import Node
import java.util.Stack

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    fun cloneGraph(node: Node?): Node? {
        node ?: return null
        val nodeMap = mutableMapOf<Int, Node>()
        val stack = Stack<Node>()
        stack.push(node)
        while (stack.isNotEmpty()) {
            val pop = stack.pop()
            val cloneNode = nodeMap.computeIfAbsent(pop.`val`) { Node(pop.`val`) }
            for (neighborNode in pop.neighbors) {
                val neighborVal = neighborNode?.`val` ?: continue

                if (!nodeMap.contains(neighborVal)) {
                    stack.push(neighborNode)
                }
                cloneNode.neighbors.add(nodeMap.computeIfAbsent(neighborVal) { Node(neighborVal) })
            }
        }

        return nodeMap[1]
    }
}

fun main() {
    arrayOf(
            listOf(
                    listOf(2,4),
                    listOf(1,3),
                    listOf(2,4),
                    listOf(1,3),
            )
    ).forEach {
        Solution().cloneGraph(Node.fromAdjList(it))
    }
}
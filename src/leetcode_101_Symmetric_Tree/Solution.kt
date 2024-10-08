package leetcode_101_Symmetric_Tree

import LcBinTreeNode
import java.util.LinkedList
import kotlin.test.assertEquals

class Solution {
    private class Recursively {
        fun check(node1: LcBinTreeNode?, node2: LcBinTreeNode?): Boolean {
            if (node1 == null && node2 == null) {
                return true
            }
            if (node1?.`val` != node2?.`val`) {
                return false
            }
            return check(node1?.left, node2?.right) && check(node1?.right, node2?.left)
        }
    }

    private class Iteratively {
        fun check(root: LcBinTreeNode?): Boolean {
            val queue = LinkedList<LcBinTreeNode?>()
            queue.add(root?.left)
            queue.add(root?.right)
            while (queue.size >= 2) {
                val node1 = queue.remove()
                val node2 = queue.remove()
                if (node1 == null && node2 == null) {
                    continue
                }
                if (node1?.`val` != node2?.`val`) {
                    return false
                }
                queue.add(node1?.left)
                queue.add(node2?.right)
                queue.add(node1?.right)
                queue.add(node2?.left)
            }

            return true
        }
    }
    fun isSymmetric(root: LcBinTreeNode?): Boolean {
        return Iteratively().check(root)
    }
}

fun main() {
    arrayOf(
        LcBinTreeNode.create(1,2,2,3,4,4,3) to true,
        LcBinTreeNode.create(1,2,2,3,4,4,2) to false,
        LcBinTreeNode.create(1,2,2) to true,
        LcBinTreeNode.create(1,2,2,1,null,null,null,3) to false,
        LcBinTreeNode.create(1,2,2,null,3,null,3) to false,
        LcBinTreeNode.create(1) to true,
    ).forEach { (inp, exp) ->
        assertEquals(exp, Solution().isSymmetric(inp))
    }
}

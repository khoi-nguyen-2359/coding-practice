package leetcode_104_Maximum_Depth_of_Binary_Tree.attempt_2;

import LcBinTreeNode
import kotlin.test.assertEquals

class Solution {
    private var maxDepth = 0
    fun maxDepth(root: LcBinTreeNode?): Int {
        traverse(root, 0)
        return maxDepth
    }

    private fun traverse(node: LcBinTreeNode?, dep: Int) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, dep)
            return
        }

        traverse(node.left, dep + 1)
        traverse(node.right, dep + 1)
    }
}

fun main() {
    arrayOf(
            LcBinTreeNode.create(3, 9, 20, null, null, 15, 7) to 3,
            LcBinTreeNode.create(1, null, 2) to 2,
    ).forEach { (root, exp) ->
        assertEquals(exp, Solution().maxDepth(root))
    }
}
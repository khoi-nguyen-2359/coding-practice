package leetcode_94_Binary_Tree_Inorder_Traversal

import LcBinTreeNode

class Solution {
    private val result = mutableListOf<Int>()
    fun inorderTraversal(root: LcBinTreeNode?): List<Int> {
        doTraverse(root)
        return result
    }

    private fun doTraverse(node: LcBinTreeNode?) {
        node?.left?.let(::doTraverse)
        node?.`val`?.let(result::add)
        node?.right?.let(::doTraverse)
    }
}

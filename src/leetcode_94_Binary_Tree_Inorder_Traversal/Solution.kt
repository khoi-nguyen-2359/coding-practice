package leetcode_94_Binary_Tree_Inorder_Traversal

import LcTreeNode

class Solution {
    private val result = mutableListOf<Int>()
    fun inorderTraversal(root: LcTreeNode?): List<Int> {
        doTraverse(root)
        return result
    }

    private fun doTraverse(node: LcTreeNode?) {
        node?.left?.let(::doTraverse)
        node?.`val`?.let(result::add)
        node?.right?.let(::doTraverse)
    }
}

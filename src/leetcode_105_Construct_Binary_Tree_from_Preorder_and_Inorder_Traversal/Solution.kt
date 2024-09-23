package leetcode_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal

import LcBinTreeNode
import kotlin.test.assertEquals

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): LcBinTreeNode? {
        return buildTreeRecursive(
                preorder, 0, preorder.size - 1,
                inorder, 0, inorder.size - 1
        )
    }

    private fun buildTreeRecursive(
            preorder: IntArray, preFrom: Int, preTo: Int,
            inorder: IntArray, inFrom: Int, inTo: Int
    ): LcBinTreeNode {
        val rootVal = preorder[preFrom]
        val root = LcBinTreeNode(rootVal)

        val rootIndex = search(inFrom, inTo, inorder, rootVal) - inFrom
//        val leftSize = Math.max(rootIndex, 0)

        val left = if (preFrom + 1 > preFrom + rootIndex || inFrom > inFrom + rootIndex - 1) {
            null
        } else {
            buildTreeRecursive(
                    preorder, preFrom + 1, preFrom + rootIndex,
                    inorder, inFrom, inFrom + rootIndex - 1
            )
        }
        val right = if (preFrom + rootIndex + 1 > preTo || inFrom + rootIndex + 1 > inTo) {
            null
        } else {
            buildTreeRecursive(
                    preorder, preFrom + rootIndex + 1, preTo,
                    inorder, inFrom + rootIndex + 1, inTo
            )
        }

        root.left = left
        root.right = right

        return root
    }

    private fun search(inFrom: Int, inTo: Int, inorder: IntArray, rootVal: Int): Int {
        for (i in inFrom..inTo) {
            if (inorder[i] == rootVal) {
                return i
            }
        }
        return -1
    }
}

fun main() {
    arrayOf(
            intArrayOf(3, 9, 20, 15, 7) to intArrayOf(9, 3, 15, 20, 7) to LcBinTreeNode.create(3, 9, 20, null, null, 15, 7),
            intArrayOf(-1) to intArrayOf(-1) to LcBinTreeNode.create(-1),
            intArrayOf(4, 1, 2, 3) to intArrayOf(1, 2, 3, 4) to LcBinTreeNode.create(4, 1, null, null, 2, null, null, null, null, null, 3)
    ).forEach { (input, exp) ->
        val output = Solution().buildTree(input.first, input.second)
        assertEquals(exp, output)
    }
}
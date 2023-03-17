package leetcode_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal

import TreeNode
import java.util.Stack
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
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        return iterativelyCheck(inorder, postorder)
    }

    private fun iterativelyCheck(inorder: IntArray, postorder: IntArray): TreeNode? {
        val stack = Stack<Triple<TreeNode, IntArray, IntArray>>()
        val rootNode = postorder.lastOrNull()?.let(::TreeNode) ?: return null
        stack.add(Triple(rootNode, inorder, postorder))
        while (stack.isNotEmpty()) {
            val (parent, inord, postord) = stack.pop()
            val parentInorderIndex = inord.indexOf(parent.`val`)

            val leftInOrd = inord.sliceArray( 0 until parentInorderIndex)
            val leftPostOrd = postord.sliceArray(0 until parentInorderIndex)
            val leftNode = leftPostOrd.lastOrNull()?.let(::TreeNode)
            parent.left = leftNode

            val rightInOrd = inord.sliceArray( parentInorderIndex + 1 until inord.size)
            val rightPostOrd = postord.sliceArray(parentInorderIndex until postord.size - 1)
            val rightNode = rightPostOrd.lastOrNull()?.let(::TreeNode)
            parent.right = rightNode

            if (leftNode != null) {
                stack.push(Triple(leftNode, leftInOrd, leftPostOrd))
            }
            if (rightNode != null) {
                stack.push(Triple(rightNode, rightInOrd, rightPostOrd))
            }
        }
        return rootNode
    }

    private fun recursivelyCheck(inorder: IntArray, postorder: IntArray): TreeNode? {
        val parent = postorder.lastOrNull() ?: return null
        val parentInorderIndex = inorder.indexOf(parent)
        val left = recursivelyCheck(
            inorder.sliceArray( 0 until parentInorderIndex),
            postorder.sliceArray(0 until parentInorderIndex)
        )
        val right = recursivelyCheck(
            inorder.sliceArray( parentInorderIndex + 1 until inorder.size),
            postorder.sliceArray(parentInorderIndex until postorder.size - 1)
        )
        val parentNode = TreeNode(parent).apply {
            this.left = left
            this.right = right
        }
        return parentNode
    }
}

fun main() {
    arrayOf(
        intArrayOf(1,2,3,5,4,7,6,8) to intArrayOf(1,2,5,7,8,6,4,3) to TreeNode.create(3,2,4,1,null,5,6,null,null,null,null,null,null,7,8),
        intArrayOf(9,3,15,20,7) to intArrayOf(9,15,7,20,3) to TreeNode.create(3,9,20,null,null,15,7),
        intArrayOf(9,3) to intArrayOf(9,3) to TreeNode.create(3,9),
        intArrayOf(-1) to intArrayOf(-1) to TreeNode.create(-1),
    ).forEach { (inp, exp) ->
        val tree = Solution().buildTree(inp.first, inp.second) ?: return@forEach
        assertEquals(tree, exp)
    }
}
package leetcode_285_Inorder_Successor_in_BST

import TreeNode
import kotlin.test.assertEquals

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

/*
1. next is parent
-> node doesn't have right child
   -> node is left child -> next is parent
   -> node is right child -> go up for an ancestor


2. next is left subtree
-> n/a
    can't happen, node is visited always after left child

3. next is right subtree
-> node has right child
-> leftmost child of right child

=>
        1. node has right child
        2. node doesn't has right child

 */

class Solution {
    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        return findRecursive(root, p).takeIf { it?.`val` != p?.`val` }
    }

    private fun findRecursive(node: TreeNode?, p: TreeNode?): TreeNode? {
        if (node == null) {
            return null
        }

        // found the target node
        if (node.`val` == p?.`val`) {
            return if (node.right != null) {
                // right subtree exists -> find the leftmost of right child
                findLeftMost(node.right)
            } else {
                // pass the target node for upper level to determine
                node
            }
        }

        val foundOnLeft = findRecursive(node.left, p)
        if (foundOnLeft != null) {
            return if (foundOnLeft.`val` == p?.`val` && node.`val` > foundOnLeft.`val`) {
                // track back to the node larger than the target node
                node
            } else {
                // continue passing up
                foundOnLeft
            }
        }

        // similar on right subtree..
        val foundOnRight = findRecursive(node.right, p)
        if (foundOnRight != null) {
            return if (foundOnRight.`val` == p?.`val` && node.`val` > foundOnRight.`val`) {
                node
            } else {
                foundOnRight
            }
        }

        return null
    }

    private fun findLeftMost(root: TreeNode?): TreeNode? {
        var node: TreeNode? = root
        while (node?.left != null) {
            node = node.left
        }
        return node
    }

}

fun main() {
    arrayOf(
            TreeNode.create(2, 1, 3) to 1 to TreeNode.create(2, 1, 3),
            TreeNode.create(5, 3, 6, 2, 4, null, null, 1) to 6 to null,
            TreeNode.create(5, 3, 6, 1, 4, null, null, null, 2) to 4 to TreeNode.create(5, 3, 6, 1, 4, null, null, null, 2),
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().inorderSuccessor(input.first, TreeNode(input.second)))
    }
}
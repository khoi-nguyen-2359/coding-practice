package leetcode_236_Lowest_Common_Ancestor_of_a_Binary_Tree

import LcBinTreeNode
import java.util.Stack
import kotlin.test.assertEquals

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: LcBinTreeNode?, p: LcBinTreeNode?, q: LcBinTreeNode?): LcBinTreeNode? {
        // build the parent map
        val parent = mutableMapOf<Int, LcBinTreeNode?>()
        buildParentMap(root, parent)

        // build the ancestor set of p from parent map
        val pAncestorSet = mutableSetOf<Int?>()
        var current = p
        do {
            pAncestorSet.add(current?.`val`)
            current = parent[current?.`val`]
        } while (current != null)

        // check in parent map, if there's any ancestor of q is inside ancestor set of p
        current = q
        do {
            if (pAncestorSet.contains(current?.`val`)) {
                return current
            }
            current = parent[current?.`val`]
        } while (current != null)

        return null
    }

    private fun buildParentMap(node: LcBinTreeNode?, parentMap: MutableMap<Int, LcBinTreeNode?>) {
        val leftVal = node?.left?.`val`
        if (leftVal != null) {
            parentMap[leftVal] = node
            buildParentMap(node.left, parentMap)
        }
        val rightVal = node?.right?.`val`
        if (rightVal != null) {
            parentMap[rightVal] = node
            buildParentMap(node.right, parentMap)
        }
    }
}

class Solution2 {
    fun lowestCommonAncestor(root: LcBinTreeNode?, p: LcBinTreeNode?, q: LcBinTreeNode?): LcBinTreeNode? {
        val stack = Stack<Pair<LcBinTreeNode?, Int>>()
        stack.push(root to 2)
        var lca: LcBinTreeNode? = null
        var oneNodeFound = false
        while (stack.isNotEmpty()) {
            val (parent, state) = stack.pop()
            if (state == 0) {
                if (oneNodeFound && lca?.`val` == parent?.`val` && stack.isNotEmpty()) {
                    lca = stack.peek().first
                }
            } else {
                if (state == 2 && (parent?.`val` == p?.`val` || parent?.`val` == q?.`val`)) {
                    if (oneNodeFound) {
                        return lca
                    }
                    oneNodeFound = true
                    lca = parent
                }

                val child = if (state == 2) {
                    parent?.left
                } else {
                    parent?.right
                }
                stack.push(parent to state - 1)
                if (child != null) {
                    stack.push(child to 2)
                }
            }
        }

        return lca
    }
}

fun main() {
    arrayOf(
//            Triple(TreeNode.create(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5), 2, 8) to 6,
//            Triple(TreeNode.create(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5), 2, 4) to 2,
//            Triple(TreeNode.create(2, 1), 2, 1) to 2,
//            Triple(TreeNode.create(2, 1), 1, 2) to 2,
            Triple(LcBinTreeNode.create(9,-1,-4,10,3,null,null,null,5), 3, 5) to -1
    ).forEach { (input, exp) ->
        val (root, p, q) = input
//        assertEquals(exp, Solution().lowestCommonAncestor(root, TreeNode(p), TreeNode(q))?.`val`)
        assertEquals(exp, Solution2().lowestCommonAncestor(root, LcBinTreeNode(p), LcBinTreeNode(q))?.`val`)
    }
}

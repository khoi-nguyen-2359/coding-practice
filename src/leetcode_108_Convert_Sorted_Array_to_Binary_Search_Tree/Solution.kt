package leetcode_108_Convert_Sorted_Array_to_Binary_Search_Tree

import LcBinTreeNode as TreeNode

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
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return makeTree(nums, 0, nums.size - 1)
    }

    private fun makeTree(nums: IntArray, l: Int, r: Int): TreeNode? {
        if (l > r) {
            return null
        }
        val m = (l + r) / 2
        val top = TreeNode(nums[m])
        val left = makeTree(nums, l, m - 1)
        val right = makeTree(nums, m + 1, r)
        top.left = left
        top.right = right
        return top
    }
}

fun main() {
    arrayOf(
        intArrayOf(-10,-3,0,5,9),
        intArrayOf(-10,-3,5,9),
        intArrayOf(3,1),
    ).forEach { inp ->
        Solution().sortedArrayToBST(inp)?.printAllPaths()
    }
}
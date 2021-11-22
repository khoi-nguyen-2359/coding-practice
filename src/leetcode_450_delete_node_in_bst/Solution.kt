package leetcode_450_delete_node_in_bst

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        val (found, parent, isLeftOrRight) = search(root, null, key, false)
        if (found == null) {
            // not found
            return root
        }
        val left = found.left
        val right = found.right
        if (left == null && right == null) {
            return if (parent == null) {
                // delete root
                null
            } else {
                // delete leaf
                if (isLeftOrRight) {
                    parent.left = null
                } else {
                    parent.right = null
                }
                root
            }
        }

        if (left != null) {
            val predecessorValue = deletePredecessor(left, found, true)
            found.`val` = predecessorValue
        } else if (right != null) {
            val successorValue = deleteSuccessor(right, found, true)
            found.`val` = successorValue
        }

        return root
    }

    private fun deleteSuccessor(node: TreeNode, parent: TreeNode?, isRoot: Boolean): Int {
        val left = node.left
        if (left == null) {
            if (isRoot) {
                // successor is right under parent
                parent?.right = node.right
            } else {
                parent?.left = node.right
            }
            return node.`val`
        }
        return deleteSuccessor(left, node, false)
    }

    private fun deletePredecessor(node: TreeNode, parent: TreeNode?, isRoot: Boolean): Int {
        val right = node.right
        if (right == null) {
            if (isRoot) {
                // predecessor is right under parent
                parent?.left = node.left
            } else {
                parent?.right = node.left
            }
            return node.`val`
        }
        return deletePredecessor(right, node, false)
    }

    private fun search(node: TreeNode?, parent: TreeNode?, key: Int, isLeftOrRight: Boolean): Triple<TreeNode?, TreeNode?, Boolean> {
        if (node == null) {
            return Triple(null, null, false)
        }
        if (key < node.`val`) {
            return search(node.left, node, key, isLeftOrRight = true)
        }
        if (key > node.`val`) {
            return search(node.right, node, key, isLeftOrRight = false)
        }
        return Triple(node, parent, isLeftOrRight)
    }
}

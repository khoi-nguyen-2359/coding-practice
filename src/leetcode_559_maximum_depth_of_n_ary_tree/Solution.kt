package leetcode_559_maximum_depth_of_n_ary_tree

import LcNaryTreeNode as Node

class Solution {
    fun maxDepth(root: Node?): Int {
        if (root == null) {
            return 0
        }
        val deque = ArrayDeque<Pair<Node, Int>>()
        deque.add(root to 1)
        var max = 0
        while (deque.isNotEmpty()) {
            val (node, height) = deque.removeFirst()
            if (node.children.isEmpty()) {
                if (height > max) {
                    max = height
                }
            } else {
                node.children.forEach { child ->
                    if (child != null) {
                        deque.add(child to height + 1)
                    }
                }
            }
        }

        return max
    }
}

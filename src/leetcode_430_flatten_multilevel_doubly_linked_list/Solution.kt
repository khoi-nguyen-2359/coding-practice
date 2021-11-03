package leetcode_430_flatten_multilevel_doubly_linked_list

/**
 * Definition for a Node.
 */
class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}

class Solution {
    fun flatten(root: Node?): Node? {
        flattenRecursive(root)
        return root
    }

    private fun flattenRecursive(root: Node?): Node? {
        var curr = root
        while (curr != null) {
            if (curr.child != null) {
                val childTail = flattenRecursive(curr.child)
                val tmp = curr.next
                curr.next = curr.child
                curr.child?.prev = curr
                childTail?.next = tmp
                tmp?.prev = childTail
                curr.child = null
            }

            if (curr.next == null) {
                break
            }
            curr = curr.next
        }

        return curr
    }

    private fun flattenIterative(root: Node?): Node? {
        var curr: Node? = Node(0)
        val stack = mutableListOf(root)
        while (stack.isNotEmpty()) {
            val last = stack.last()
            stack.removeAt(stack.size - 1)
            curr?.next = last
            last?.prev = curr
            curr = last
            if (last?.next != null) {
                stack.add(last.next)
            }
            if (last?.child != null) {
                stack.add(last.child)
                last.child = null
            }
        }
        root?.prev = null
        return root
    }
}
package leetcode_138_copy_list_with_random_pointer

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class Solution {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) {
            return null
        }

        // make weaved list
        var current = node
        var tmp: Node?
        while (current != null) {
            val copied = Node(current.`val`)
            copied.next = current.next

            tmp = current.next
            current.next = copied
            current = tmp
        }

        // identify random of copied node
        current = node
        while (current != null) {
            current.next?.random = current.random?.next
            current = current.next?.next
        }

        // unweave list
        val result = node.next
        current = node
        while (current != null) {
            val copied = current.next
            current.next = current.next?.next
            copied?.next = copied?.next?.next
            current = current.next
        }


        return result
    }
}
package leetcode_24_swap_nodes_in_pairs

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        var curr = head
        val dummyRoot = ListNode(-1)
        var prev: ListNode? = dummyRoot
        while (curr != null) {
            val swappedHead = swapPair(curr)
            prev?.next = swappedHead
            curr = swappedHead.next?.next
            prev = swappedHead.next
        }
        return dummyRoot.next
    }

    private fun swapPair(node: ListNode): ListNode {
        val next = node.next ?: return node
        val tmpNextNext = next.next
        next.next = node
        node.next = tmpNextNext
        return next
    }
}
package leetcode_143_reorder_linked_list.attempt_1

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reorderList(head: ListNode?) {
        val list = mutableListOf<ListNode>()
        var curr = head
        while (curr != null) {
            list.add(curr)
            curr = curr.next
        }

        var prev = ListNode(-1)
        for (i in 0..list.size / 2) {
            val j = list.size - i - 1
            val right = when {
                j < i -> return
                j == i -> list[i]
                else -> list[j]
            }
            val left = list[i]
            prev.next = left
            left.next = right
            right.next = null
            prev = right
        }
    }
}
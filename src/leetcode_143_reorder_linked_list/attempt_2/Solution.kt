package leetcode_143_reorder_linked_list.attempt_2;

import LcLinkedListNode

class Solution {
    fun reorderList(head: LcLinkedListNode?) {
        // find tail
        var fast = head
        var slow = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }

        // reverse second half
        var prev: LcLinkedListNode? = null
        var curr = slow
        while (curr != null) {
            val tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
        }
//        prev?.print()

        // reorder
        var next: LcLinkedListNode? = LcLinkedListNode(-1)
        var (left, right) = head to prev
        while (next != null) {
            next.next = left
            val tmpLeft = left?.next
            next.next?.next = right
            left = tmpLeft
            right = right?.next
            next = next.next?.next
//            head?.print()
//            println()
        }
    }
}

fun main() {
    val head = LcLinkedListNode.create(1,2,3,4)
    Solution().reorderList(head)
//    head?.print()
}
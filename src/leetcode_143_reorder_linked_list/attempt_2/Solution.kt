package leetcode_143_reorder_linked_list.attempt_2;

import ListNode

class Solution {
    fun reorderList(head: ListNode?) {
        // find tail
        var fast = head
        var slow = head
        while (fast?.next != null) {
            fast = fast.next?.next
            slow = slow?.next
        }

        // reverse second half
        var prev: ListNode? = null
        var curr = slow
        while (curr != null) {
            val tmp = curr.next
            curr.next = prev
            prev = curr
            curr = tmp
        }
//        prev?.print()

        // reorder
        var next: ListNode? = ListNode(-1)
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
    val head = ListNode.create(1,2,3,4)
    Solution().reorderList(head)
//    head?.print()
}
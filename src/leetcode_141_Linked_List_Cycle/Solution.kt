package leetcode_141_Linked_List_Cycle

import ListNode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head
        do {
            slow = slow?.next
            fast = fast?.next?.next
        } while (slow != fast && slow != null)

        return slow != null
    }
}

fun main() {
    val head = ListNode.create(1)
    head?.next = head
    Solution().hasCycle(head).let(::println)
}
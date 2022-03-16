package leetcode_237_Delete_Node_in_a_Linked_List

import ListNode

class Solution {
    fun deleteNode(node: ListNode?) {
        var curr = node
        var next = curr?.next
        var prev: ListNode? = null
        while (curr != null && next != null) {
            curr.`val` = next.`val`
            prev = curr
            curr = next
            next = curr.next
        }
        prev?.next = null
    }
}
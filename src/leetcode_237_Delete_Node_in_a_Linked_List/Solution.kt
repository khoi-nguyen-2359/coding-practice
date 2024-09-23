package leetcode_237_Delete_Node_in_a_Linked_List

import LcLinkedListNode

class Solution {
    fun deleteNode(node: LcLinkedListNode?) {
        var curr = node
        var next = curr?.next
        var prev: LcLinkedListNode? = null
        while (curr != null && next != null) {
            curr.`val` = next.`val`
            prev = curr
            curr = next
            next = curr.next
        }
        prev?.next = null
    }
}
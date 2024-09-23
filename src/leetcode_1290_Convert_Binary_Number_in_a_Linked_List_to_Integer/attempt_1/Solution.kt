package leetcode_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer.attempt_1

import LcLinkedListNode

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
    fun getDecimalValue(head: LcLinkedListNode?): Int {
        var curr = head
        var result = 0
        while (curr != null) {
            result = result * 2 + curr.`val`
            curr = curr.next
        }
        return result
    }
}

fun main() {
    arrayOf(
            LcLinkedListNode.create(1,0,1),
            LcLinkedListNode.create(0),
            LcLinkedListNode.create(1,0),
            LcLinkedListNode.create(1),
    ).forEach {
        Solution().getDecimalValue(it).let(::println)
    }
}
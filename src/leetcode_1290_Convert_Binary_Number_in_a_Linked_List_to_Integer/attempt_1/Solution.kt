package leetcode_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer.attempt_1

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
    fun getDecimalValue(head: ListNode?): Int {
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
            ListNode.create(1,0,1),
            ListNode.create(0),
            ListNode.create(1,0),
            ListNode.create(1),
    ).forEach {
        Solution().getDecimalValue(it).let(::println)
    }
}
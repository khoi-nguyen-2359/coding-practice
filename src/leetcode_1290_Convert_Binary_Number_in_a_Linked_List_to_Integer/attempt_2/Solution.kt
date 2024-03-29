package leetcode_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer.attempt_2

import kotlin.math.pow

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        var curr = head
        var size = 0
        while (curr != null) {
            ++size
            curr = curr.next
        }
        var result = 0.0
        curr = head
        for (i in size - 1 downTo 0) {
            result += (curr?.`val` ?: 0) * 2.0.pow(i)
            curr = curr?.next
        }

        return result.toInt()
    }
}
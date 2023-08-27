package leetcode_206_reverselinkedlist.attempt_1

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var value: Int) {
    var next: ListNode? = null

    fun print() {
        var curr: ListNode? = this
        while (curr != null) {
            println(curr.value)
            curr = curr.next
        }
    }
}

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var curr: ListNode? = null
        var next: ListNode? = head
        while (next != null) {
            val tmp = next.next
            next.next = curr
            curr = next
            next = tmp
        }
        return curr
    }
}

fun main(args: Array<String>) {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3)
        }
//        print()
    }
    Solution().reverseList(head)?.print()
}
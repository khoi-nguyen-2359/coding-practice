package leetcode_206_reverselinkedlist.attempt_2

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
        // [0] -> [1] -> [2] -> [3] -> [null]
        var newHead: ListNode? = null
        var curr = head
        while (curr != null) {
            val tmp = curr.next
            curr.next = newHead
            newHead = curr
            curr = tmp
        }
        return newHead
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
package leetcode_203_remove_linked_list_element

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val tempRoot = ListNode(-1)
        tempRoot.next = head
        var prev = tempRoot
        var curr = head
        while (curr != null) {
            if (`val` == curr.`val`) {
                prev.next = curr.next
            } else {
                prev = curr
            }
            curr = curr.next
        }
        return tempRoot.next
    }
}
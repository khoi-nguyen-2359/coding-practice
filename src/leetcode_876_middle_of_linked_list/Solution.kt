package leetcode_876_middle_of_linked_list

class ListNode(
        var value: Int,
        var next: ListNode? = null
)

class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        var fast = head
        var slow = head
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        return slow
    }
}

fun main() {
    val node6 = ListNode(6, null)
    val node5 = ListNode(5, node6)
    val node4 = ListNode(4, node5)
    val node3 = ListNode(3, node4)
    val node2 = ListNode(2, node3)
    val head = ListNode(1, node2)
    Solution().middleNode(head).also {
        println(it?.value)
    }
}
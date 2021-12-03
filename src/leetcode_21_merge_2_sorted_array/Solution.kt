package leetcode_21_merge_2_sorted_array

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var i = list1
        var j = list2
        val root = ListNode(-1)
        var curr: ListNode? = root
        while (i != null && j != null) {
            if (i.`val` < j.`val`) {
                curr?.next = i
                i = i.next
            } else if (i.`val` >= j.`val`) {
                curr?.next = j
                j = j.next
            }
            curr = curr?.next
        }

        curr?.next = i ?: j

        return root.next
    }
}
package leetcode_141_Linked_List_Cycle.attempt_2

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
/*
1. Use a slow pointer (1x) and a fast pointer (2x)
2. If 2 pointer meet each other, => has cycle
3. Reach null with either pointers => no cycle
* time complexity: O(n)
* space complexity: O(1)
 */
class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var slow = head?.next
        var fast = head?.next?.next
        while (slow != null && fast != null) {
            slow = slow.next
            fast = fast.next?.next
            if (slow == fast) {
                return true
            }
        }
        return false
    }
}

/*
1. Use a hash set to store elements in list
2. Traverse the list from head
3. At each element, check for its existence in the map
4. if (yes) -> return true
    (no) -> save element into map, continue traversing
* time complexity: O(n)
* space complexity: O(n)
 */
class SolutionBF {
    fun hasCycle(head: ListNode?): Boolean {
        val exist = hashSetOf<ListNode>()
        var curr = head
        while (curr != null) {
            if (exist.contains(curr)) {
                return true
            }
            exist.add(curr)
            curr = curr.next
        }
        return false
    }
}
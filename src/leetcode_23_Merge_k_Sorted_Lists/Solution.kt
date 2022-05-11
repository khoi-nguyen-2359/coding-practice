package leetcode_23_Merge_k_Sorted_Lists

import ListNode
import java.util.PriorityQueue
import kotlin.math.min

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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val queue = PriorityQueue<Int>()
        for (i in lists.indices) {
            var c = lists[i]
            while (c != null) {
                queue.add(c.`val`)
                c = c.next
            }
        }

        val result = ListNode(-1)
        var c: ListNode? = result
        while (queue.isNotEmpty()) {
            val value = queue.poll()
            c?.next = ListNode(value)
            c = c?.next
        }
        return result.next
    }
}

fun main() {
    arrayOf(
            arrayOf(
                    ListNode.create(1, 3, 4),
                    ListNode.create(1, 4, 5),
                    ListNode.create(5, 6),
            ),
            arrayOf(),
            arrayOf(ListNode.create())
    ).forEach {
        println()
        Solution().mergeKLists(it)?.print()
    }
}
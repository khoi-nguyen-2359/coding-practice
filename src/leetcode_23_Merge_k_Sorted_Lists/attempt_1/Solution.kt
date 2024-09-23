package leetcode_23_Merge_k_Sorted_Lists.attempt_1

import LcLinkedListNode
import java.util.PriorityQueue

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
    fun mergeKLists(lists: Array<LcLinkedListNode?>): LcLinkedListNode? {
        val queue = PriorityQueue<Int>()
        for (i in lists.indices) {
            var c = lists[i]
            while (c != null) {
                queue.add(c.`val`)
                c = c.next
            }
        }

        val result = LcLinkedListNode(-1)
        var c: LcLinkedListNode? = result
        while (queue.isNotEmpty()) {
            val value = queue.poll()
            c?.next = LcLinkedListNode(value)
            c = c?.next
        }
        return result.next
    }
}

fun main() {
    arrayOf(
            arrayOf(
                    LcLinkedListNode.create(1, 3, 4),
                    LcLinkedListNode.create(1, 4, 5),
                    LcLinkedListNode.create(5, 6),
            ),
            arrayOf(),
            arrayOf(LcLinkedListNode.create())
    ).forEach {
        println()
        Solution().mergeKLists(it)?.print()
    }
}
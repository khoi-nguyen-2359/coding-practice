package hackerrank_Linked_Lists_Cycle_Detection

import SinglyLinkedList
import SinglyLinkedListNode
import java.io.BufferedWriter
import java.io.FileWriter
import java.util.*


// Complete the hasCycle function below.
/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
fun hasCycle(head: SinglyLinkedListNode?): Boolean {
    var fast = head
    var slow = head
    while (fast != null && slow != null) {
        fast = fast.next
        slow = slow.next?.next
        if (fast == slow) {
            return true
        }
    }
    return false
}

private val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    val bufferedWriter = BufferedWriter(FileWriter(System.getenv("OUTPUT_PATH")))
    val tests = scanner.nextInt()
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
    for (testsItr in 0 until tests) {
        val index = scanner.nextInt()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        val llist = SinglyLinkedList()
        val llistCount = scanner.nextInt()
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
        for (i in 0 until llistCount) {
            val llistItem = scanner.nextInt()
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")
            llist.insertNode(llistItem)
        }
        var extra: SinglyLinkedListNode? = SinglyLinkedListNode(-1)
        var temp = llist.head
        for (i in 0 until llistCount) {
            if (i == index) {
                extra = temp
            }
            if (i != llistCount - 1) {
                temp = temp!!.next
            }
        }
        temp!!.next = extra
        val result = hasCycle(llist.head)
        bufferedWriter.write((if (result) 1 else 0).toString())
        bufferedWriter.newLine()
    }
    bufferedWriter.close()
    scanner.close()
}

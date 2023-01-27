import java.io.BufferedWriter

class SinglyLinkedListNode(var data: Int) {
        var next: SinglyLinkedListNode? = null
    }

class SinglyLinkedList {
    var head: SinglyLinkedListNode? = null
    var tail: SinglyLinkedListNode? = null
    fun insertNode(nodeData: Int) {
        val node = SinglyLinkedListNode(nodeData)
        if (head == null) {
            head = node
        } else {
            tail!!.next = node
        }
        tail = node
    }
}

fun printSinglyLinkedList(node: SinglyLinkedListNode?, sep: String, bufferedWriter: BufferedWriter) {
    var currNode = node
    while (currNode != null) {
        bufferedWriter.write(currNode.data.toString())
        currNode = currNode.next
        if (currNode != null) {
            bufferedWriter.write(sep)
        }
    }
}
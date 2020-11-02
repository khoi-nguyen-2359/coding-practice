package leetcode_359_logger_rate_limiter

class Logger() {

    class Node(val timestamp: Int, val message: String, var next: Node? = null)

    private val k = 10
    private var head: Node? = null

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        val node = Node(timestamp, message)

        var current = head
        var tail = head
        var shouldPrint = true
        while (current != null) {
            if (current.timestamp < timestamp - k) {
                head = head?.next
            } else if (shouldPrint) {
                shouldPrint = current.message != message
            }
            tail = current
            current = current.next
        }

        if (head == null) {
            head = node
            return true
        }

        if (shouldPrint) {
            tail?.next = node
        }

        return shouldPrint
    }
}
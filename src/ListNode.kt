class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun print() {
        var curr: ListNode? = this
        while (curr != null) {
            println(curr.`val`)
            curr = curr.next
        }
    }
}
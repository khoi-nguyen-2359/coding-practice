class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun print() {
        var curr: ListNode? = this
        while (curr != null) {
            println(curr.`val`)
            curr = curr.next
        }
    }

    companion object {
        fun create(vararg values: Int): ListNode? {
            if (values.isEmpty()) {
                return null
            }
            val result = ListNode(values[0])
            var c: ListNode? = result
            for (i in 1 until values.size) {
                c?.next = ListNode(values[i])
                c = c?.next
            }

            return result
        }
    }
}
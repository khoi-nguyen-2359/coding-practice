class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun print() {
        var curr: ListNode? = this
        while (curr != null) {
            print(curr.`val`)
            curr = curr.next
            if (curr != null) {
                print("->")
            }
        }
    }

    fun isEqual(other: ListNode?): Boolean {
        var c1: ListNode? = this
        var c2: ListNode? = other
        while (c1 != null && c2 != null && c1.`val` == c2.`val`) {
            c1 = c1.next
            c2 = c2.next
        }

        return c1 == null && c2 == null
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
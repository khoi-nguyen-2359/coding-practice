class LcLinkedListNode(var `val`: Int) {
    var next: LcLinkedListNode? = null

    fun print() {
        var curr: LcLinkedListNode? = this
        while (curr != null) {
            print(curr.`val`)
            curr = curr.next
            if (curr != null) {
                print("->")
            }
        }
    }

    fun isEqual(other: LcLinkedListNode?): Boolean {
        var c1: LcLinkedListNode? = this
        var c2: LcLinkedListNode? = other
        while (c1 != null && c2 != null && c1.`val` == c2.`val`) {
            c1 = c1.next
            c2 = c2.next
        }

        return c1 == null && c2 == null
    }

    companion object {
        fun create(vararg values: Int): LcLinkedListNode? {
            if (values.isEmpty()) {
                return null
            }
            val result = LcLinkedListNode(values[0])
            var c: LcLinkedListNode? = result
            for (i in 1 until values.size) {
                c?.next = LcLinkedListNode(values[i])
                c = c?.next
            }

            return result
        }
    }
}
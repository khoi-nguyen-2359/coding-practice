package leetcode_369_Plus_One_Linked_List

class Node(var value: Int) {
    var next: Node? = null
}

class SolutionRecursive {
    private var carry = 1
    fun addOne(head: Node): Node {
        carry = 1
        addRecursively(head)
        return if (carry != 0) {
            Node(carry).apply {
                next = head
            }
        } else {
            head
        }
    }

    private fun addRecursively(node: Node?) {
        if (node == null) {
            return
        }

        addRecursively(node.next)

        val s = node.value + carry
        carry = s / 10
        node.value = s % 10
    }
}

class SolutionInPlace {
    fun addOne(head: Node): Node {
        val reversed = reverse(head)
        var curr: Node? = reversed
        var carry = 1
        var prev: Node? = curr
        while (curr != null) {
            val s = curr.value + carry
            curr.value = s % 10
            carry = s / 10

            prev = curr
            curr = curr.next
        }
        if (carry != 0) {
            prev?.next = Node(carry)
        }

        return reverse(reversed)
    }

    private fun reverse(head: Node): Node {
        var curr: Node? = head
        var next: Node? = null
        while (curr != null) {
            val tmp = curr.next
            curr.next = next
            next = curr
            curr = tmp

            if (curr == null) {
                return next
            }
        }

        return Node(-1)
    }
}

fun main() {
    val head = Node(9).apply {
        next = Node(9).apply {
            next = Node(9).apply {
                next = Node(9).apply {
                    next = Node(9).apply {
                        next = Node(9)
                    }
                }
            }
        }
    }

    SolutionInPlace().addOne(head).let {
        var c: Node? = it
        while (c != null) {
            println(c.value)
            c = c.next
        }
    }
}
/*
[2]->[4]->[5]->[7]->[3]->[6]
 */
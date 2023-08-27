package leetcode_155_min_stack.attempt_3

class MinStack {

    private val data = mutableListOf<Node>()

    fun push(`val`: Int) {
        val lastMin = data.lastOrNull()?.min ?: Int.MAX_VALUE
        val node = Node(`val`, Math.min(`val`, lastMin))
        data.add(node)
    }

    fun pop() {
        data.removeAt(data.size - 1)
    }

    fun top(): Int {
        return data.lastOrNull()?.value ?: -1
    }

    fun getMin(): Int {
        return data.lastOrNull()?.min ?: -1
    }

    private class Node(val value: Int, val min: Int)
}

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    minStack.getMin().let(::println) // return -3

    minStack.pop()
    minStack.top().let(::println) // return 0

    minStack.getMin().let(::println) // return -2
}

/*
-2      0       -3




 */

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
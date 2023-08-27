package leetcode_155_min_stack.attempt_2

class MinStack {

    private val minMemory = arrayListOf<Int>()
    private val stack = arrayListOf<Int>()

    fun push(item: Int) {
        stack.add(item)
        if (minMemory.isEmpty()) {
            minMemory.add(0)
        } else {
            if (item < stack[minMemory.last()]) {
                minMemory.add(stack.size - 1)
            } else {
                minMemory.add(minMemory.last())
            }
        }
    }

    fun pop() {
        stack.removeAt(stack.size - 1)
        minMemory.removeAt(minMemory.size - 1)
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return stack[minMemory.last()]
    }

}

fun main() {
    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    var min = minStack.getMin() // return -3
    println(min)
    minStack.pop()
    minStack.top() // return 0
    min = minStack.getMin() // return -2
    println(min)
}
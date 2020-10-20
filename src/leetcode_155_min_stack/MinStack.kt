package leetcode_155_min_stack

class MinStack() {

    private val valueStack = mutableListOf<Int>()
    private val minStack = mutableListOf<Int>()

    fun push(x: Int) {
        valueStack.add(x)
        if (minStack.isEmpty() || minStack.last() >= x) {
            minStack.add(x)
        }
    }

    fun pop() {
        val removed = valueStack.removeAt(valueStack.size - 1)
        if (removed <= minStack.last()) {
            minStack.removeAt(minStack.size - 1)
        }
    }

    fun top(): Int {
        return valueStack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
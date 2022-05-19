package leetcode_1381_Design_a_Stack_With_Increment_Operation

import java.lang.Integer.min

class CustomStack(maxSize: Int) {

    private val data = IntArray(maxSize)
    private var topIndex = -1

    fun push(x: Int) {
        if (topIndex == data.size - 1) {
            return
        }

        data[++topIndex] = x
    }

    fun pop(): Int {
        if (topIndex == -1) {
            return -1
        }
        return data[topIndex--]
    }

    fun increment(k: Int, `val`: Int) {
        for (i in 0..min(k - 1, topIndex)) {
            data[i] += `val`
        }
    }

}

fun main() {
    val customStack = CustomStack(3) // Stack is Empty []

    customStack.push(1) // stack becomes [1]

    customStack.push(2) // stack becomes [1, 2]

    customStack.pop() // return 2 --> Return top of the stack 2, stack becomes [1]

    customStack.push(2) // stack becomes [1, 2]

    customStack.push(3) // stack becomes [1, 2, 3]

    customStack.push(4) // stack still [1, 2, 3], Don't add another elements as size is 4

    customStack.increment(5, 100) // stack becomes [101, 102, 103]

    customStack.increment(2, 100) // stack becomes [201, 202, 103]

    customStack.pop() // return 103 --> Return top of the stack 103, stack becomes [201, 202]

    customStack.pop() // return 202 --> Return top of the stack 102, stack becomes [201]

    customStack.pop() // return 201 --> Return top of the stack 101, stack becomes []

    customStack.pop() // return -1 --> Stack is empty return -1.
}

/*

 */
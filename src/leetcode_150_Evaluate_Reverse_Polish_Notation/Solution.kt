package leetcode_150_Evaluate_Reverse_Polish_Notation

import java.util.Stack

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        for (t in tokens) {
            if (t in arrayOf("+", "-", "*", "/")) {
                val n1 = stack.pop()
                val n2 = stack.pop()
                val eval = when (t) {
                    "+" -> n2 + n1
                    "-" -> n2 - n1
                    "*" -> n2 * n1
                    else -> n2 / n1
                }
                println(eval)
                stack.push(eval)
            } else {
                stack.push(t.toInt())
            }
        }
        return stack.first()
    }
}

fun main() {
    arrayOf(
        arrayOf("2", "1", "+", "3", "*") to 9,
        arrayOf("4", "13", "5", "/", "+") to 6,
        arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+") to 22,
    ).forEach { (inp, _) ->
        Solution().evalRPN(inp).let(::println)
    }
}
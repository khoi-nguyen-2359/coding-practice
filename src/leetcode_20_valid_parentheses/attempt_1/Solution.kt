package leetcode_20_valid_parentheses.attempt_1

import java.util.*

class Solution {

    fun isValid(s: String): Boolean {
        val validateStack = Stack<Char>()
        s.forEachIndexed { index, c ->
            when (c) {
                '(', '{', '[' -> validateStack.push(c)
                ')', '}', ']' -> {
                    if (validateStack.empty())
                        return false

                    val top = validateStack.pop()
                    if (!((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{'))) {
                        return false
                    }
                }
            }
        }

        return validateStack.isEmpty()
    }
}
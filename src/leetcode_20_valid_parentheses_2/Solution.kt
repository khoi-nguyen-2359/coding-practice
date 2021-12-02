package leetcode_20_valid_parentheses_2

class Solution {
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()
        for (i in s.indices) {
            when (s[i]) {
                '(', '{', '[' -> stack.add(s[i])
                ')', '}', ']' -> {
                    val last = stack.lastOrNull() ?: return false
                    stack.removeAt(stack.lastIndex)
                    if ((s[i] == ')' && last != '(') || (s[i] == '}' && last != '{') || (s[i] == ']' && last != '[')) {
                        return false
                    }
                }
            }
        }

        return stack.isEmpty()
    }
}
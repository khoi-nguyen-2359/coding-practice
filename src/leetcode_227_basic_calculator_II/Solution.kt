package leetcode_227_basic_calculator_II

class Solution {
    fun calculate(s: String): Int {
        var result = 0
        var outerOperator = '+'
        var localOperand = 0
        var localOperator = '*'
        var localResult = 1
        for (i in s.indices) {
            if (s[i].isDigit()) {
                localOperand = localOperand * 10 + (s[i] - '0')

                if (i == s.length - 1 || !s[i + 1].isDigit()) {
                    when (localOperator) {
                        '*' -> localResult *= localOperand
                        '/' -> localResult /= localOperand
                    }
                    localOperand = 0
                }
            } else if (s[i] == '*' || s[i] == '/') {
                localOperator = s[i]
            }

            if (s[i] == '+' || s[i] == '-' || i == s.length - 1) {
                when (outerOperator) {
                    '+' -> result += localResult
                    '-' -> result -= localResult
                }
                localOperator = '*'
                localResult = 1

                outerOperator = s[i]
            }
        }

        return result
    }

}

fun main() {
    Solution().calculate("3+2*2").also(::println)
}
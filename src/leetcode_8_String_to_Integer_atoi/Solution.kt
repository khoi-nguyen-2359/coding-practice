package leetcode_8_String_to_Integer_atoi

import kotlin.test.assertEquals

class Solution {
    fun myAtoi(s: String): Int {
        var firstSignPos = -1
        var firstDigitPos = -1
        var lastDigitPos = -1
        var firstLetterPos = -1
        for (i in s.indices) {
            when (s[i]) {
                '-', '+' -> {
                    if (firstSignPos == -1) {
                        firstSignPos = i
                    }
                }
                in '0' .. '9' -> {
                    if (firstDigitPos == -1) {
                        firstDigitPos = i
                    }
                    if (lastDigitPos == -1 && (i == s.length - 1 || !s[i + 1].isDigit())) {
                        lastDigitPos = i
                    }
                }
                ' ' -> { }
                else -> {
                    if (firstLetterPos == -1) {
                        firstLetterPos = i
                    }
                }
            }
        }

        if (firstDigitPos == -1 || (firstLetterPos != -1 && firstDigitPos > firstLetterPos) || (firstSignPos != -1 && firstSignPos < firstDigitPos && firstDigitPos - firstSignPos != 1)) {
            return 0
        }

        val sign = if (firstSignPos != -1 && firstSignPos < firstDigitPos && s[firstSignPos] == '-') {
            -1
        } else {
            1
        }

        while (firstDigitPos < s.length && s[firstDigitPos] == '0') {
            ++firstDigitPos
        }

        var decExp = 1.0
        var num = 0
        for (i in lastDigitPos downTo firstDigitPos) {
            val d = (s[i] - '0')
            if (decExp >= 10000000000 || (decExp == 1000000000.0 && d > 2)) {
                return if (sign == 1) {
                    Int.MAX_VALUE
                } else {
                    Int.MIN_VALUE
                }
            }
            val add = (d * decExp).toInt()
            println(add)
            decExp *= 10
            if (sign == 1 && Int.MAX_VALUE - num < add) {
                return Int.MAX_VALUE
            }
            if (sign == -1 && Int.MIN_VALUE + num > - add) {
                return Int.MIN_VALUE
            }
            num += add
            println(num)
        }

        return num * sign
    }
}

fun main() {
    arrayOf(
        "42" to 42,
        "   -42" to -42,
        "4193 with words" to 4193,
        "004193 with words" to 4193,
        "  -004193 with words" to -4193,
        "  +-004193 with words" to 0,
        "  004193-+ with words" to 4193,
        "words and 987" to 0,
        "-91283472332" to -2147483648
    ).forEachIndexed { index, (inp, exp) ->
        println(inp)
        assertEquals(exp, Solution().myAtoi(inp))
        println(exp)
    }
}
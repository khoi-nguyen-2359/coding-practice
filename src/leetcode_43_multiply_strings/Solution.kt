package leetcode_43_multiply_strings

import kotlin.math.max

class Solution {
    fun multiply(num1: String, num2: String): String {
        var product = "0"
        for (i in num1.length - 1 downTo 0) {
            val n1 = num1[i]
            var p = multiply(n1, num2)
            repeat(num1.length - 1 - i) {
                p += '0'
            }
            product = sum(p, product)
        }
        return product.trimStart('0').ifEmpty { "0" }
    }

    private fun multiply(c: Char, num: String): String {
        val product = CharArray(num.length + 1)
        var carrier = 0
        for (i in num.length - 1 downTo 0) {
            val n = num[i]
            val p = (n - '0') * (c - '0') + carrier
            carrier = p / 10
            product[i + 1] = ((p % 10) + 48).toChar()
            if (i == 0) {
                product[i] = ((p / 10) + 48).toChar()
            }
        }

        println("$c * $num = $product")

        return String(product).trimStart('0').ifEmpty { "0" }
    }

    private fun sum(num1: String, num2: String): String {
        val maxLen = max(num1.length, num2.length)
        val sum = CharArray(maxLen + 1)
        var c = 0
        for (i in 0 until maxLen) {
            val n1 = num1.getOrElse(num1.length - i - 1) { '0' } - '0'
            val n2 = num2.getOrElse(num2.length - i - 1) { '0' } - '0'
            val s = n1 + n2 + c
            c = s / 10
            sum[maxLen - i] = ((s % 10) + 48).toChar()
            if (i == maxLen - 1) {
                sum[0] = ((s / 10) + 48).toChar()
            }
        }

        println("$num1 + $num2 = $sum")
        return String(sum).trimStart('0').ifEmpty { "0" }
    }
}

fun main() {
    Solution().multiply("123", "456").let(::println)
}
package leetcode_17_letter_combinations_of_a_phone_number

import java.lang.StringBuilder

class Solution {
    private val letterMap = mutableMapOf<Char, String>(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
    )

    private fun combine(combinations: MutableList<String>, combiner: StringBuilder, digits: String, i: Int) {
        if (i >= digits.length) {
            if (combiner.isNotEmpty()) {
                combinations.add(combiner.toString())
            }
            return
        }

        val d = digits[i]
        letterMap[d]?.forEach { c ->
            combiner.append(c)
            combine(combinations, combiner, digits, i + 1)
            combiner.deleteCharAt(combiner.length - 1)
        }
    }

    fun letterCombinations(digits: String): List<String> {
        val combinations = mutableListOf<String>()
        combine(combinations, StringBuilder(), digits, 0)
        return combinations
    }
}

fun main() {
    Solution().letterCombinations("246").also {
        it.forEach {
            println(it)
        }
    }
}
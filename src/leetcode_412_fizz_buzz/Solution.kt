package leetcode_412_fizz_buzz

class Solution {
    fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()
        for (i in 1..n) {
            if (i % 15 == 0) {
                result.add("FizzBuzz")
            } else if (i % 5 == 0) {
                result.add("Buzz")
            } else if (i % 3 == 0) {
                result.add("Fizz")
            } else {
                result.add(i.toString())
            }
        }

        return result
    }
}

fun main() {
    Solution().fizzBuzz(15).also {
        it.forEach { println(it) }
    }
}
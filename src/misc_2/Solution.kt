package misc_2

class Solution {
    var c = 0
    fun printAllPermutations(input: CharArray) {
        solve(input, 0)
    }

    private fun solve(input: CharArray, index: Int) {
        ++c
        for (i in index until input.size) {
            swap(input, i, index)
            if (index == input.size - 1) {
                input.forEach(::print)
                println()
            } else {
                solve(input, index + 1)
            }
            swap(input, i, index)
        }
    }

    private fun swap(input: CharArray, i: Int, j: Int) {
        val tmp = input[i]
        input[i] = input[j]
        input[j] = tmp
    }
}

class Solution2 {
    var c = 0
    fun printAllPermutations(input: CharArray) {
        solve(input, 0)
    }

    private fun solve(input: CharArray, index: Int) {
        ++c
        if (index == input.size - 1) {
            input.forEach(::print)
            println()
            return
        }

        for (i in index until input.size) {
            swap(input, i, index)
            solve(input, index + 1)
            swap(input, i, index)
        }
    }

    private fun swap(input: CharArray, i: Int, j: Int) {
        val tmp = input[i]
        input[i] = input[j]
        input[j] = tmp
    }
}

fun main() {
    Solution().apply {
        printAllPermutations("abcdef".toCharArray())
        println(c)
    }
}
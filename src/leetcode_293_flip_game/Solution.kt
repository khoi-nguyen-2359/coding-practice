package leetcode_293_flip_game

class Solution {
    fun generatePossibleNextMoves(currentState: String): List<String> {
        val result = mutableListOf<String>()
        for (i in 0..currentState.length - 2) {
            if (currentState[i] == '+' && currentState[i + 1] == '+') {
                result.add(currentState.replaceRange(i..i+1, "--"))
            }
        }

        return result
    }
}

fun main() {
    Solution().generatePossibleNextMoves("-++").also {
        it.forEach {
            println(it)
        }
    }
}
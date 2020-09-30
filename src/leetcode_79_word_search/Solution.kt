package leetcode_79_word_search

class Solution {

    private fun search(board: Array<CharArray>, i: Int, j: Int, word: String, letter: Int): Boolean {
        if (letter == word.length) {
            return true
        }

        val target = word[letter]
        if (board[i][j] != target) {
            return false
        }

        val rowOffsets = intArrayOf(0, 1, 0, -1)
        val colOffsets = intArrayOf(1, 0, -1, 0)
        for (d in 0..3) {
            val nextI = i + rowOffsets[d]
            val nextJ = j + colOffsets[d]
            if (nextI >= 0 && nextI < board.size && nextJ >= 0 && nextJ < board[i].size) {
                val tmp = board[i][j]
                board[i][j] = '0'
                if (search(board, nextI, nextJ, word, letter + 1))
                    return true
                board[i][j] = tmp
            }
        }

        return false
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (search(board, i, j, word, 0))
                    return true
            }
        }

        return false
    }
}

fun main() {
    val board = Array(3) {
        when (it) {
            0 -> charArrayOf('A', 'B', 'C', 'E')
            1 -> charArrayOf('S', 'F', 'C', 'S')
            else -> charArrayOf('A', 'D', 'E', 'E')
        }
    }
    val word = "SEE"
    Solution().exist(board, word).also(::println)
}
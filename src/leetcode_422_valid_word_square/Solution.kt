package leetcode_422_valid_word_square

class Solution {
    fun validWordSquare(words: List<String>): Boolean {
        words.forEachIndexed { indexS, string ->
            string.forEachIndexed { indexC, char ->
                if (char != words.getOrNull(indexC)?.getOrNull(indexS)) {
                    return false
                }
            }
        }

        return true
    }
}
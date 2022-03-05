package leetcode_2047_Number_of_Valid_Words_in_a_Sentence

class Solution {
    fun countValidWords(sentence: String): Int {
        val tokens = sentence.split(" ").filter { it.isNotEmpty() }
        var valid = 0
        for (i in tokens.indices) {
            var hasHyphen = false
            var isValid = true
            for (j in tokens[i].indices) {
                if (tokens[i][j].isDigit()) {
                    isValid = false
                    break
                }

                if (tokens[i][j] == '-') {
                    if (hasHyphen) {
                        isValid = false
                        break
                    }
                    hasHyphen = true

                    if (j == 0 || !tokens[i][j - 1].isLowerCase() || j == tokens[i].length - 1 || !tokens[i][j + 1].isLowerCase()) {
                        isValid = false
                        break
                    }
                }

                if (tokens[i][j] in arrayOf('!', '.', ',') && j != tokens[i].length - 1) {
                    isValid = false
                    break
                }
            }

            if (isValid) {
                ++valid
            }
        }

        return valid
    }
}
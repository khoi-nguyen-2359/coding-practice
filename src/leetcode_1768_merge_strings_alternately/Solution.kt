package leetcode_1768_merge_strings_alternately

class SolutionString {
    fun mergeAlternately(word1: String, word2: String): String = buildString {
        repeat(Math.max(word1.length, word2.length)) { index ->
            if (index < word1.length) {
                append(word1[index])
            }
            if (index < word2.length) {
                append(word2[index])
            }
        }
    }
}

class SolutionArray {
    fun mergeAlternately(word1: String, word2: String): String {
        val result = CharArray(word1.length + word2.length)
        var i = 0
        repeat(Math.max(word1.length, word2.length)) { index ->
            if (index < word1.length) {
                result[i++] = word1[index]
            }
            if (index < word2.length) {
                result[i++] = word2[index]
            }
        }
        return String(result)
    }
}
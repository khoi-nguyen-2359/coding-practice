package leetcode_68_Text_Justification

class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val result = mutableListOf<String>()
        var charCount = 0
        var wordCount = 0
        var firstWordIndex = 0
        var i = 0
        while (i < words.size) {
            if (maxWidth - charCount - words[i].length - wordCount < 0) {
                val line = makeLine(firstWordIndex, i - 1, words, maxWidth, charCount)
                result.add(line)
                charCount = 0
                wordCount = 0
                firstWordIndex = i
            } else {
                charCount += words[i].length
                ++wordCount
                ++i
            }
        }

        var lastLine = ""
        for (j in firstWordIndex until words.size) {
            lastLine += words[j] + " "
        }
        lastLine = lastLine.trim()
        repeat(maxWidth - lastLine.length) {
            lastLine += " "
        }
        if (lastLine.isNotEmpty()) {
            result.add(lastLine)
        }

        return result
    }

    private fun makeLine(begin: Int, end: Int, words: Array<String>, maxWidth: Int, charCount: Int): String {
        val paddingCount = (end - begin).coerceAtLeast(1)
        val spaceQuotient = (maxWidth - charCount) / paddingCount
        var spaceRemainder = (maxWidth - charCount) % paddingCount
        var line = ""
        for (i in begin..end) {
            line += words[i]
            repeat(spaceQuotient) {
                line += " "
            }
            if (spaceRemainder-- > 0) {
                line += " "
            }
        }
        return if (end == begin) {
            line
        } else {
            line.trim()
        }
    }
}

fun main() {
    val words = arrayOf("ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country")
    Solution().fullJustify(words, 16).forEach(::println)
}
package leetcode_394_decode_string

import java.lang.StringBuilder
import java.util.*

class Solution {
    fun decodeString(s: String): String {
        val startSegmentStack = Stack<IntRange>()
        var result = s
        var appendOffset = 0
        var lastAppend = -1
        var lastMultiplierIndex = -1
        for (i in s.indices) {
            if (s[i].isDigit()) {
                if (lastMultiplierIndex == -1)
                    lastMultiplierIndex = i
            } else if (s[i] == '[') {
                startSegmentStack.push(IntRange(lastMultiplierIndex, i - 1))
                lastMultiplierIndex = -1
            } else if (s[i] == ']') {
                val startSegmentRange = startSegmentStack.pop()
                val decodeSegmentRange: IntRange = if (lastAppend >= startSegmentRange.last + 2)
                    startSegmentRange
                else
                    IntRange(startSegmentRange.first + appendOffset, startSegmentRange.last + appendOffset)

                val decoded = StringBuilder()
                val multipleTime = s.substring(startSegmentRange).toInt()
                repeat(multipleTime) {
                    decoded.append(result.substring(decodeSegmentRange.last + 2, i + appendOffset))
                }
                result = result.substring(0, Integer.max(0, decodeSegmentRange.first)) + decoded + s.substring(i + 1)
                appendOffset += decoded.length - (1 + i - decodeSegmentRange.first)
                lastAppend = decodeSegmentRange.first
            }
        }

        return result
    }
}

fun main() {
    val s = "3[a]2[b4[F]c]"
    Solution().decodeString(s).also(::println)
}
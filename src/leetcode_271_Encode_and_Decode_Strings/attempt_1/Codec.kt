package leetcode_271_Encode_and_Decode_Strings.attempt_1

import kotlin.test.assertEquals

class Codec {
    // Encodes a list of strings to a single string.
    fun encode(strs: List<String>): String = buildString {
        strs.forEach { s ->
            append(intToStr(s.length))
            append(s)
        }
    }

    private fun intToStr(n: Int): String = buildString {
        repeat(4) { i ->
            val char = (n shr (i * 8) and 0xff).toChar()
            append(char)
        }
    }

    private fun strToInt(s: String, start: Int): Int {
        var num = 0
        repeat(4) { i ->
            num = (num shl 8) or s[start + 3 - i].toInt()
        }
        return num
    }
    
    // Decodes a single string to a list of strings.
    fun decode(s: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i < s.length) {
            val len = strToInt(s, i)
            result.add(s.substring(i + 4, i + 4 + len))
            i += len + 4
        }
        return result
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * val s = obj.encode(strs)
 * val ans = obj.decode(s)
 */

fun main() {
    arrayOf(
            listOf("a", "de", "xyz"),
            listOf("abc", "def", ""),
            listOf("", "", ""),
            listOf()
    ).forEach { input ->
        val codec = Codec()
        assertEquals(input, codec.decode(codec.encode(input)))
    }
}
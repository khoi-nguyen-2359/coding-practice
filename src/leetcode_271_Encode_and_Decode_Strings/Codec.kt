package leetcode_271_Encode_and_Decode_Strings

class Codec {
    // Encodes a list of strings to a single string.
    fun encode(strs: List<String>): String = buildString {
        strs.forEach { s ->
            val len = s.length
            repeat(4) { time ->
                val c = len shr (time * 8) and 0xff
                append('0' + c)
            }
            append(s)
        }
    }
    
    // Decodes a single string to a list of strings.
    fun decode(s: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i < s.length) {
            var len = 0
            repeat(4) { time ->
                len = (len shl 8) or (s[i + 3 - time] - '0')
            }
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
    ).forEach {
        val codec = Codec()
        val enc = codec.encode(it)
        val dec = codec.decode(enc)
        dec.forEach { println(it) }
        println("---")
    }
}
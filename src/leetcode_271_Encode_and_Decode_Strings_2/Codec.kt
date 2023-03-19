package leetcode_271_Encode_and_Decode_Strings_2

class Codec {
    // Encodes a list of strings to a single string.
    fun encode(strs: List<String>): String = buildString {
        strs.forEach { s ->
            val len = s.length.toChar()
            append(len)
            append(s)
        }
    }

    // Decodes a single string to a list of strings.
    fun decode(s: String): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i < s.length) {
            val len = s[i]
            result.add(s.substring(i + 1, i + len.code + 1))
            i += len.code + 1
        }
        return result
    }
}

/**
 * Your leetcode_271_Encode_and_Decode_Strings_2.Codec object will be instantiated and called as such:
 * var obj = leetcode_271_Encode_and_Decode_Strings_2.Codec()
 * val s = obj.encode(strs)
 * val ans = obj.decode(s)
 */

fun main() {
    val codec = Codec()
    val es = codec.encode(listOf("abc", "xyz", "o"))
    println(es)
    codec.decode(es).let(::println)
}
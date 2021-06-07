package leetcode_953_verifying_an_alien_dictionary_2

class Solution {
    private val orderMap = IntArray(26) { 0 }

    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        order.forEachIndexed { index, c -> orderMap[c - 'a'] = index }
        for (i in 0 .. words.size - 2) {
            if (isGreater(words[i], words[i + 1])) {
                return false
            }
        }

        return true
    }

    private fun isGreater(w1: String, w2: String): Boolean {
        val k = Math.min(w1.length - 1, w2.length - 1)
        for (i in 0..k) {
            val c1 = orderMap[w1[i] - 'a']
            val c2 = orderMap[w2[i] - 'a']
            if (c1 < c2)
                return false
            if (c1 > c2)
                return true
        }

        return w1.length > w2.length
    }
}

fun main() {
    val res = Solution().isAlienSorted(arrayOf("word", "world", "row"), "worldabcefghijkmnpqstuvxyz")
    println(res)
}
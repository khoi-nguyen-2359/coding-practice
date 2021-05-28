package leetcode_242_valid_anagram

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length)
            return false
        val sCharCounter = mutableMapOf<Char, Int>()
        s.forEach { sChar ->
            sCharCounter[sChar] = 1 + sCharCounter.getOrDefault(sChar, 0)
        }
        t.forEach { tChar ->
            val k = sCharCounter.getOrDefault(tChar, 0) - 1
            if (k < 0)
                return false
            sCharCounter[tChar] = k
        }

        return true
    }
}

fun main() {
    val res = Solution().isAnagram("rat", "car")
    println(res)
}
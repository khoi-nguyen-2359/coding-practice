package leetcode_345_reverse_vowels_of_a_string

class Solution {
    fun reverseVowels(s: String): String {
        var i = 0
        var j = s.length - 1
        val result = s.toCharArray()
        val vowels = arrayOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')
        while (i < j) {
            if (s[i] in vowels && s[j] in vowels) {
                val tmp = result[i]
                result[i] = result[j]
                result[j] = tmp
                ++i
                --j
            }
            if (i < s.length && s[i] !in vowels) {
                ++i
            }
            if (j >= 0 && s[j] !in vowels) {
                --j
            }
        }
        return String(result)
    }
}

class SolutionSwapOnClone {
    fun reverseVowels(s: String): String {
        var i = 0
        var j = s.length - 1
        val result = CharArray(s.length)
        while (i <= j) {
            while (i <= j && i < s.length && !s[i].isVowel()) {
                result[i] = s[i]
                ++i
            }
            while (i <= j && !s[j].isVowel()) {
                result[j] = s[j]
                --j
            }
            if (i <= j) {
                result[i] = s[j]
                result[j] = s[i]
            }
            ++i
            --j
        }

        return String(result)
    }

    private fun Char.isVowel() = when (this) {
        'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' -> true
        else -> false
    }
}
package leetcode_953_verifying_an_alien_dictionary.attempt_1

class Solution {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val alienDict = IntArray(order.length)
        order.forEachIndexed { index, c ->
            alienDict[c - 'a'] = index
        }

        for (i in 0..words.size - 2) {
            if (isGreater(words[i], words[i + 1], alienDict)) {
                return false
            }
        }

        return true
    }

    private fun isGreater(w1: String, w2: String, dict: IntArray): Boolean {
        w1.forEachIndexed { index, c ->
            if (index >= w2.length || dict[c - 'a'] > dict[w2[index] - 'a']) {
                return true
            } else if (dict[c - 'a'] < dict[w2[index] - 'a']) {
                return false
            }
        }

        return false
    }
}
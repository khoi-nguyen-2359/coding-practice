package leetcode_break_a_palindrome

class Solution {
    fun breakPalindrome(palindrome: String): String {
        var possibleIndex = -1
        run loop@{
            palindrome.forEachIndexed { index, char ->
                if (palindrome.length % 2 == 0 || index != palindrome.length / 2) {
                    possibleIndex = index
                    if (char != 'a') {
                        return@loop
                    }
                }
            }
        }

        if (possibleIndex == -1) {
            return ""
        }

        val replaceChar = if (palindrome[possibleIndex] == 'a') {
            palindrome[possibleIndex] + 1
        } else {
            'a'
        }
        return buildString {
            append(palindrome.subSequence(0, possibleIndex))
            append(replaceChar)
            append(palindrome.subSequence(possibleIndex + 1, palindrome.length))
        }
    }
}

fun main() {
    Solution().breakPalindrome("aba").also(::println)
}
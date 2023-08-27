package leetcode_66_Plus_One.attempt_2

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var carry = 1
        for (i in digits.size - 1 downTo 0) {
            val s = digits[i] + carry
            digits[i] = s % 10
            carry = s / 10
            if (carry == 0) {
                break
            }
        }
        if (carry == 0) {
            return digits
        }
        return IntArray(digits.size + 1) {
            if (it == 0) {
                carry
            } else {
                digits[it - 1]
            }
        }
    }
}

/*
Input: digits = [1,2,3]
Output:         [1,2,4]
 */
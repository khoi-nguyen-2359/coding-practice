package leetcode_66_Plus_One.attempt_1

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        val answer = IntArray(digits.size + 1)
        var carrier = 1
        for (i in digits.size - 1 downTo 0) {
            var sum = digits[i] + carrier
            carrier = sum / 10
            sum %= 10
            answer[i + 1] = sum
        }
        return if (carrier != 0) {
            answer[0] = 1
            answer
        } else {
            IntArray(digits.size) { index ->
                answer[index + 1]
            }
        }
    }
}

// Input: digits = [4,3,2,9]
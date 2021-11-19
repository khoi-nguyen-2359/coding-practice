package leetcode_461_hamming_distance

class Solution {
    fun hammingDistance(x: Int, y: Int): Int {
        var xorNum = x xor y
        var distance = 0
        while (xorNum != 0) {
            if (xorNum % 2 != 0)
                ++distance
            xorNum = xorNum shr 1
        }
        return distance
    }
}
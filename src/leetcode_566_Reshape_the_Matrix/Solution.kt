package leetcode_566_Reshape_the_Matrix

class Solution {
    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if (mat.size * mat[0].size != r * c) {
            return mat
        }
        var i = 0
        val result = Array(r) {
            IntArray(c)
        }
        for (row in mat) {
            for (num in row) {
                val ri = i / c
                val ci = i % c
                result[ri][ci] = num
                ++i
            }
        }
        return result
    }
}
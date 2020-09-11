package leetcode_973_k_closest_points_to_origin

class Solution {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        points.sortBy {
            it[0]*it[0] + it[1]*it[1]
        }

        return points.take(K).toTypedArray()
    }
}
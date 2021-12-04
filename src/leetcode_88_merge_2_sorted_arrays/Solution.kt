package leetcode_88_merge_2_sorted_arrays

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val nums1Copy = IntArray(m) { nums1[it] }
        var i = 0
        var j = 0
        var c = 0
        while (i < m || j < n) {
            if (i >= m || (j < n && nums1Copy[i] >= nums2[j])) {
                nums1[c] = nums2[j++]
            } else if (j >= n || (i < m && nums1Copy[i] <= nums2[j])) {
                nums1[c] = nums1Copy[i++]
            }
            ++c
        }
    }
}

fun main() {
    val nums1 = intArrayOf(1,2,3,0,0,0)
    Solution().merge(nums1, 3, intArrayOf(-2,-1,0), 3)
    nums1.forEach { println(it) }
}
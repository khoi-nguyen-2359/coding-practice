package leetcode_4_Median_of_Two_Sorted_Arrays_2

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val (A, B) = if (nums1.size < nums2.size) {
            nums1 to nums2
        } else {
            nums2 to nums1
        }

        var l = 0
        var r = A.size - 1
        var i: Int
        val totalLen = A.size + B.size
        while (true) {
            i = (l + r) / 2
            var j = totalLen / 2 - i - 2
            if (A.isEmpty()) {
               ++j
            }
            val aleft = if (A.isNotEmpty() && i >= 0) {
                A[i]
            } else {
                // make sure aleft <= bright
                Int.MIN_VALUE
            }
            val aright = if (i + 1 < A.size) {
                A[i + 1]
            } else {
                // make sure aright >= bleft
                Int.MAX_VALUE
            }
            val bleft = if (j >= 0) {
                B[j]
            } else {
                // make sure bleft <= aright
                Int.MIN_VALUE
            }
            val bright = if (j + 1 < B.size) {
                B[j + 1]
            } else {
                // make sure bright >= aleft
                Int.MAX_VALUE
            }

            // verify
            if (aleft <= bright && bleft <= aright) {
                // find and return median
                return if (totalLen % 2 == 0) {
                    0.5 * (Math.max(aleft, bleft) + Math.min(aright, bright))
                } else {
                    Math.min(aright, bright).toDouble()
                }
            } else if (aleft > bright) {
                r = i - 1
                if (r == -1) {
                    l = -1
                }
            } else {
                l = i + 1
                if (l == A.size) {
                    r = A.size
                }
            }
        }

        return -1.0
    }
}

fun main() {
    arrayOf(
            arrayOf(intArrayOf(1, 3), intArrayOf(2)),
            arrayOf(intArrayOf(1,2), intArrayOf(3,4)),
            arrayOf(intArrayOf(), intArrayOf(1,2)),
            arrayOf(intArrayOf(1,2), intArrayOf()),
    ).forEach {
        Solution().findMedianSortedArrays(it[0], it[1]).let(::println)
    }
}

/*
    O(m+n)
    1. merge 2 arrays: O(m+n)
    2. find the median: O(1)
      2.1. merged length is odd:  median = merged[length/2]
      2.2. merged length is even: median = 1/2 * merged[(len-1)/2] + merged[len/2]
 */

/*
    O(log(min(m,n))
    => Merge til left half
    A [0,2,4]               => i
    B [1,3,5,7,9,11,13]     => j
    => [0 1 2 3 4]  [5 7 9 11 13]   total len: 10, half: 5
        => i: 2
        => j: 1, next is 5
        => O((m+n)/2)
        => find the last index of each input array in left half of merged array (i,j)

    A [0,2,4]               => find the correct i
    B [1,3,5,7,9,11,13]     => find the correct j

    => find the i
        => find i on the shorter array
        => A contribute to the left half from 0 -> i element
        => use binary search to search i in A
    => find j base on i
        => j = half len - i - 2
    => verify if i and j are correct:
        => A[i] <= B[j+1]
           B[j] <= A[i+1]
    => find median:
        => total len is even:
            [...]   [...]
            1/2 * (max(A[i],B[j]) + min(A[i+1],B[j+1])
        => total len is odd:
            [...]   [x]   [...]
            min(A[i+1],B[j+1])
 */
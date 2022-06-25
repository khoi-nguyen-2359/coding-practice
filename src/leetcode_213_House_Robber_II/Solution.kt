package leetcode_213_House_Robber_II

class SolutionNSpace {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        val maxArray = Array(nums.size) { 0 to 0 }
        maxArray[0] = nums[0] to 0
        maxArray[1] = nums[0] to nums[1]
        var max1 = nums[0]
        var max2 = nums[1]
        for (i in 2 until maxArray.size) {
            val (prevMax1, prevMax2) = maxArray[i-2]
            if (i != maxArray.size - 1) {
                max1 = Math.max(max1, nums[i] + prevMax1)
            }
            max2 = Math.max(max2, nums[i] + prevMax2)
            maxArray[i] = max1 to max2
        }
        return Math.max(max1, max2)
    }
}

class SolutionConstantSpace {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        val max1 = robI(nums, 0, nums.size - 2)
        val max2 = robI(nums, 1, nums.size - 1)
        return Math.max(max1, max2)
    }

    private fun robI(nums: IntArray, start: Int, end: Int): Int {
        if (end <= start) {
            return nums[start]
        }
        var max = Math.max(nums[start], nums[start+1])
        var t0 = nums[start]
        var t1 = max
        for (i in start + 2 .. end) {
            max = Math.max(max, nums[i] + t0)
            t0 = t1
            t1 = max
        }
        return max
    }
}

fun main() {
    arrayOf(
            intArrayOf(7, 2, 3, 1, 1, 2, 3, 0),
            intArrayOf(7, 2, 3, 1, 1, 2, 3, 10),
            intArrayOf(7, 2, 3, 1, 1),
            intArrayOf(2, 7, 9, 3, 1),
            intArrayOf(1, 2, 3, 1),
            intArrayOf(2, 1, 1, 2),
            intArrayOf(2, 3, 2),
            intArrayOf(2, 3),
            intArrayOf(1, 2, 3),
            intArrayOf(1),
    ).forEach {
        SolutionConstantSpace().rob(it).let(::println)
    }
}

/*
7       2       3       1       1       2       3       10
(7,0)   (7,2)   (10,3)  (10,3)  (11,4)  (12,5)  (14,7)  (14,15)

2       3           2
(2,0)   (2,3)       (2,3)

1       2       3       1
(1,0)   (1,2)   (4,3)   (4,3)


 */
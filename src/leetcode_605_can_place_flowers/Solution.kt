package leetcode_605_can_place_flowers

class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0) {
            return true
        }
        var flowers = n
        for (i in flowerbed.indices) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] != 1) && (i == flowerbed.size - 1 || flowerbed[i + 1] != 1)) {
                flowerbed[i] = 1
                --flowers
                if (flowers == 0) {
                    return true
                }
            }
        }

        return false
    }
}

/**
 * Imagine there's one flower one item before the first slot, and also after the last slot.
 */
class SolutionNoInputModification {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0) {
            return true
        }
        var last = -2
        var f = n
        for (i in flowerbed.indices) {
            if (flowerbed[i] == 1) {
                f -= (i - last - 2) / 2
                if (f <= 0) {
                    return true
                }
                last = i
            }
        }
        if (last != flowerbed.size - 1) {
            f -= (flowerbed.size - last - 1) / 2
        }

        return f <= 0
    }
}
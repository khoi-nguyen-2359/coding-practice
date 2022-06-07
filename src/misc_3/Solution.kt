package misc_3

class Solution {
    fun numberOfCleanRooms(room: Array<IntArray>): Int {
        // current position
        var i = 0
        var j = 0

        // moving step
        var mi = 0
        var mj = 1

        var result = 0
        do {
            room[i][j] = 1
            ++result
            when {
                // can't go right -> go down
                mi == 0 && mj == 1 && (j + 1 >= room[i].size || room[i][j+1] == 1) -> {
                    mi = 1
                    mj = 0
                }
                // can't go down -> go left
                mi == 1 && mj == 0 && (i + 1 >= room.size || room[i+1][j] == 1) -> {
                    mi = 0
                    mj = -1
                }
                // can't go left -> go up
                mi == 0 && mj == -1 && (j - 1 < 0 || room[i][j-1] == 1) -> {
                    mi = -1
                    mj = 0
                }
                // can't go up -> go right
                mi == -1 && mj == 0 && (i - 1 < 0 || room[i-1][j] == 1) -> {
                    mi = 0
                    mj = 1
                }
            }

            i += mi
            j += mj
            if (i < 0 || j < 0 || i >= room.size || j >= room[i].size || room[i][j] == 1) {
                // the destination is either cleaned or out of scope
                break
            }
        } while (true)

        return result
    }
}

fun main() {
    Solution().numberOfCleanRooms(
            arrayOf(
                    intArrayOf(0,0,0),
                    intArrayOf(1,0,1),
            )
    ).let(::println)
}
/*
0 0 0
1 1 0
0 0 0

Input: room = [[0,1,0],[1,0,0],[0,0,0]]

 */
package hackerrank_Climbing_the_Leaderboard

/*
 * Complete the 'climbingLeaderboard' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY ranked
 *  2. INTEGER_ARRAY player
 */

fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    var i = player.size - 1
    var j = 0
    var rank = 0
    val result = Array(player.size) { 0 }
    while (i >= 0 || j < ranked.size) {
        if (i < 0 || (j < ranked.size && ranked[j] >= player[i])) {
            if (j == 0 || ranked[j] != ranked[j - 1]) {
                // set ranking for the ranked score array while merging
                ++rank
            }
            ++j
        } else {
            // determine the rank when merging player score
            result[i] = if (j == 0 || player[i] != ranked[j-1]) {
                rank + 1
            } else {
                rank
            }
            --i
        }
    }
    return result
}

/*
7
100 100 50 40 40 20 10
4
5 25 50 120

4
120 50 25 5
7
10 20 40 40 50 100 100
 */

fun main(args: Array<String>) {
    val rankedCount = readLine()!!.trim().toInt()

    val ranked = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val playerCount = readLine()!!.trim().toInt()

    val player = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = climbingLeaderboard(ranked, player)

    println(result.joinToString("\n"))
}

package leetcode_997_find_the_town_judge

class SolutionHashMap {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val possibleJudges = HashMap<Int, Int>()
        repeat(n) { possibleJudges[it + 1] = 0 }
        for (t in trust) {
            possibleJudges.remove(t[0])
            if (possibleJudges.containsKey(t[1])) {
                possibleJudges[t[1]] = (possibleJudges[t[1]] ?: 0) + 1
            }
        }

        if (possibleJudges.size == 1) {
            val judge = possibleJudges.entries.firstOrNull()
            if (judge?.value == n - 1) {
                return judge.key
            }
        }

        return -1
    }
}

class SolutionArray {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val possibleJudges = Array(n) { 0 }
        for (t in trust) {
            possibleJudges[t[0] - 1] -= 1
            possibleJudges[t[1] - 1] += 1
        }

        var judge = -1
        for (i in possibleJudges.indices) {
            if (possibleJudges[i] == n - 1) {
                if (judge != -1) {
                    return -1 // found 2 judges!
                } else {
                    judge = i + 1
                }
            }
        }

        return judge
    }
}
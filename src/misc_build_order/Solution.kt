package misc_build_order

import java.util.LinkedList
import kotlin.test.assertEquals

/*
Build Order: You are given a list of projects and a list of dependencies
(which is a list of pairs of projects, where the second project is dependent on the first project).
All of a project's dependencies must be built before the project is.
Find a build order that will allow the projects to be built.
If there is no valid build order, return an error.
EXAMPLE Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
Output: f, e, a, b, d, c
 */

class Solution {
    fun getBuildOrder(projects: Array<String>, dependencies: Array<Array<String>>): List<String> {
        val buildLevels = mutableMapOf<String, Int>()
        projects.forEach { buildLevels[it] = 0 }
        val adjs = mutableMapOf<String, MutableList<String>>()
        dependencies.forEach { pair ->
            adjs.computeIfAbsent(pair[0]) { mutableListOf() }.add(pair[1])
            buildLevels[pair[1]] = (buildLevels[pair[1]] ?: 0) + 1
        }

//        projects.forEach {
//            print("$it ")
//            println(buildLevels[it] ?: 0)
//        }

        return buildList {
            while (buildLevels.isNotEmpty()) {
                buildLevels.filter { it.value == 0 }.map { it.key }.forEach {
                    add(it)
                    buildLevels.remove(it)
                    adjs[it]?.forEach { p ->
                        buildLevels[p] = (buildLevels[p] ?: 0) - 1
                    }
                }
            }
        }
    }
}

fun main() {
    arrayOf(
            arrayOf("f", "e", "a", "b", "d", "c") to arrayOf(
                    arrayOf("a", "d"),
                    arrayOf("f", "b"),
                    arrayOf("b", "d"),
                    arrayOf("f", "a"),
                    arrayOf("d", "c"),
            ) to listOf("f", "e", "a", "b", "d", "c")
    ).forEach { (input, exp) ->
        assertEquals(exp, Solution().getBuildOrder(input.first, input.second))
    }
}

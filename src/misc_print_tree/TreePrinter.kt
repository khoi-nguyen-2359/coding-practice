package misc_print_tree

import java.util.Stack

class TreePrinter {
    private val horizontalLink = " - "
    private val verticalLink = " | "
    fun printTree(input: List<Relation>) {
        // 1. process input: build the tree nodes from list of relations
        val nodeMap = mutableMapOf<String, Node>()
        val parentSet = mutableSetOf<Node>() // keep track of all nodes that do not have parent to find root
        for (rel in input) {
            val parentNode = nodeMap.computeIfAbsent(rel.parent) { Node(rel.parent) }
            val childNode = nodeMap.computeIfAbsent(rel.child) { Node(rel.child) }
            childNode.parent = parentNode
            parentNode.children.add(childNode)
            if (parentNode.parent == null) {
                parentSet.add(parentNode)
            } else {
                parentSet.remove(parentNode)
            }
        }

        val root = parentSet.first() // should be only one root for valid inputs
//        println(root.name)

        /*
         2. print tree, formats:
         =>  A - B - C - C1
                   |   |-C2
                   |   |-C3
                   |-D - D1
                       |-D2

           A
           |
           B-------
           |        \
           C------    D
           |  \    \
           C1   C2  C3
        */

        val stack = Stack<Pair<Node, NodeExtra>>()
        stack.push(root to NodeExtra(0, true))
        var breakLine = false
        val levelLenMap = mutableMapOf<Int, Int>()
        levelLenMap[0] = root.name.length
        val hasChildSet = mutableSetOf<Int>()
        while (stack.isNotEmpty()) {
            val (node, extra) = stack.pop()
            val (level, isLastChild) = extra
            levelLenMap[level] = node.name.length
            if (breakLine) {
                printIndent(level, levelLenMap, hasChildSet)
            }
            if (isLastChild) {
                hasChildSet.remove(level - 1)
            }
            breakLine = printNode(node, hasChildSet, level)
            for (i in node.children.size - 1 downTo 0) {
                stack.push(node.children[i] to NodeExtra(level + 1, i == node.children.size - 1))
            }
        }
    }

    private fun printNode(node: Node, hasChildSet: MutableSet<Int>, level: Int): Boolean {
        print(node.name)
        return if (node.children.isEmpty()) {
            println()
            true
        } else {
            print(horizontalLink)
            hasChildSet.add(level)
            false
        }
    }

    private fun printIndent(level: Int, levelLenMap: MutableMap<Int, Int>, hasChildSet: Set<Int>) {
        repeat(level) {
            repeat((levelLenMap[it] ?: 0)) {
                print(' ')
            }
            if (hasChildSet.contains(it)) {
                print(verticalLink)
            } else {
                repeat(horizontalLink.length) { print(' ') }
            }
        }
    }

    class Node(
            val name: String, // assume name is unique
            val children: MutableList<Node> = mutableListOf(),
            var parent: Node? = null
    ) {
        override fun hashCode(): Int {
            return name.hashCode()
        }

        override fun equals(other: Any?): Boolean {
            return name == (other as? Node)?.name
        }
    }

    data class NodeExtra(
            val level: Int,
            val isLastChild: Boolean
    )
}

class Relation(val parent: String, val child: String)

fun main() {
    arrayOf(
            listOf(
                    Relation("meta-lifeform", "lifeform"),
                    Relation("mammal", "whale"),
                    Relation("animal", "mammal"),
                    Relation("animal", "bird"),
                    Relation("lifeform", "animal"),
                    Relation("cat", "lion"),
                    Relation("mammal", "cat"),
                    Relation("animal", "fish"),
                    Relation("bird", "pigeon"),
                    Relation("bird", "raven"),
                    Relation("cat", "3-body cat"),
                    Relation("cat", "wild cat"),
                    Relation("fish", "goldfish"),
                    Relation("fish", "guppy"),
                    Relation("fish", "swordfish"),
                    Relation("lifeform", "human"),
                    Relation("human", "khoi"),
            )
    ).forEach {
        TreePrinter().printTree(it)
    }
}
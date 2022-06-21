package leetcode_208_Implement_Trie

class Trie {
    private val root: Node = Node()

    fun insert(word: String) {
        var (node, index) = commonPrefix(word)
        for (i in index until word.length) {
            val insertNode = Node()
            node[word[i]] = insertNode
            node = insertNode
        }
        node.setEnd()
    }

    private fun commonPrefix(word: String): Pair<Node, Int> {
        var curr = root
        var i = 0
        while (i < word.length) {
            curr = curr[word[i]] ?: break
            ++i
        }
        return curr to i
    }

    fun search(word: String): Boolean {
        val (node, index) = commonPrefix(word)
        return index == word.length && node.isEnd()
    }

    fun startsWith(prefix: String): Boolean {
        val (_, index) = commonPrefix(prefix)
        return index == prefix.length
    }

    class Node(private val children: Array<Node?>? = Array(CHILD_CAPACITY) { null }) {
        operator fun get(name: Char): Node? = children?.get(name - 'a')
        operator fun set(name: Char, node: Node?) = children?.set(name - 'a', node)
        fun setEnd() {
            children?.set(CHILD_CAPACITY - 1, Node( null))
        }
        fun isEnd(): Boolean = children?.get(CHILD_CAPACITY - 1) != null

        companion object {
            private const val CHILD_CAPACITY = 27
        }
    }
}

fun main() {
    val trie = Trie()
    trie.insert("AB")
    trie.insert("ABCD")
    trie.insert("ABE")
    trie.insert("ABCDEF")
    trie.insert("ABCDEX")
    println()
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
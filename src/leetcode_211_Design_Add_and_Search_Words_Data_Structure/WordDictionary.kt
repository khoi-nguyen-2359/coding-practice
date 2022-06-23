package leetcode_211_Design_Add_and_Search_Words_Data_Structure

class WordDictionary() {
    private val root: Node = Node('*')

    fun addWord(word: String) {
        var currNode = root
        for (char in word) {
            val childNode = currNode[char] ?: Node(char)
            currNode[char] = childNode
            currNode = childNode
        }
        currNode.setEnd()
    }

    fun search(word: String): Boolean = searchNode(root, word, 0)

    private fun searchNode(node: Node?, word: String, start: Int): Boolean {
        var currIndex = start
        var currNode = node
        while (currNode != null && currIndex < word.length) {
            if (word[currIndex] == '.') {
                for (child in currNode.children) {
                    if (searchNode(child, word, currIndex + 1)) {
                        return true
                    }
                }
                return false
            } else {
                currNode = currNode[word[currIndex++]]
            }
        }

        return currNode?.isEnd() == true
    }

    class Node(val char: Char, val children: Array<Node?> = Array(27) { null } ) {
        fun setEnd() {
            children[IS_END_INDEX] = Node('#')
        }

        fun isEnd(): Boolean = children[IS_END_INDEX] != null

        operator fun get(char: Char): Node? = children[char - 'a']
        operator fun set(char: Char, node: Node?) { children[char - 'a'] = node }

        companion object {
            private const val IS_END_INDEX = 26
        }
    }
}

fun main() {
    val wordDictionary = WordDictionary()
    wordDictionary.addWord("bad")
    wordDictionary.addWord("dad")
    wordDictionary.addWord("mad")

    arrayOf(
            "pad",
            "bad",
            ".ad",
            "b..",
            "...",
            ".a.",
            "k.a",
            ".am",
            "",
            "m",
            ".",
    ).forEach {
        wordDictionary.search(it).let(::println)
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */
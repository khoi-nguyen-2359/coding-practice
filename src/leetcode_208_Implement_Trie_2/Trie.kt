package leetcode_208_Implement_Trie_2

class Trie() {
    private val root: Node = Node()

    fun insert(word: String) {
        var node = root
        word.forEach { char ->
            var child = node.childrens[char]
            if (child == null) {
                child = Node()
                node.childrens[char] = child
            }
            node = child
        }
        node.childrens['*'] = Node()
    }

    fun search(word: String): Boolean {
        var node = root
        word.forEach { char ->
            node = node.childrens[char] ?: return false
        }

        return node.childrens['*'] != null
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        prefix.forEach { char ->
            node = node.childrens[char] ?: return false
        }

        return true
    }

    private class Node {
        val childrens = mutableMapOf<Char, Node>()
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */

fun main() {
    val trie = Trie()
    trie.insert("apple")
    trie.search("apple").also(::println)
    trie.search("app").also(::println)
    trie.startsWith("app").also(::println)
    trie.insert("app")
    trie.search("app").also(::println)
}
package leetcode_1286_iterator_for_combination

class CombinationIterator(characters: String, combinationLength: Int) {
    private val _characters = characters
    private val pointers = IntArray(combinationLength) { it }
    private var hasNext = true

    fun next(): String {
        val result = buildString {
            for (pointer in pointers) {
                append(_characters[pointer])
            }
        }

        var curr = pointers.size - 1
        while (curr >= 0 && _characters.length - pointers[curr] <= pointers.size - curr) {
            --curr
        }

        if (curr >= 0) {
            ++pointers[curr]
            for (i in curr + 1 until pointers.size) {
                pointers[i] = pointers[i - 1] + 1
            }
        } else {
            hasNext = false
        }

        return result
    }

    fun hasNext(): Boolean {
        return hasNext
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * var obj = CombinationIterator(characters, combinationLength)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */


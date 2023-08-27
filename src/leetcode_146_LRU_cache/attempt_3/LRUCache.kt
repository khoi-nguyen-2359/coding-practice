package leetcode_146_LRU_cache.attempt_3

class LRUCache(private val capacity: Int) {
    fun print() {
        var curr: Entry? = head?.next
        while (curr != null) {
            print("(${curr.key} ${curr.value}) ")
            curr = curr.next
            if (curr === tail) {
                break
            }
        }
        println()
    }

    private class Entry(val key: Int, val value: Int) {
        var prev: Entry? = null
        var next: Entry? = null
    }

    private val data: MutableMap<Int, Entry> = mutableMapOf()
    private var tail: Entry? = null
    private var head: Entry? = null

    init {
        head = Entry(-1,-1)
        tail = Entry(-1,-1)
        head?.next = tail
        tail?.prev = head
    }

    fun put(key: Int, value: Int) {
        val entry = data[key]
        if (entry != null) {
            entry.prev?.next = entry.next
            entry.next?.prev = entry.prev
            entry.next = null
            entry.prev = null
        } else {
            if (data.size == capacity) {
                val removedHead = data.remove(head?.next?.key)
                head?.next = removedHead?.next
                removedHead?.next?.prev = head
                removedHead?.next = null
                removedHead?.prev = null
            }
        }

        val newEntry = Entry(key, value)
        tail?.prev?.next = newEntry
        newEntry.prev = tail?.prev
        tail?.prev = newEntry
        newEntry.next = tail

        data[key] = newEntry
        println("put ($key ${newEntry.value})")
        print()
        // remove exist entry if any
        // add new entry at tail
    }

    fun get(key: Int): Int {
        val entry = data[key]
                ?: run {
                    println(" get $key: -1")
                    return -1
                }

        entry.prev?.next = entry.next
        entry.next?.prev = entry.prev
        entry.next = null
        entry.prev = null

        tail?.prev?.next = entry
        entry.prev = tail?.prev
        tail?.prev = entry
        entry.next = tail

        println(" get: ($key ${entry.value})")
        print()

        return entry.value
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

fun main() {
    val lRUCache = LRUCache(3)
    lRUCache.put(1, 1)
    lRUCache.put(2, 2)
    lRUCache.put(3, 3)
    lRUCache.put(4, 4)
    lRUCache.get(4)
    lRUCache.get(3)
//    lRUCache.print()
    lRUCache.get(2)
    lRUCache.get(1)
    lRUCache.put(5, 5)
    lRUCache.get(1)
    lRUCache.get(2)
    lRUCache.get(3)
    lRUCache.get(4)
    lRUCache.get(5)
//    lRUCache.print()
}
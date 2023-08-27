package leetcode_146_LRU_cache.attempt_1

class LRUCache(private val capacity: Int) {

    class Entry(val key: Int, var value: Int) {
        var prev: Entry? = null
        var next: Entry? = null
    }

    private var head: Entry? = null
    private var tail: Entry? = null
    private val cache = mutableMapOf<Int, Entry>()

    fun get(key: Int): Int {
        val current = cache[key]
        if (current != null) {
            val found = current.value
            moveToTail(current)
            return found
        }

        return -1
    }

    fun put(key: Int, value: Int) {
        if (capacity <= 0)
            return

        if (head == null || tail == null) {
            // first entry
            val firstEntry = Entry(key, value)
            cache[key] = firstEntry
            head = firstEntry
            tail = head
            return
        }

        // search for duplicated key
        val current = cache[key]
        if (current != null) {
            current.value = value
            moveToTail(current)
            return
        }

        // no duplicated key, add new entry at tail
        val newEntry = Entry(key, value)
        cache[key] = newEntry
        newEntry.prev = tail
        tail?.next = newEntry
        tail = newEntry
        if (cache.size > capacity) {
            head?.key?.let(cache::remove)
            head = head?.next
            head?.prev = null
        }
    }

    private fun moveToTail(current: Entry) {
        if (current == tail)
            return

        if (current.prev == null) {
            // current is at head
            head = current.next
            head?.prev = null
        } else {
            current.prev?.next = current.next
            current.next?.prev = current.prev
        }
        tail?.next = current
        current.next = null
        current.prev = tail
        tail = current
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

fun main() {
    val lRUCache = LRUCache(2)
    lRUCache.put(1, 1) // cache is {1=1}

    lRUCache.put(2, 2) // cache is {1=1, 2=2}

    lRUCache.get(1).also(::println) // return 1

    lRUCache.put(3, 3) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}

    lRUCache.get(2).also(::println) // returns -1 (not found)

    lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}

    lRUCache.get(1).also(::println) // return -1 (not found)

    lRUCache.get(3).also(::println) // return 3

    lRUCache.get(4).also(::println) // return 4

}
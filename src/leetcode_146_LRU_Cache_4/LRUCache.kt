package leetcode_146_LRU_Cache_4

class LRUCache(capacity: Int) {
    private val capacity = capacity
    private val map = mutableMapOf<Int, Node?>()
    private val tail = Node(-1, -1)
    private val head = Node(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key]
        if (node != null) {
            shift(node)
        }
        return node?.data ?: -1
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) {
            return
        }
        val node = map[key]
        if (node != null) {
            node.data = value
            shift(node)
        } else {
            if (map.size == capacity) {
                val lru = tail.prev
                if (lru != null) {
                    // reuse the lru node, update key, value
                    map.remove(lru.key)
                    lru.key = key
                    lru.data = value
                    shift(lru)
                }
                map[key] = lru
            } else {
                // create new node at head
                val newHead = Node(key, value)
                newHead.prev = head
                newHead.next = head.next
                head.next?.prev = newHead
                head.next = newHead
                map[key] = newHead
            }
        }
    }

    // set node as recently used by shifting to the head
    private fun shift(node: Node) {
        if (head.next == node) {
            return
        }
        val headNext = head.next
        val nodePrev = node.prev
        val nodeNext = node.next

        nodePrev?.next = nodeNext
        nodeNext?.prev = nodePrev

        node.prev = head
        node.next = headNext

        head.next = node
        headNext?.prev = node
    }

    class Node(
        var key: Int,
        var data: Int,
        var prev: Node? = null,
        var next: Node? = null
    )
}
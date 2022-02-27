package leetcode_146_LRU_cache_2

class LRUCache(private val capacity: Int) {
    class ListNode(val key: Int, var value: Int) {
        var next: ListNode? = null
    }

    private var data: ListNode = ListNode(-1, -1)
    private var currentSize = 0

    fun print() {
        var curr: ListNode? = data.next
        while (curr != null) {
            println("${curr.key} ${curr.value}")
            curr = curr.next
        }
    }

    fun put(key: Int, value: Int) {
        val target = moveToHighestPriority(key)
        if (target.first == null) {
            if (currentSize == capacity) {
                data.next = data.next?.next
            } else {
                ++currentSize
            }
            if (data.next == null) {
                data.next = ListNode(key, value)
            } else {
                target.second?.next = ListNode(key, value)
            }
        } else {
            target.first?.value = value
        }
    }

    fun get(key: Int): Int {
        return moveToHighestPriority(key).first?.value ?: -1
    }

    private fun moveToHighestPriority(key: Int): Pair<ListNode?, ListNode?> {
        var curr = data.next
        var target: ListNode? = null
        var targetPrev: ListNode? = data
        var tail: ListNode? = null
        while (curr != null) {
            if (curr.key == key) {
                target = curr
            }
            if (target == null) {
                targetPrev = curr
            }
            if (curr.next == null) {
                tail = curr
            }
            curr = curr.next
        }
//        println("${target?.value} ${tail?.value}")
        if (target != null && target != tail) {
            targetPrev?.next = target.next
            tail?.next = target
            target.next = null
        }
//        this.print()

        return target to tail
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
    lRUCache.get(4).also(::println)
    lRUCache.get(3).also(::println)
//    lRUCache.print()
    lRUCache.get(2).also(::println)
    lRUCache.get(1).also(::println)
    lRUCache.put(5, 5)
    lRUCache.print()
    lRUCache.get(1).also(::println)
    lRUCache.get(2).also(::println)
    lRUCache.get(3).also(::println)
    lRUCache.get(4).also(::println)
    lRUCache.get(5).also(::println)

}
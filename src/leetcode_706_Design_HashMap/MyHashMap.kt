package leetcode_706_Design_HashMap

class MyHashMap() {
    private class Node(var key: Int, var value: Int, var next: Node? = null)
    private val bucket = 2069
    private val data: Array<Node?> = Array(bucket) { null }

    fun put(key: Int, value: Int) {
        val index = key % bucket
        if (data[index] == null) {
            data[index] = Node(key, value)
            return
        }
        var curr = data[index]
        var prev: Node? = null
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value
                return
            }
            prev = curr
            curr = curr.next
        }
        prev?.next = Node(key, value)
    }

    fun get(key: Int): Int {
        val index = key % bucket
        var curr = data[index]
        while (curr != null) {
            if (curr.key == key) {
                return curr.value
            }
            curr = curr.next
        }

        return -1
    }

    fun remove(key: Int) {
        val index = key % bucket
        if (data[index]?.key == key) {
            data[index] = data[index]?.next
            return
        }
        var curr = data[index]
        var prev: Node? = null
        while (curr != null) {
            if (curr.key == key) {
                prev?.next = curr.next
                return
            }
            prev = curr
            curr = curr.next
        }
    }

    fun printAll() {
        data.forEachIndexed { index, node ->
            print("[$index]: ")
            var curr = node
            while (curr != null) {
                print("(${curr.key}, ${curr.value}) -> ")
                curr = curr.next
            }
            println()
        }
        println()
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */

fun main() {
    val myHashMap = MyHashMap()
    myHashMap.put(1, 1) // The map is now [[1,1]]
    myHashMap.printAll()
    myHashMap.put(2, 2) // The map is now [[1,1], [2,2]]
    myHashMap.printAll()
    myHashMap.get(1) // return 1, The map is now [[1,1], [2,2]]
    myHashMap.printAll()
    myHashMap.get(3) // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    myHashMap.printAll()
    myHashMap.put(2, 1) // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    myHashMap.printAll()
    myHashMap.get(2) // return 1, The map is now [[1,1], [2,1]]
    myHashMap.printAll()
    myHashMap.remove(2) // remove the mapping for 2, The map is now [[1,1]]
    myHashMap.printAll()
    myHashMap.get(2) // return -1 (i.e., not found), The map is now [[1,1]]
    myHashMap.printAll()
}

/*
[null,null,null,null,null,-1,null,null,-1,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,90,null,-1,null,null,40,null,null,null,null,null,29,null,null,null,null,17,null,null,null,null,null,null,null,null,null,33,null,null,null,null,null,null,-1,null,null,-1,null,null,-1,35,null,null,null,null,null,null,null,-1,-1,null,null,null,null,null,-1,null,null,null,null,null,null,null,null,null,null,null,null,null,-1,null,null,null,null,87,null,null]
[null,null,null,null,null,-1,null,null,-1,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,90,null,-1,null,null,40,null,null,null,null,null,29,null,null,null,null,17,null,null,null,null,null,null,null,null,null,33,null,null,null,null,null,null,18,null,null,-1,null,null,-1,35,null,null,null,null,null,null,null,-1,-1,null,null,null,null,null,-1,null,null,null,null,null,null,null,null,null,null,null,null,null,-1,null,null,null,null,87,null,null]
 */
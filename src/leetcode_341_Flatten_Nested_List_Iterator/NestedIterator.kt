package leetcode_341_Flatten_Nested_List_Iterator

class NestedInteger {
    private var intValue: Int? = null
    private var listValue: MutableList<NestedInteger>? = null

    // Constructor initializes an empty nested list.
    constructor() {
        listValue = mutableListOf()
    }

    // Constructor initializes a single integer.
    constructor(value: Int) {
        intValue = value
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean = intValue != null

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? = intValue

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit {
        intValue = value
        listValue = null
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit {
        intValue = null
        listValue = mutableListOf()
        listValue?.add(ni)
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>? = listValue
}

class NestedIterator(nestedList: List<NestedInteger>) {
    private val flattenList: List<Int>
    private var next: Int = -1
    init {
        flattenList = flatten(nestedList)
    }

    private fun flatten(nestedList: List<NestedInteger>): List<Int> {
        val result = mutableListOf<Int>()
        for (list in nestedList) {
            if (list.isInteger()) {
                val intValue = list.getInteger() ?: break
                result.add(intValue)
            } else {
                val listValue = list.getList() ?: break
                val flattenList = flatten(listValue)
                result.addAll(flattenList)
            }
        }

        return result
    }

    fun next(): Int = flattenList[next]

    fun hasNext(): Boolean {
        if (next + 1 < flattenList.size) {
            ++next
            return true
        }
        return false
    }
}

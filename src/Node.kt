class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()

    companion object {
        fun fromAdjList(adjs: List<List<Int>>): Node? {
            val nodeMap = mutableMapOf<Int, Node>()
            for (i in adjs.indices) {
                val nodeVal = i + 1
                val node = nodeMap.computeIfAbsent(nodeVal) { Node(nodeVal) }
                for (neighborValue in adjs[i]) {
                    val neighborNode = nodeMap.computeIfAbsent(neighborValue) { Node(neighborValue) }
                    node.neighbors.add(neighborNode)
                }
            }
            return nodeMap[1]
        }
    }
}
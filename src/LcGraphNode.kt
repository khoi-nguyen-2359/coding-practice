class LcGraphNode(var `val`: Int) {
    var neighbors: ArrayList<LcGraphNode?> = ArrayList()

    companion object {
        fun fromAdjList(adjs: List<List<Int>>): LcGraphNode? {
            val nodeMap = mutableMapOf<Int, LcGraphNode>()
            for (i in adjs.indices) {
                val nodeVal = i + 1
                val node = nodeMap.computeIfAbsent(nodeVal) { LcGraphNode(nodeVal) }
                for (neighborValue in adjs[i]) {
                    val neighborNode = nodeMap.computeIfAbsent(neighborValue) { LcGraphNode(neighborValue) }
                    node.neighbors.add(neighborNode)
                }
            }
            return nodeMap[1]
        }
    }
}
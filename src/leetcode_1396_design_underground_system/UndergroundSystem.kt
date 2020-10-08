package leetcode_1396_design_underground_system

class UndergroundSystem() {

    private val checkInMap = mutableMapOf<Int, Pair<String, Int>>()
    private val travelRecords = mutableMapOf<String, Pair<Int, Int>>()

    fun checkIn(id: Int, stationName: String, t: Int) {
        checkInMap[id] = Pair(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val checkInEntry = checkInMap[id]
                ?: return
        checkInMap.remove(id)

        val duration = t - checkInEntry.second
        val recordLabel = makeRecordLabel(checkInEntry.first, stationName)
        var recorded = travelRecords[recordLabel]
        if (recorded == null) {
            recorded = Pair(0, 0)
            travelRecords[recordLabel] = recorded
        }
        travelRecords[recordLabel] = recorded.copy(recorded.first + 1, recorded.second + duration)
    }

    private fun makeRecordLabel(startStation: String, endStation: String): String {
        return "$startStation-$endStation"
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val recordLabel = makeRecordLabel(startStation, endStation)
        val recorded = travelRecords[recordLabel]
                ?: return 0.0
        return recorded.second / recorded.first.toDouble()
    }

}

fun main() {
    val undergroundSystem = UndergroundSystem()
    undergroundSystem.checkIn(45, "Leyton", 3)
    undergroundSystem.checkIn(32, "Paradise", 8)
    undergroundSystem.checkIn(27, "Leyton", 10)
    undergroundSystem.checkOut(45, "Waterloo", 15)
    undergroundSystem.checkOut(27, "Waterloo", 20)
    undergroundSystem.checkOut(32, "Cambridge", 22)
    undergroundSystem.getAverageTime("Paradise", "Cambridge") // return 14.00000. There was only one travel from "Paradise" (at time 8) to "Cambridge" (at time 22)

    undergroundSystem.getAverageTime("Leyton", "Waterloo") // return 11.00000. There were two travels from "Leyton" to "Waterloo", a customer with id=45 from time=3 to time=15 and a customer with id=27 from time=10 to time=20. So the average time is ( (15-3) + (20-10) ) / 2 = 11.00000

    undergroundSystem.checkIn(10, "Leyton", 24)
    undergroundSystem.getAverageTime("Leyton", "Waterloo") // return 11.00000

    undergroundSystem.checkOut(10, "Waterloo", 38)
    undergroundSystem.getAverageTime("Leyton", "Waterloo").also(::println) // return 12.00000

}
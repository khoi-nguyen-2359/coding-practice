package leetcode_1603_Design_Parking_System

class ParkingSystem(big: Int, medium: Int, small: Int) {
    private var bigSlots = big
    private var mediumSlots = medium
    private var smallSlots = small

    fun addCar(carType: Int): Boolean {
        val remain = when (carType) {
            1 -> --bigSlots
            2 -> --mediumSlots
            else -> --smallSlots
        }
        return remain >= 0
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */
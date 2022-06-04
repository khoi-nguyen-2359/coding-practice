package leetcode_359_Logger_Rate_Limiter_2

class Logger() {
    val messageCache = mutableMapOf<String, Int>()
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        // trim the cache to 10-sec
        messageCache.filter { it.value <= timestamp - 10 }
                .keys
                .forEach { messageCache.remove(it) }

        val shouldPrint = !messageCache.contains(message)
        if (shouldPrint) {
            messageCache[message] = timestamp
        }

        return shouldPrint
    }
}

fun main() {
    arrayOf(
            arrayOf(
                    1 to "foo",
                    2 to "bar",
                    3 to "foo",
                    8 to "bar",
                    10 to "foo",
                    11 to "foo",
            )
    ).forEach {
        val logger = Logger()
        it.forEach {
            logger.shouldPrintMessage(it.first, it.second).let(::println)
        }
        println("--")
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * var obj = Logger()
 * var param_1 = obj.shouldPrintMessage(timestamp,message)
 */
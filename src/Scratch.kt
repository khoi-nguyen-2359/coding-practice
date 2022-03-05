@file:OptIn(DelicateCoroutinesApi::class, FlowPreview::class)

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.*

class Scratch {
    fun flatMapMerge() = runBlocking {
        val job = GlobalScope.launch {
            val streams = IntRange(0, 9).asFlow()
            val results = streams.flatMapMerge { num ->
                flowOf(num * 10)
            }
            results.collect {

            }
        }

        job.join()
    }

    fun buffer() = runBlocking {
        val streams = IntRange(0, 9).asFlow()
        streams
                .map {
                    if (it % 2 != 0) {
                        throw Exception("hey!")
                    }
                    it
                }
                .catch {
                    emitAll(flowOf(-1))
                }.collect {
                    println("output $it")
                }
    }
}

fun main() {
    Scratch().buffer()
}
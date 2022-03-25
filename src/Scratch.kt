@file:OptIn(DelicateCoroutinesApi::class, FlowPreview::class)

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

    fun errorHandling() = runBlocking {
        val streams = IntRange(0, 9).asFlow()
        try {
            streams
                    .map {
                        if (it % 2 != 0) {
                            throw Exception("hey!")
                        }
                        it
                    }
                .catch {
                    emit(-2)
                }
                    .collect {
                        println("output $it")
                    }
        } catch (ex: Exception) {
            println(ex.message)
        }
    }

    fun channel() = runBlocking {
        val flow = channelFlow<Int> {
        }
        flow.collect {
            println("collector 1: $it")
        }
        delay(3000)
        flow.collect {
            println("collector 2: $it")
        }
    }

    fun buffer() = runBlocking {
        channelFlow {
            repeat(10) {
                send(it)
                println("sent $it")
            }
        }
                .buffer(capacity = 100, BufferOverflow.SUSPEND)
                .collect {
                    delay(1000)
                    println("collect $it")
                }
    }

    fun threading() = runBlocking(Dispatchers.IO) {
        println("init on ${Thread.currentThread().name}")
        flow {
            repeat(3) {
                println("emit on ${Thread.currentThread().name}")
                emit(it)
            }
        }
                .map {
                    println("map 1 on ${Thread.currentThread().name}")
                }
                .flowOn(Dispatchers.Default)
                .map {
                    println("map 2 on ${Thread.currentThread().name}")
                }
                .collect {
                    println("collect on ${Thread.currentThread().name}")
                }
    }
}

fun main() {
    runBlocking {
        Scratch().threading()
    }
}
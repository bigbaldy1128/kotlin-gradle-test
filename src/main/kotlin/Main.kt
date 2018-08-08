import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) = runBlocking {
    val start = System.currentTimeMillis()
    val result = listOf(calc(44), calc(43))
            .map { p -> p.await() }
            .sum()
    val end = System.currentTimeMillis()
    println("elapseTime:${end - start},result:$result")
}

fun calc(x: Int) = async(CommonPool) {
    fab(x)
}

fun fab(num: Int): Int {
    if (num < 2) {
        return 1
    }
    return fab(num - 1) + fab(num - 2)
}

suspend fun calc2(x: Int): Int {
    return async(CommonPool) {
        fab(x)
    }.await()
}
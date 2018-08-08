fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    val result = fab(45)
    val end = System.currentTimeMillis()
    println("elapseTime:${end - start},result:$result")
}

fun fab(num: Int): Int {
    if (num < 2) {
        return 1
    }
    return fab(num - 1) + fab(num - 2)
}
fun main() {
    val (n, p) = nextInts()
    val ans = ((p - 1) * pow((p - 2).toLong(), (n - 1), (1e9 + 7).toLong())) % (1e9 + 7).toLong()
    println(ans.toInt())
}

private fun next(): String = readLine()!!
private fun nextInt(): Int = next().toInt()
private fun nextLong(): Long = next().toLong()
private fun nextStrings(): List<String> = next().split(" ")
private fun nextInts(): List<Int> = nextStrings().map(String::toInt)
private fun nextLongs(): List<Long> = nextStrings().map(String::toLong)

private fun <T> printList(l: List<T>) {
    println(l.joinToString(" "))
}

private fun <T> printArgs(vararg args: T) {
    val str = mutableListOf<String>()
    args.forEach { str.add(it.toString()) }
    printList(str)
}

fun pow(base: Long, exp: Int, mod: Long? = null): Long {
    return when (exp) {
        0 -> 1L
        1 -> base
        else ->
            if (mod == null) {
                pow(base * base, exp shr 1) * pow(base, exp and 1)
            } else {
                pow(base * base % mod, exp shr 1, mod) * pow(base, exp and 1, mod) % mod
            }
    }
}
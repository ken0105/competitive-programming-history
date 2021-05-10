fun main() {
    val (n, m) = nextLongs()
    val a = nextInts()
    val b = nextInts()
    val pattern = Array(2000200) { mutableListOf<Pair<Int, Int>>() }
    for (i in 0 until n) {
        for (j in 0 until m) {
            val total = a[i.toInt()] + b[j.toInt()]
            if (pattern[total].isEmpty()) {
                pattern[total].add(Pair(i.toInt(), j.toInt()))
            } else {
                println(pattern[total][0].first, pattern[total][0].second, i.toInt(), j.toInt())
                return
            }
        }
    }
    println(-1)
}

private fun next(): String = readLine()!!
private fun nextInt(): Int = next().toInt()
private fun nextLong(): Long = next().toLong()
private fun nextStrings(): List<String> = next().split(" ")
private fun nextInts(): List<Int> = nextStrings().map(String::toInt)
private fun nextLongs(): List<Long> = nextStrings().map(String::toLong)
private fun nextDoubles(): List<Double> = nextStrings().map(String::toDouble)
private fun doubleIntList(n: Int): Array<MutableList<Int>> = Array(n) { mutableListOf<Int>() }
private const val MOD = 1000000007L

private fun <T> printList(l: List<T>) {
    kotlin.io.println(l.joinToString(" "))
}

private fun <T> println(vararg args: T) {
    val str = mutableListOf<String>()
    args.forEach { str.add(it.toString()) }
    printList(str)
}

private fun pow(base: Long, exp: Int, mod: Long? = null): Long {
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
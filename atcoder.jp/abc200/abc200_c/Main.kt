fun main() {
    val n = nextInt()
    val a = nextInts()
    val l = LongArray(200) { 0 }
    a.forEach{
        val mod = it % 200
        l[mod] += 1L
    }
    var total = 0L
    l.filter{ it >= 2 }.forEach{ total += (it * (it - 1)) / 2}
    println(total)
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
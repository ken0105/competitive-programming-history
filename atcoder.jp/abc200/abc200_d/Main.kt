import java.lang.Integer.min

fun main() {
    val n = nextInt()
    val a = nextLongs()
    val l = IntArray(200) { 0 }
    val pattern = Array(200){ mutableListOf<Int>()}
    for (bit in 1 until pow(2, min(8,n))) {
        var total = 0L
        for (i in 0 until min(8,n)) {
            if ((bit shr i) and 1L == 1L) {
                total += a[i]
            }
        }
        total %= 200
        l[total.toInt()] += 1
        pattern[total.toInt()].add(bit.toInt())
    }
    for ((index, i) in l.withIndex()){
        if (i >= 2) {
            println("Yes")
            val l1 = getList(pattern[index][0])
            val l2 = getList(pattern[index][1])
            print("${l1.size} ")
            printList(l1)
            print("${l2.size} ")
            printList(l2)
            return
        }
    }
    println("No")

}

fun getList(i: Int): List<Int> {
    val l = mutableListOf<Int>()
    for (j in 0 until 8) {
        if ((i shr j) and 1 == 1) {
            l.add(j+1)
        }
    }
    return l
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
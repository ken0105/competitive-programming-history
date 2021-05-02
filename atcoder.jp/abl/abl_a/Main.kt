fun main() {
    System.`in`.bufferedReader().use{
        val k = it.readLine().toInt()
        var s = ""
        repeat(k) {
            s = s.plus("ACL")
        }
        println(s)
    }
}
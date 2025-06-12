data class Student(val country: Int, val num: Int, val score: Int)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val countryCount = IntArray(101)
    val sb = StringBuilder()

    val students = List(n) {
        readLine().split(' ')
            .map(String::toInt)
            .let { (c, num, score) -> Student(c, num, score) }
    }

    students
        .sortedByDescending { it.score }
        .filter { countryCount[it.country]++ < 2 }
        .take(3)
        .forEach { sb.appendLine("${it.country} ${it.num}") }

    print(sb)
}
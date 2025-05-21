import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toLong()
        val b = st.nextToken().toLong()
        val g = gcd(a, b)
        sb.appendLine(a / g * b)
    }
    print(sb)
}

tailrec fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)
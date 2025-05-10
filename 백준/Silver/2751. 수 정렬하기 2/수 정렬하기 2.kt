import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = Integer.parseInt(readLine())
    val sb = StringBuilder()
    val score = ArrayList<Int>(N)
    val bw = System.out.bufferedWriter()

    repeat(N) {
        score.add(Integer.parseInt(readLine()))
    }
    score.sort()

    sb.append(score.joinToString("\n"))
    bw.write(sb.toString())
    bw.close()
}
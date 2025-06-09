import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()

    val arr = LongArray(N)
    var idx = 0

    while (st.hasMoreTokens()) {
        arr[idx++] = reverseParse(st.nextToken())
    }

    while (idx < N) {
        st = StringTokenizer(readLine())
        
        while (st.hasMoreTokens()) {
            arr[idx++] = reverseParse(st.nextToken())
        }
    }

    arr.sort()

    print(buildString { arr.forEach { appendLine(it) } })
}

private fun reverseParse(str: String): Long {
    var num: Long = 0
    for (i in str.length - 1 downTo 0) {
        num = num * 10 + (str[i] - '0')
    }
    return num
}
fun main() {
    val sb = StringBuilder()

    while (true) {
        val line = readlnOrNull() ?: break
        val (s, t) = line.split(" ")
        var idx = 0

        for (ch in t) {
            if (ch == s[idx]) {
                idx++
            }
            if (idx >= s.length) {
                break
            }
        }

        sb.appendLine(if (idx == s.length) "Yes" else "No")
    }

    print(sb)
}
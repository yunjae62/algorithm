fun main() {
    val word = readln()
    val pattern = Regex("^(pi|ka|chu)+$")
    print(if (pattern.matches(word)) "YES" else "NO")
}
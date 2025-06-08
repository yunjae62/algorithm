fun main() {
    val N = readln().toInt()
    val arr = readln().split(" ").map(String::toInt).toIntArray().sorted()
    print(arr.joinToString(" "))
}
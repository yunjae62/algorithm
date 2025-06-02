fun main() {
    val (N, d) = readln().split(" ").map(String::toInt)
    var count = 0

    for (i in 1..N) {
        var num = i
        while (num != 0) {
            if (num % 10 == d) {
                count++
            }
            num /= 10
        }
    }

    print(count)
}
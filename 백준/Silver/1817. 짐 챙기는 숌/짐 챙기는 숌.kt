fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map(String::toInt)
    if (N == 0) {
        print(0)
        return
    }

    val weights = readLine().split(" ").map(String::toInt)

    var box = 1
    var nowBox = 0

    for (weight in weights) {
        if (nowBox + weight > M) {
            box++
            nowBox = weight
        } else {
            nowBox += weight
        }
    }

    println(box)
}
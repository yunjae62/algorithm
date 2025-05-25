fun main() = readln()
    .split(':')
    .map(String::toInt)
    .let { (n, m) ->
        var min = Math.min(n, m)
        var max = Math.max(n, m)

        while (min > 0) {
            val temp = min
            min = max % min
            max = temp
        }

        print("${n / max}:${m / max}")
    }
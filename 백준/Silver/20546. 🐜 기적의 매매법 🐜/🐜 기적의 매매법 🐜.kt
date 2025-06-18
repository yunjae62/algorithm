import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val cash = readLine().toInt()
    val st = StringTokenizer(readLine())
    val prices = IntArray(14) { st.nextToken().toInt() }

    var bnpCash = cash
    var bnpStock = 0

    for (price in prices) {
        val count = bnpCash / price
        bnpStock += count
        bnpCash -= price * count
    }

    var timingCash = cash
    var timingStock = 0
    var upCount = 0
    var downCount = 0

    for (i in 1 until prices.size) {
        when {
            prices[i] > prices[i - 1] -> {
                upCount++;
                downCount = 0
                if (upCount >= 3 && timingStock > 0) {
                    timingCash += timingStock * prices[i]
                    timingStock = 0
                }
            }

            prices[i] < prices[i - 1] -> {
                downCount++;
                upCount = 0
                if (downCount >= 3) {
                    val cnt = timingCash / prices[i]
                    timingStock += cnt
                    timingCash -= cnt * prices[i]
                }
            }

            else -> {
                upCount = 0
                downCount = 0
            }
        }
    }

    val lastPrice = prices.last()
    val bnpAsset = bnpCash + bnpStock * lastPrice
    val timingAsset = timingCash + timingStock * lastPrice

    println(
        when {
            bnpAsset > timingAsset -> "BNP"
            bnpAsset < timingAsset -> "TIMING"
            else -> "SAMESAME"
        }
    )
}
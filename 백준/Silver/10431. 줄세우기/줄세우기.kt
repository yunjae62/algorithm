fun main() = with(System.`in`.bufferedReader()) {
    val output = buildString {
        repeat(readLine().toInt()) {
            val tokens = readLine().split(" ").map(String::toInt)
            append(tokens[0]).append(" ")
            
            val heights = tokens.drop(1)
            val line = IntArray(heights.size)
            var move = 0
            
            heights.forEachIndexed { idx, height ->
                var pos = idx
                while (pos > 0 && line[pos - 1] > height) {
                    line[pos] = line[pos - 1]
                    pos--
                    move++
                }
                line[pos] = height
            }
            
            appendLine(move)
        }
    }
    
    print(output)
}
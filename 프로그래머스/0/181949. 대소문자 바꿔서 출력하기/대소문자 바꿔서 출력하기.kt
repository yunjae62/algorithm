fun main(args: Array<String>) {
    val s1 = readLine()!!
    val sb = StringBuilder()
    
    for (x in s1) {
        sb.append(if (x.isUpperCase()) x.lowercase() else x.uppercase())
    }
    
    println(sb.toString())
}

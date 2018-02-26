package kotlinlearn

fun main(args: Array<String>) {
    val n:Int = 10
    /**
     * for循环中，0..n表示从0到n
     */
    for (i in 0..n){
        println(i)
    }

    /**
     * for循环中，0 until n表示从0到n-1
     */
    println("until........")
    for (i in 0 until n){
        println(i)
    }
}
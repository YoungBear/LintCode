package kotlinlearn

fun main(args: Array<String>) {

    /**
     * 字符串转化为字符数组 toCharArray()，相当于java的toCharArray()
     */
    val str:String = "Hello"
    val chars = str.toCharArray()
    for (i in 0 until chars.size){
        println("i: " + i + ", ch: " + chars[i])
    }

    /**
     * 字符数组转化为字符串 String(array)，相当于Java的String.valueOf(array)
     */
    val array1:CharArray = charArrayOf('a','b','c')
    println(String(array1))


}
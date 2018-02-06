package leetcode.easy

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 两个数组的交集
 * Kotlin里边，Set表示不可变集合，MutableSet表示可变集合
 */
class IntersectionOfTwoArrays {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set1: MutableSet<Int> = mutableSetOf()
        for (item in nums1) {
            set1.add(item)
        }
        val set2: MutableSet<Int> = mutableSetOf()
        for (item in nums2) {
            set2.add(item)
        }
        return set1.intersect(set2).toIntArray()
    }
}

fun main(args: Array<String>) {
    val test = IntersectionOfTwoArrays()
    val arrA = intArrayOf(1, 2, 2, 1)
    val arrB = intArrayOf(2, 2)
    val arr = test.intersection(arrA, arrB)
    for (item in arr){
        println(item)
    }
}
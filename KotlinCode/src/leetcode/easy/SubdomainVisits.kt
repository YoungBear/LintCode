package leetcode.easy

import java.util.*

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2018/5/6 17:10
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 * Leetcode 811. Subdomain Visit Count
 * https://leetcode.com/problems/subdomain-visit-count/description/
 */
class SubMainVisits {

    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val timeMap:MutableMap<String, Int> = HashMap()
        for (cpdomain in cpdomains) {
            val strings = cpdomain.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val times = Integer.parseInt(strings[0])
            val domains = strings[1].split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            var startIndex = 0
            for (i in domains.indices) {
                if (i > 0) {
                    startIndex += domains[i - 1].length + 1
                }
                val s = strings[1].substring(startIndex)
                if (timeMap.containsKey(s)) {
//                    timeMap[s] = timeMap[s] + times
                    // compile failed
                } else {
                    timeMap[s] = times
                }
            }
        }
        val resultList = ArrayList<String>()
        for ((key, value) in timeMap) {
            val item = value.toString() + " " + key
            println(item)
            resultList.add(item)
        }
        return resultList
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val test = SubMainVisits()
            val cpdomains1 = arrayOf("9001 discuss.leetcode.com")
            test.subdomainVisits(cpdomains1)
            println("*******************line*************")

            val cpdomains2 = arrayOf("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org")
            test.subdomainVisits(cpdomains2)
        }
    }
}
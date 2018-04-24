package leetcode.easy

import java.util.*

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2018/4/24 11:20
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 * Leetcode 804. Unique Morse Code Words
 * https://leetcode.com/problems/unique-morse-code-words/description/
 */

class UniqueMorseCodeWords {

    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val set = HashSet<String>()
        for (item in words) {
            val sb = StringBuilder()
            for (ch in item.toCharArray()) {
                sb.append(LETTER_MAP[ch])
            }
            set.add(sb.toString())
        }
        return set.size
    }

    companion object {
        val LETTER_MAP: MutableMap<Char, String> = HashMap()

        init {
            LETTER_MAP.put('a', ".-")
            LETTER_MAP.put('b', "-...")
            LETTER_MAP.put('c', "-.-.")
            LETTER_MAP.put('d', "-..")
            LETTER_MAP.put('e', ".")
            LETTER_MAP.put('f', "..-.")
            LETTER_MAP.put('g', "--.")
            LETTER_MAP.put('h', "....")
            LETTER_MAP.put('i', "..")
            LETTER_MAP.put('j', ".---")
            LETTER_MAP.put('k', "-.-")
            LETTER_MAP.put('l', ".-..")
            LETTER_MAP.put('m', "--")
            LETTER_MAP.put('n', "-.")
            LETTER_MAP.put('o', "---")
            LETTER_MAP.put('p', ".--.")
            LETTER_MAP.put('q', "--.-")
            LETTER_MAP.put('r', ".-.")
            LETTER_MAP.put('s', "...")
            LETTER_MAP.put('t', "-")
            LETTER_MAP.put('u', "..-")
            LETTER_MAP.put('v', "...-")
            LETTER_MAP.put('w', ".--")
            LETTER_MAP.put('x', "-..-")
            LETTER_MAP.put('y', "-.--")
            LETTER_MAP.put('z', "--..")
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val test = UniqueMorseCodeWords()
            val words = arrayOf("gin", "zen", "gig", "msg")
            println(test.uniqueMorseRepresentations(words))
        }
    }
}

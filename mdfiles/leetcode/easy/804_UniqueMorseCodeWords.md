### [804. Unique Morse Code Words](https://leetcode.com/problems/unique-morse-code-words/description/)

**题目描述**

nternational Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

```
[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
```

Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-.-....-", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

```
Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
```

**简单翻译下：**

一个字母可以对应一组摩尔斯代码，如a用".-"代表。现在，输入一个字符串数组，用摩尔斯代码表示其中的每一个字符串，要求输出最终的唯一的摩尔斯代码的个数。(如果两个字符串的摩尔斯代码相同，则只保留一个)

**思路：**

可以先将摩尔斯代码与字母的对应关系存储在一个字典里，然后，遍历字符串数组，对于每一个字符串，遍历所有的字母，然后，将其对应的摩尔斯代码拼接在一起，作为一个字符串，存放在集合里。则最终只需要返回集合的大小即可。

**具体代码实现为：**

**Java：**

```
    public static final Map<Character, String> LETTER_MAP = new HashMap<>();

    static {
        LETTER_MAP.put('a', ".-");
        LETTER_MAP.put('b', "-...");
        LETTER_MAP.put('c', "-.-.");
        LETTER_MAP.put('d', "-..");
        LETTER_MAP.put('e', ".");
        LETTER_MAP.put('f', "..-.");
        LETTER_MAP.put('g', "--.");
        LETTER_MAP.put('h', "....");
        LETTER_MAP.put('i', "..");
        LETTER_MAP.put('j', ".---");
        LETTER_MAP.put('k', "-.-");
        LETTER_MAP.put('l', ".-..");
        LETTER_MAP.put('m', "--");
        LETTER_MAP.put('n', "-.");
        LETTER_MAP.put('o', "---");
        LETTER_MAP.put('p', ".--.");
        LETTER_MAP.put('q', "--.-");
        LETTER_MAP.put('r', ".-.");
        LETTER_MAP.put('s', "...");
        LETTER_MAP.put('t', "-");
        LETTER_MAP.put('u', "..-");
        LETTER_MAP.put('v', "...-");
        LETTER_MAP.put('w', ".--");
        LETTER_MAP.put('x', "-..-");
        LETTER_MAP.put('y', "-.--");
        LETTER_MAP.put('z', "--..");
    }

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String item : words) {
            StringBuilder sb = new StringBuilder();
            for(char ch : item.toCharArray()) {
                sb.append(LETTER_MAP.get(ch));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
```

**Kotlin：**

```

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
    }
```

**Python3:**

```
class Solution:
    LETTER_MAP = {
        'a': ".-",
        'b': "-...",
        'c': "-.-.",
        'd': "-..",
        'e': ".",
        'f': "..-.",
        'g': "--.",
        'h': "....",
        'i': "..",
        'j': ".---",
        'k': "-.-",
        'l': ".-..",
        'm': "--",
        'n': "-.",
        'o': "---",
        'p': ".--.",
        'q': "--.-",
        'r': ".-.",
        's': "...",
        't': "-",
        'u': "..-",
        'v': "...-",
        'w': ".--",
        'x': "-..-",
        'y': "-.--",
        'z': "--.."
    }

    def uniqueMorseRepresentations(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        set1 = set()
        for word in words:
            str = ""
            for ch in word:
                str += self.LETTER_MAP.get(ch)
            set1.add(str)
        return len(set1)
```

**JavaScript:**

```
var letter_map =
    {
        'a': ".-",
        'b': "-...",
        'c': "-.-.",
        'd': "-..",
        'e': ".",
        'f': "..-.",
        'g': "--.",
        'h': "....",
        'i': "..",
        'j': ".---",
        'k': "-.-",
        'l': ".-..",
        'm': "--",
        'n': "-.",
        'o': "---",
        'p': ".--.",
        'q': "--.-",
        'r': ".-.",
        's': "...",
        't': "-",
        'u': "..-",
        'v': "...-",
        'w': ".--",
        'x': "-..-",
        'y': "-.--",
        'z': "--.."
    };

/**
 * @param {string[]} words
 * @return {number}
 */
var uniqueMorseRepresentations = function(words) {
    var set1 = new Set;
    for(var i = 0; i < words.length; i++) {
        var str = "";
        for(var j = 0; j < words[i].length; j++) {
            str += letter_map[words[i].charAt(j)];
        }
        set1.add(str);
    }
    return set1.size;
};
```

## [更多编程练习](https://github.com/YoungBear/LintCode/blob/master/README.md)





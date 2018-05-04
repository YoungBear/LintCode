### [806. Number of Lines To Write String](https://leetcode.com/problems/number-of-lines-to-write-string/description/)

**题目描述**

We are to write the letters of a given string S, from left to right into lines. Each line has maximum width 100 units, and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line. We are given an array widths, an array where widths[0] is the width of 'a', widths[1] is the width of 'b', ..., and widths[25] is the width of 'z'.

Now answer two questions: how many lines have at least one character from S, and what is the width used by the last such line? Return your answer as an integer list of length 2.

```
Example :
Input: 
widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "abcdefghijklmnopqrstuvwxyz"
Output: [3, 60]
Explanation: 
All letters have the same length of 10. To write all 26 letters,
we need two full lines and one line with 60 units.
```

```
Example :
Input: 
widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "bbbcccdddaaa"
Output: [2, 4]
Explanation: 
All letters except 'a' have the same length of 10, and 
"bbbcccdddaa" will cover 9 * 10 + 2 * 4 = 98 units.
For the last 'a', it is written on the second line because
there is only 2 units left in the first line.
So the answer is 2 lines, plus 4 units in the second line.
```

Note:

- The length of S will be in the range [1, 1000].
- S will only contain lowercase letters.
- widths is an array of length 26.
- widths[i] will be in the range of [2, 10].


**简单翻译下：**

输入一个长度为26的整形数组，每个元素表示从字符'a'到'z'的长度。

输入一个字符串，都由小写字母构成。

需要将这个字符串中的所有字符，都存储下来。默认一行最多可以存**100**的单位。对于某一个具体的字符，如果超出了某一行，则在下一行重新存储。即字符的存储可定会存放在同一行。

返回一个数组，第一个元素表示行数，第二个元素表示最后一行所使用的存储单位。

**思路：**

遍历字符串中的每一个字符，用一个变量`current_width`表示当前行已占用存储的单位。然后，获取该字符的长度`w`，如果`current_width + w` 超出了行size，则需要重新起一行来存储，即行数加一`(result[0]++)`，`current_width = w`。否则`current_width += w` 即可。 最后，在加上最后一行，即`result[0]++`，最后一行的占用空间为`result[1] = current_width`。返回result，完成。

具体代码：

Java:

```
    public int[] numberOfLines(int[] widths, String S) {
        int[] result = new int[2];
        char[] chars = S.toCharArray();
        int currentWidth = 0;
        for (int i = 0; i < chars.length; i++) {
            int w = widths[chars[i] - 'a'];
            if (currentWidth + w > LINE_SIZE){
                result[0]++;
                currentWidth = w;
            } else {
                currentWidth += w;
            }
        }
        result[0] += 1;
        result[1] = currentWidth;
        return result;
    }
```

Kotlin:

```
    fun numberOfLines(widths: IntArray, S: String): IntArray {
        val result = IntArray(2)
        val chars = S.toCharArray()
        var currentWidth = 0
        for (i in chars.indices) {
            val w = widths[chars[i] - 'a']
            if (currentWidth + w > LINE_SIZE) {
                result[0]++
                currentWidth = w
            } else {
                currentWidth += w
            }
        }
        result[0] += 1
        result[1] = currentWidth
        return result
    }

    companion object {
        private val LINE_SIZE = 100
    }
```

Python3:

```
class Solution:
    LINE_SIZE = 100

    def numberOfLines(self, widths, S):
        """
        :type widths: List[int]
        :type S: str
        :rtype: List[int]
        """
        result = [0,0]
        current_width = 0
        for ch in S:
            w = widths[ord(ch) - ord('a')]
            if current_width + w > self.LINE_SIZE:
                result[0] += 1
                current_width = w
            else:
                current_width += w

        result[0] += 1
        result[1] = current_width
        return result
```

JavaScript:

```
const LINE_SIZE = 100;

/**
 * @param {number[]} widths
 * @param {string} S
 * @return {number[]}
 */
var numberOfLines = function(widths, S) {
    var result = [0, 0];
    var current_width = 0;
    var base = 'a'.charCodeAt(0);
    for (var i = 0; i < S.length; i++) {
        var w = widths[S[i].charCodeAt(0) - base];
        if (current_width + w > LINE_SIZE) {
            result[0]++;
            current_width = w;
        } else {
            current_width += w;
        }
    }
    result[0]++;
    result[1] = current_width;
    return result;
};
```

## [更多练习题](https://github.com/YoungBear/LintCode)


### [Leetcode: 791. Custom Sort String](https://leetcode.com/problems/custom-sort-string/description/)

**题目描述：**

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

```
Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
```

**Note:**

- S has length at most 26, and no character is repeated in S.
- T has length at most 200.
- S and T consist of lowercase letters only.

**简单翻译下：**

输入两个字符串S和T，都只包含小写字符，并且S中没有重复的字符。现在需求如下: 将T中的字符，按照在S中出现的顺序来排序(如果T中的字符没有在S中出现，name该字符可以在任意位置)。最后输入排序好的字符串。

**思路：**

遍历T中的每一个字符，然后对比其在S中的位置（java中调用indexOf方法），采用冒泡排序即可，最后，将排序好的字符数组，转换为字符串并返回。

**具体代码：**

java：

由于indexOf在不存在时，会返回-1，所以该结果会将S没有出现的字符放在最前面。

```
    public String customSortString(String S, String T) {
        char[] arrayT = T.toCharArray();
        /**
         * 使用indexOf，进行冒泡排序
         */
        int length = arrayT.length;
        boolean flag = true;
        for (int i = 0; flag && i < length; i++) {
            flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (S.indexOf(arrayT[j]) > S.indexOf(arrayT[j + 1])) {
                    char temp = arrayT[j];
                    arrayT[j] = arrayT[j + 1];
                    arrayT[j + 1] = temp;
                    flag = true;
                }
            }
        }
        return String.valueOf(arrayT);
    }
```

Kotlin:

toCharArray()将字符串转换成字符数组。

String(array)将字符数组转换成字符串。

结果与java方法的结果一致。

```
    fun customSortString(S: String, T: String): String {
        val arrayT = T.toCharArray()
        var flag : Boolean = true
        val size = arrayT.size
        for (i in 0 until size){
            if (!flag) {
                break
            }
            flag = false
            for (j in 0 until size - i - 1) {
                if (S.indexOf(arrayT[j]) > S.indexOf(arrayT[j + 1])) {
                    val temp:Char = arrayT[j]
                    arrayT[j] = arrayT[j + 1]
                    arrayT[j + 1] = temp
                    flag = true
                }
            }
        }
        return String(arrayT)
    }
```

Python3:

list(T)将字符串转化成字符列表。

''.join(listT)将字符列表转换成字符串。

需要判断字符是否在字符串中，使用in来判断，如果没有，则保持不变。如果相邻的两个字符，前面的在S中出现，后边的没有在S中出现，则也认为后边的大，交换位置。与java方法的结果一致。

```
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        listT = list(T)
        length = len(listT)
        flag = True
        for i in range(length):
            if not flag:
                break
            flag = False
            for j in range(length - i - 1):
                if listT[j] in S:
                    if listT[j + 1] not in S or S.index(listT[j]) > S.index(listT[j + 1]):
                        temp = listT[j]
                        listT[j] = listT[j + 1]
                        listT[j + 1] = temp
                        flag = True
        return ''.join(listT)
```

JavaScript:

T.split('')将字符串转换成字符数组。

arrayT.join('')将字符数组转换成字符串。

采用indexOf获取字符在字符串中的位置，如果没有，返回-1。与java方法的结果一致。

```
var customSortString = function(S, T) {
    var arrayT = T.split('');
    var length = T.length;
    var flag = true;
    for (var i = 0; flag && i < length; i++) {
        flag = false;
        for (var j = 0; j < length - i - 1; j++) {
            if (S.indexOf(arrayT[j]) > S.indexOf(arrayT[j + 1])) {
                var temp = arrayT[j];
                arrayT[j] = arrayT[j + 1];
                arrayT[j + 1] = temp;
                flag = true;
            }
        }
    }
    return arrayT.join('');
};
```

# [更多练习](https://github.com/YoungBear/LintCode/blob/master/README.md)
### [830. Positions of Large Groups](https://leetcode.com/problems/positions-of-large-groups/description/)

**题目描述**

In a string `S` of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like `S = "abbxxxxzyy"` has the groups `"a"`, `"bb"`, `"xxxx"`, `"z"` and `"yy"`.

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.

 

```
Example 1:

Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.

```

```
Example 2:

Input: "abc"
Output: []
Explanation: We have "a","b" and "c" but no large group.
```

```
Example 3:

Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]

```

 

**注意：**

```
1 <= S.length <= 1000
```

**简单翻译下：**

输入一个字符串，只包含小写字母。找到其中的大于等于3个的`group large`。即有连续3个或3个以上的相同字母，找到其起始位置，并作为列表返回。

**思路：**

遍历字符串的每一个字符，与相邻的后边字符比较，如果与前边的字母相同，则继续比较，找到满足3个以上的字母，并记录其位置，添加到列表中。最后将结果返回。

**具体代码：**

**Java**

```
    private static final int LARGE_SIZE = 3;

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            int j = i + 1;
            while(j < S.length() && S.charAt(j) == ch) {
                j++;
            }
            if (j - i >= LARGE_SIZE) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j - 1);
                resultList.add(list);
                i = j - 1;
            }
        }
        return resultList;
    }
```

**Kotlin**

```
    fun largeGroupPositions(S: String): List<List<Int>> {
        val resultList = ArrayList<List<Int>>()
        var i = 0
        while (i < S.length) {
            val ch = S[i]
            var j = i + 1
            while (j < S.length && S[j] == ch) {
                j++
            }
            if (j - i >= LARGE_SIZE) {
                val list = ArrayList<Int>()
                list.add(i)
                list.add(j - 1)
                resultList.add(list)
                i = j - 1
            }
            i++
        }
        return resultList
    }

    companion object {
        private val LARGE_SIZE = 3
    }
```

**Python3**

```
    LARGE_SIZE = 3

    def largeGroupPositions(self, S):
        """
        :type S: str
        :rtype: List[List[int]]
        """
        result_list = []
        i = 0
        while i < len(S):
            ch = S[i]
            j = i + 1
            while j < len(S) and S[j] == ch:
                j += 1
            if j - i >= self.LARGE_SIZE:
                item = [i, j - 1]
                result_list.append(item)
                i = j - 1
            i += 1
        return result_list
```

**JavaScript**

```
const LARGE_SIZE = 3;

/**
 * @param {string} S
 * @return {number[][]}
 */
var largeGroupPositions = function(S) {
    var result_list = [];
    for (var i = 0; i < S.length; i++) {
        var ch = S.charCodeAt(i);
        var j = i + 1;
        while (j < S.length && S.charCodeAt(j) === ch) {
            j++;
        }
        if (j - i >= LARGE_SIZE) {
            var item = [i, j - 1];
            result_list.push(item);
            i = j - 1;
        }
    }
    return result_list;
};
```

## [更多练习题](https://github.com/YoungBear/LintCode)




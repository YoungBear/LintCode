### [811. Subdomain Visit Count](https://leetcode.com/problems/subdomain-visit-count/description/)

**题目描述：**

A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".

We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.

```
Example 1:
Input: 
["9001 discuss.leetcode.com"]
Output: 
["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
Explanation: 
We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
```


```
Example 2:
Input: 
["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
Output: 
["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
Explanation: 
We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times. For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
```

**Notes:**

- The length of cpdomains will not exceed 100. 
- The length of each domain name will not exceed 100.
- Each address will have either 1 or 2 "." characters.
- The input count in any count-paired domain will not exceed 10000.
- The answer output can be returned in any order.

**简单翻译下：**

输入数据为一组域名和其访问次数，对于每一条数据，都为一个字符串，格式如`"9001 discuss.leetcode.com"`，其中，9001表示这个域名的访问次数。并且，对于一个域名，默认其顶级域名也会隐式地访问，并且为相同的次数，如这个，域名`discuss.leetcode.com`的访问次数为9001，域名`leetcode.com`也访问了9001次，域名`com`也访问了9001次。最后，我们需要统计所有域名的访问次数，返回结果也为`次数 域名`的格式。如这个的结果为：
`["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]`

**注意：**

由于需要统计每一个域名的访问次数，所以我们需要使用一个字典（或者称map）来存放其访问次数，其key为域名，value为访问次数。

我们遍历每一个域名，并且对其上层域名也进行统计，然后将其访问次数存放在字典里。

最后，再遍历字典，将结果按照响应格式返回即可。

**具体代码：**

**Java:**

```
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> timeMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] strings = cpdomain.split(" ");
            int times = Integer.parseInt(strings[0]);
            String[] domains = strings[1].split("\\.");
            int startIndex = 0;
            for (int i = 0; i < domains.length; i++) {
                if (i > 0) {
                    startIndex += domains[i - 1].length() + 1;
                }
                String s = strings[1].substring(startIndex);
                if (timeMap.containsKey(s)) {
                    timeMap.put(s, timeMap.get(s) + times);
                } else {
                    timeMap.put(s, times);
                }
            }
        }
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : timeMap.entrySet()) {
            String item = entry.getValue() + " " + entry.getKey();
            resultList.add(item);
        }
        return resultList;
    }
```

**Kotlin:**

Kotlin的字典操作与Java不相同，不能更新其value，暂时不能编译成功，还请网上的大神帮忙解答，万分感谢！


```
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
```

**Python3:**

```
    def subdomainVisits(self, cpdomains):
        """
        :type cpdomains: List[str]
        :rtype: List[str]
        """
        time_map = {}
        for cpdomain in cpdomains:
            strings = cpdomain.split(" ")
            times = int(strings[0])
            domains = strings[1].split(".")
            start_index = 0
            for i in range(len(domains)):
                if i > 0:
                    start_index += len(domains[i - 1]) + 1
                s = strings[1][start_index:]
                if s in time_map:
                    time_map[s] += times
                else:
                    time_map[s] = times
        result_list = []
        for key in time_map.keys():
            item = str(time_map[key]) + " " + key
            result_list.append(item)
        return result_list
```

**JavaScript:**

```
/**
 * @param {string[]} cpdomains
 * @return {string[]}
 */
var subdomainVisits = function (cpdomains) {
    var time_map = {};
    for (var i = 0; i < cpdomains.length; i++) {
        var strings = cpdomains[i].split(" ");
        var times = parseInt(strings[0]);
        var domains = strings[1].split(".");
        var start_index = 0;
        for (var j = 0; j < domains.length; j++) {
            if (j > 0) {
                start_index += domains[j - 1].length + 1;
            }
            var s = strings[1].substr(start_index);
            if (s in time_map) {
                time_map[s] += times;
            } else {
                time_map[s] = times;
            }
        }
    }
    var result_list = [];
    for (var key in time_map) {
        var item = parseInt(time_map[key]) + " " + key;
        result_list.push(item);
    }
    return result_list;
};
```

## [更多练习题](https://github.com/YoungBear/LintCode)


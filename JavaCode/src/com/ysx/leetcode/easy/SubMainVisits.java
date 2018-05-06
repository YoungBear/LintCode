package com.ysx.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author youngbear
 * @email youngbear@aliyun.com
 * @date 2018/5/6 16:23
 * @blog https://blog.csdn.net/next_second
 * @github https://github.com/YoungBear
 * @description
 * Leetcode 811. Subdomain Visit Count
 * https://leetcode.com/problems/subdomain-visit-count/description/
 */
public class SubMainVisits {

    public static void main(String[] args) {
        SubMainVisits test = new SubMainVisits();
        String[] cpdomains1 = {
                "9001 discuss.leetcode.com"
        };
        test.subdomainVisits(cpdomains1);
        System.out.println("*******************line*************");

        String[] cpdomains2 = {
                "900 google.mail.com",
                "50 yahoo.com",
                "1 intel.mail.com",
                "5 wiki.org"
        };
        test.subdomainVisits(cpdomains2);
    }

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
            System.out.println(item);
            resultList.add(item);
        }
        return resultList;
    }
}

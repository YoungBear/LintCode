/**
 * @auther  : youngbear
 * @email   : youngbear@aliyun.com
 * @time    : 2018/5/6 18:42
 * @blog    : https://blog.csdn.net/next_second
 * @github  : https://github.com/YoungBear
 * @file    : SubMainVisits.py
 * @software: WebStorm
 * Leetcode 811. Subdomain Visit Count
 * https://leetcode.com/problems/subdomain-visit-count/description/
 */

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


cpdomains1 = ["9001 discuss.leetcode.com"];
console.log(subdomainVisits(cpdomains1));

cpdomains2 = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"];
console.log(subdomainVisits(cpdomains2));



/**
 * @auther  : youngbear
 * @email   : youngbear@aliyun.com
 * @time    : 2018/4/24 11:33
 * @blog    : https://blog.csdn.net/next_second
 * @github  : https://github.com/YoungBear
 * @file    : UniqueMorseCodeWords.py
 * @software: WebStorm
 * Leetcode 804. Unique Morse Code Words
 * https://leetcode.com/problems/unique-morse-code-words/description/
 */

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

words = ["gin", "zen", "gig", "msg"];
console.log(uniqueMorseRepresentations(words));
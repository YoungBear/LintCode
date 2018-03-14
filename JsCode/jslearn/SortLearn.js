console.log("Hello");
var map = {};
map['a'] = 278;
map['b'] = 312;
map['c'] = 274;
map['d'] = 265;
map['e'] = 317;
map['f'] = 272;
map['g'] = 286;
map['h'] = 266;
map['i'] = 280;
map['j'] = 263;
map['k'] = 266;
map['l'] = 272;
map['m'] = 270;
map['n'] = 304;
map['o'] = 241;
map['p'] = 264;
map['q'] = 303;
map['r'] = 268;
map['s'] = 309;
map['t'] = 291;
map['u'] = 265;
map['v'] = 285;
map['w'] = 285;
map['x'] = 282;
map['y'] = 236;
map['z'] = 255;

// var list = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
//     'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'];

var list = [];
list.push('d');
list.push('m');
list.push('l');
list.push('q');
list.push('n');
list.push('p');
list.push('u');
list.push('v');
list.push('s');
list.push('x');
list.push('g');
list.push('j');
list.push('o');
list.push('b');
list.push('f');
list.push('c');
list.push('t');
list.push('z');
list.push('i');
list.push('h');
list.push('e');
list.push('w');
list.push('r');
list.push('y');
list.push('k');
list.push('a');

list.sort();

function fre(a, b) {
    if (map[a] > map[b]) {
        return -1;
    } else if (map[a] < map[b]) {
        return 1;
    } else {
        return 0;
    }
}

// list.sort(fre);

var flag = true;
for (var i = 0; flag && i < list.length; i++) {
    for (var j = 0; j < list.length - 1 - i; j++) {
        if (map[list[j]] < map[list[j+1]]) {
            var temp = list[j];
            list[j] = list[j + 1];
            list[j + 1] = temp;
            flag = true;
        }
    }
}

console.log(list);
console.log("end");
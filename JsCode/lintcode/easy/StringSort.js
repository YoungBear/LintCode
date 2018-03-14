/**
 * Lintcode 830. 字符串排序
 * http://www.lintcode.com/zh-cn/problem/string-sort/
 * @param str: the string that needs to be sorted
 * @return: sorted string
 */
const stringSort = function (str) {
    var map = {};
    for (var i = 0; i < str.length; i++) {
        if(str[i] in map) {
            map[str[i]] = map[str[i]] + 1;
        } else {
            map[str[i]] = 1;
        }
    }
    var list = [];
    for(var ch in map) {
        list.push(ch);
    }
    list.sort();

    /**
     * 冒泡排序
     * @type {boolean}
     */
    var flag = true;
    for (i = 0; flag && i < list.length; i++) {
        for (j = 0; j < list.length - 1 - i; j++) {
            if (map[list[j]] < map[list[j+1]]) {
                var temp = list[j];
                list[j] = list[j + 1];
                list[j + 1] = temp;
                flag = true;
            }
        }
    }
    str = '';
    for(var j = 0; j < list.length; j++) {
        for (var k = 0; k < map[list[j]]; k++) {
            str = str + list[j];
        }
    }
    return str;
};

// var str = 'bloomberg';
// var str = 'loombebrg';
var str = 'dmlqnpuvslpxvgjpobfvmlqsfbcftlzcnflgluuixccixbihebugejzwowgmgxcrsdypjhpytwmorxcupeozxzknxobhpatqjbqqgjfxwijqmhdaooieqgyqznyurgjrwawfyfshaphnmbxhsckjkbaitystixpbomwuulsecffvkdobwpoiyiebtudddjxupvqbthntrruqecuvnpsrbakvoziztkhyxyarycjjvgstrlzgwygrzkggwwglycgrpegnmteccsgeznnanhaxnkqdnirjzdxwkmcdgpucdcyvzmirtbivrjjrmlelurcyguuptojhvukgwistzhqdufhoattamlgjxvbpjruaiwsosrqngtpmijmmrborjqlzugzihfjtxwccscomjvduhsjhrgizihrctjfuroyivjqgaxcenbffnaawblrpuoqlrxwjgblkvhugbcqvzbemhgnhngyashqfdemugiiagipwtqknjlsjfdcgedddzhhqurvacvdaijbfnnkzqhfjdzkiukddrbnkjrqbnxgqbdvacucfwjaezgbcznwxtmmhxqgzbqefweqnjkndonquqahspmmnbidmpodhdsvnnpgyvdheoydibyhgqvnhanezziwzlxbcnzttlykvalqmhmxalmldqzvmgxlroyiotsezeyucwptulspfljjgqmkuawkhoicguvuacerxnmwtzllklwglnabntwbocbdrrjjsoihdhkxfzcpkplikfvcqalwitsnlbisgdmmiooecelsmmwudntfhurbdgqoebentovsuynndkylsbssedurytdapyjqqnogpoamxmmhmsmeehayikncgnwairskiozdagfumejcqvmmvhbmlcxspbnxjedkgnmgivxjmavpjwvhyvputgfbcjcoblfgspevxwvihabvpqqvrieepnlzjchytabkmxdevrvfzfjortdyusrbuyfgitwjzgnegcnmefskubkmtsumqhzfwiwamtblxeoopjlpuezchtshgxgnnygbvftrhjklgfhconkjpuuxqxjzyzighmnkasfhbuwekwqfseegrkayxsqfbmphlwnmjvpflbyqxrvxhvqijjevjxpdobptjbydifxjqeheimvwroxrinmhjdutxjihbdrejyfknetalsekqtxrmxccbpjuwgivkijgdrgzagbwphcnbvtjplrifsxgkavbqropprjpxfrewaplppsomssbwbxvesnluezmrkatkikoaiykqzgctkepsoxzbkaziwuzvdpzjejuiltgaerskuyzxewjdvouuwmatcxcfussmlrvjmeshbybrqhvcgvsdrexucslafqknvjiqiswlxmurzupaumdlokwodsesgfrtlebqumkjwnlisqkbuofwtrvnsdixbcliuawxpvshniuearckxiqhpeomgknqvawbvrbtaxhnwftnuarowectkbzccaldvpuafcaowctnefijaupcscpkbgnlttjysihfzkrewzfawhtvrbejjftkqrgprvvkfmdvggsuipqbrtzfdctfgwmjicnvlukybnsuviitpeqyezclqgnmkttbcxvvxtgwbebcfdbfdvvneabqndowazixgybpwygitwmekidaetlyqfwyddzaxzuetletgxuvsrhqhjitvkaonzmyixsnaegobseconidxbargquedltdhrtbuwnhygulpkqvfjoezlzdtihbapalfjqcgzgidtobhkzyvrwpbsiavmvrmeatovffmjhbecnzytxtnrpoofpbjzeasydctursfauuzusyprberaqvrfeeznzmmiugdbutjkrjigdcvpzayqrlhkhnviegztxlxbjkgwtqmibztbjbebfkrkpvkoaztowheeajkpeqafkhvgzpijewniefqsmreyqwxqfofxksqjkbezmhjlsamtiisfsmnptgspetcjdmijxfqmeqcippbdthbcgqhjkvotpgeidupabxwqauggzzrdjrgkfkwrxdnkaiqikcfoiywxjdbahsxecnwlsykszcbhbasmgbtwnkhahqynnsigeeytnsewmkhrxdzziabeyegkuxhnsipnmxtwrzmcmumjahmfdgxbaxebgcrjnkcscgnswdhdkxwxgmgnbufcukiwxhgbomehwzfokxqpnruozdkfdnlnmtgmmnzktnigweerxpqxrewuzmckhkazcwftabdbqhbvwcnpzdmarfzyqlnbpintnngtpvmcdpqbmizbeohsxuvnylponoetgucjypzaqkqemsdgiukzenrdffrsmwwifxwjxdwdjlcxkamoaqlimgstclldeqztfubfoayitcbvqgjyqolsokhxlbqswvzaqogljqnqmyjjzhbahgdsjsbqvnbkzbvdqqioijcxygbbbdsnczqpnwunnzxbrmevfsaanseodmtlhmrcjrvxxkvofklczvujtsaexaiujcbtytvtecpidwvkldpasmaeglbbuzdjgrytjxzpurpvaxnsqssntskpilisjbrospldrgmpukvbuqimdzfontmaxiqfzdfcixabgogvmfqgvhdlspvmojvvydqyiphxexklnjsjtfenputniilfxzbdfkpbudqmdvvnaxmitiylmpvfhaowqpqzxzoehrgbssogcmftqlmcojyungnatlwdxxpxtagnxcfxjchtwitddeykycxlqaqsfgdxvjttefldktblftagwwkkcydlnmivrftbhajrebjushsxjztorihfdtrvsdrggcykbjfwwjsydqrhkipkehixylggtqneixbmngzpqabwcahurfkevnoyfldngnpievjtxesujiyhltcdsebzoouubhngqpgousrcnpebpzybfedwedeovsnvxntjtahslgiqnlktgdjbuiaeavyrcjsxjeewiifrzexqdtrtmzqmdoawaaedthownkvfoogogsgfvyumtofursfuuqvroencxigerepyusyhuqcvvzfqpqmfbqcdwgenfawrvhizkhiiqtxemzvlejkqguvqztchgmpixrkqcetboiyvkzjxyrjpfgfqfbiwfnklhwrkrrqxfppfigknesybpzxsepneilztknefeauwqctzehqyxbzfkymhkyfksosfacwifqkvafynyzwijexzirkplstldhpwwrohdbkltzboeqwjpkihzillljlmzohamxrlfxtoirldmalijdruhzbthiulixwdytdjsubgqfmaqggeznbtugusrhoovdqwuutzlnekfbnqgsmwotjdsaxxbmqmuihqqcohqsltoxksbqotopcwoekwtvfkebcezrlycxlwjcqsvnetsaqqkugwnjqyfknojhhqheseuyvsypbywkevbqxmpnodejkfncbpptufvfwxmdtprnpryffqrztwvvpgaisxcnclhawstpvnvwegjnxghpylcchburjxmlifqccibtnyynngcyskkfsxswcfbvjqbanoztdwawujaumrspuxcgefkgtazuqkvcwmnvbeoqbbxpzpmdvdqbarqvqcskpjizoemndkfnkwgbycafqstygktxewtnhffawxkfndwiydvrweffpjflortyooudxyoltnlpswxlnydtbhfrfruaiogczohpgkykojtpylfwcuizsewhbknadbwzceemhjoybqlaknnkhanmpqqraehvlrvoevxihdtnraebvfnqlmseujxlvcyrfjjsywifiyyoykusnvhyhzrjsglrlwxjzqqpwzdwjofvtvezpyusggjcoaglrmwsrumxbpmfybxocnsktvioxnuhyvjnrkhkljzhslhefrhqhwqmiscqcwduamskyjcbpvgbspsxbvjhqngjmfmsuxkihvojbujxwfzjceqbdksusnahwjxqxacarjedztykfrognojbbnwzhvgpltxozvbvjpsmlanyxrxekyldvkjyonrcisyypelwubchuvhxackrfruvifrauqlagnnkkpskfqtgfvcvdaysbzoxixrfpfprdoqndygevncleokqnsaaohqsaprrdqikkdawdxedjgpsombanpyusurpyyuyramdtzjfsobomtpgzmlcuhvnkgpdoklhmjpidlsymhjrqpmeuzitwpdqdxztjrwnioldqfxagxpgwbopbxkzucqgpgzgizduvfunpsqjendrdslanaseerkuqevzbecagztlhzjlbolxynbcrrldfovhdefnmibprlqnucscmulvikqptqjohzpdsfrbmjwotxnvteuvstprwzarqvprrpqmyjftlvbezsilsgstuwudbhugyulawpzwxayzomttedjiemqqcaipgxqzuezafhmybrcsixcrxpemlyxsbhkqkfrswmlujiinuzsocvmuuqbjavppwirwzwkxzafymhmtiuthvfzhckckaxaisevzyftxasesfejqgvtazthypwnikymcvwmcygmbfyoqvismvhyvnlslbtlltmpnhsqekkepkfmbdsbccewyrkorxtqpdiaxkevvriujuxxsviludlhoqzbhcrbzdavkgzanycgkhgdfnxdcjdceswwrtmxzhlpeaeyccvdmcjcuhcpnpmxwuwthrabhssnevoxebwxlqusfdpswchfyrsytcievitrvbdorkzkhekvnsumllcqircnrcfwcivuhnmlpogczhiqukutoqchvzfivobkxltzuhfoqwebsiuxmoqtssmihjmjlylfqhvhhvyhqnejkqjtwsbiltmwawzcllahxqypintynqtsbagyasertgrxrixmxckzqhjzzndgweplbgsfxebmatfecmjvxepnqmaihmwrwjqmpnxmoyuotvvbujncscqfjsgoggeojyaurbfnongqnlqvfcofhqeflixvzowczvfyxgdfzmeisqiuhugtupounzcjmbnlbhtumramfcasulumzkgwzvmqksayznptvsewpvlnilripkjdvvplnrqiiibahebutjqzqusyfcgekyhhwlhwctwxpaeromaawdbwpalmjapdjihkynvgekaloqtqcbeeqkqrjesrpewbwvygxgtrylaqddvnwwqdftitwejxhhibouyiarawcyoumljjtzlteaqcmhoganmbkoqyvtnlausxjsdvqttnhiekrqfkcxfkoitwahecfnoylxwblqgdpxppgyscpbkewvniysgjpeiabzxbgovjuwbpgktwieheqqusxysgnbinbaiqrinnsayibvtkpiuyvbnotuennfmmxqyxerfjowoqfwbfscensjvephhujlndjmmkenhlkhmsgnmpvzivmxtamaimkgaesgaodgrmxhaqnbyzbshfcujbudhbafslyzbthrvwldoovzjqvwxlkdlxraehtxnonezzoiqrcxtmlskelhwlmdvntxswusfzwybirawxbbgwmlgedqeziblwioweeplhsgyawslvkklqfbiobvbxanptcsjnsaimjzgbzbgwtvjerxsvqcppzertlponnvutjwcrtcvlaxbtthgnfatvukvqdqdvqnslnoikfotfshxwwywacyyycsnxcwwhcjryxpddjypqgbhvcgeevglyzoixymwcaqxoxikqjmppsnilhmwzwqidzormshudrtbptcabarsearbosmavgralzedfhyumbuijgadcunnvruryvwwkrfdcsxeepihzyuktxxbxhkjopinraoybjvwirrshqfkqwaexuqhkdzcnklbnordydtwhiyqwngxfsrqlvkejlduovhlvdxqtdnzvjovcwhhjxsdbyhxjkqslctexvckqaaoboqwfflicxcyhgeciqsftlbrsldhdlfbjrfzqaspzqqtvpoklfayifampqgxarmrukuczsgdqkjplpekipwxbngciusnvkddlzefhydoqzudbnhkmzpmxaoaprgcwctxwpbnqisrdmnjdwikskatwwbccfgfzlcwttnzkkljiobbwostkygyefaxtsuwlabvjddqiycuhplhwnqkrdwhmfiqzfvrqqxgnbdbppzodbazimhjxxtbxuavdpdauursnckgztnxytfjxzrtkxgttpjtrmttxesremjhzgxsdlvlqwjvpjbslmppgwgsvbeuonrafgynglbrapmaqtfcdfjrwelvctcuvqlhlfxybqnlvdrifcxqfohnlsrugqcrbderhucqkycyedffmmouvkxmhavzunbigetrlgdepsnxivvljavbfsedgpcdscjquocvlufedknnlzgqzchwniddxfbhoppnatejxwsgnomesjaauyzjxqesalswggyhcgshhodlhvsvvgwyfbgtmajqkjkooutwbntagdbawxzmqidhsrpuyjhvgbgvkirecomycxtsihpetzacqbmlahcheszummmfrgsfsqwmtzxorkqnpjcdlwlsiaewymfzafsgdlwidfpiwgyszzuctvpegzaedwckfucotssqmmcxlfvwaolfserpskwedzbesnfvyjidkqppxliczcmbluslhhzivghjgwtarxneorxpwluzsbqunwfteoewapnnuggmvnzwchzmertpkgclefjqzafmcglckrllmhfnphcuztoyyaslxdetnnnmvztlbbzjbvkzogzgthweiurwugloiibqgvkzzpsfetealekzzuelcpawzmjemxseqwmjubikxwrqsnkrytxtwmawuxfztqngbgqjinoxuiurjdnoeeyickmrrjonnuedkwubmwevfdlhgxbbobwitcdkwclwfbsapmkoqcpuqgnwyyfkeiblstexdbpnbuhwmlbprgjisxtqlskxwssgjjezrjvgkhedhssypomcdneablygqlssfqkdsygffkxvcoluxoepmqxxilhmybscmswflaerawtfdjwwvhlveutcwdqncxjsiuxcvykbbvdospgilfcbzyzdvtfoveuwfgagwqtxcvsvigzjidwofiuejdnmpiappuyamouubvryfpicbdiyqrymqsymvtywggydptsxrre';
// console.log(str.length);
var result = stringSort(str);
console.log(result.length);
console.log(result);

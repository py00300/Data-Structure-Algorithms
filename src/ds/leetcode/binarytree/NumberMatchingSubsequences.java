package ds.leetcode.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 792. Number of Matching Subsequences
 */
public class NumberMatchingSubsequences {

  public static void main(String[] args) {
    //  String s = "abcde";
    // String[] words = {"a", "bb", "acd", "ace"};
    String s = "ricogwqznwxxcpueelcobbbkuvxxrvgyehsudccpsnuxpcqobtvwkuvsubiidjtccoqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjscnlhbrhookmioxqighkxfugpeekgtdofwzemelpyjsdeeppapjoliqlhbrbghqjezzaxuwyrbczodtrhsvnaxhcjiyiphbglyolnswlvtlbmkrsurrcsgdzutwgjofowhryrubnxkahocqjzwwagqidjhwbunvlchojtbvnzdzqpvrazfcxtvhkruvuturdicnucvndigovkzrqiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqnhrewhagldzhryzdmmrwnxhaqfezeeabuacyswollycgiowuuudrgzmwnxaezuqlsfvchjfloczlwbefksxsbanrektvibbwxnokzkhndmdhweyeycamjeplecewpnpbshhidnzwopdjuwbecarkgapyjfgmanuavzrxricbgagblomyseyvoeurekqjyljosvbneofjzxtaizjypbcxnbfeibrfjwyjqrisuybfxpvqywqjdlyznmojdhbeomyjqptltpugzceyzenflfnhrptuugyfsghluythksqhmxlmggtcbdddeoincygycdpehteiugqbptyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjckmaptilrbfpjxiarmwalhbdjiwbaknvcqovwcqiekzfskpbhgxpyomekqvzpqyirelpadooxjhsyxjkfqavbaoqqvvknqryhotjritrkvdveyapjfsfzenfpuazdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzqfgqwhgobwyhxltligahroyshfndydvffd";
    String[] words = {"iowuuudrgzmw", "azfcxtvhkruvuturdicnucvndigovkzrq", "ylmmo",
        "maptilrbfpjxiarmwalhbd", "oqvuahijyefbpqhbejuisksutsowhufsygtwteiqyligsnbqgl",
        "ytldcdlxqbaszbuxsacqwqnhrewhagldzhr", "zeeab", "cqie",
        "pvrazfcxtvhkruvuturdicnucvndigovkzrqiya", "zxnvpluwicurrtshyvevkriudayyysepzq",
        "wyhxltligahroyshfn", "nhrewhagldzhryzdmmrwn", "yqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmw",
        "nhrptuugyfsghluythksqhmxlmggtcbdd", "yligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoiundjsc",
        "zdrfdofhudqbfnzxnvpluwicurrtshyvevkriudayyysepzq",
        "ncygycdpehteiugqbptyqbvokpwovbnplshnzafun", "gdzutwgjofowhryrubnxkahocqjzww",
        "eppapjoliqlhbrbgh", "qwhgobwyhxltligahroys", "dzutwgjofowhryrubnxkah",
        "rydhxkdhffyytldcdlxqbaszbuxs", "tyqbvokpwovbnplshnzafunqglnpjvwddvdlmjjyzmwwxzjc",
        "khvyjyrydhxkdhffyytldcdlxqbasz", "jajekhvyjyrydhxkdhffyytldcdlxqbaszbuxsacqwqn",
        "ppapjoliqlhbrbghq", "zmwwxzjckmaptilrbfpjxiarm", "nxkahocqjzwwagqidjhwbunvlchoj",
        "ybfxpvqywqjdlyznmojdhbeomyjqptltp", "udrgzmwnxae", "nqglnpjvwddvdlmjjyzmww",
        "swlvtlbmkrsurrcsgdzutwgjofowhryrubn", "hudqbfnzxnvpluwicurr", "xaezuqlsfvchjf",
        "tvibbwxnokzkhndmdhweyeycamjeplec", "olnswlvtlbmkrsurrcsgdzu",
        "qiyastqpmfmuouycodvsyjajekhvyjyrydhxkdhffyyt", "eiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwyl",
        "cgiowuuudrgzmwnxaezuqlsfvchjflocz", "rxric", "cygycdpehteiugqbptyqbvokpwovbnplshnzaf", "g",
        "surrcsgd", "yzenflfnhrptuugyfsghluythksqh", "gdzutwgjofowhryrubnxkahocqjzwwagqid",
        "ddeoincygycdpeh", "yznmojdhbeomyjqptltpugzceyzenflfnhrptuug", "ejuisks",
        "teiqyligsnbqglqblhpdzzeurtdohdcbjvzgjwylmmoi", "mrwnxhaqfezeeabuacyswollycgio",
        "qfskkpfakjretogrokmxemjjbvgmmqrfdxlkfvycwalbdeumav",
        "wjgjhlrpvhqozvvkifhftnfqcfjmmzhtxsoqbeduqmnpvimagq",
        "ibxhtobuolmllbasaxlanjgalgmbjuxmqpadllryaobcucdeqc",
        "ydlddogzvzttizzzjohfsenatvbpngarutztgdqczkzoenbxzv",
        "rmsakibpprdrttycxglfgtjlifznnnlkgjqseguijfctrcahbb",
        "pqquuarnoybphojyoyizhuyjfgwdlzcmkdbdqzatgmabhnpuyh",
        "akposmzwykwrenlcrqwrrvsfqxzohrramdajwzlseguupjfzvd",
        "vyldyqpvmnoemzeyxslcoysqfpvvotenkmehqvopynllvwhxzr",
        "ysyskgrbolixwmffygycvgewxqnxvjsfefpmxrtsqsvpowoctw",
        "oqjgumitldivceezxgoiwjgozfqcnkergctffspdxdbnmvjago",
        "bpfgqhlkvevfazcmpdqakonkudniuobhqzypqlyocjdngltywn",
        "ttucplgotbiceepzfxdebvluioeeitzmesmoxliuwqsftfmvlg",
        "xhkklcwblyjmdyhfscmeffmmerxdioseybombzxjatkkltrvzq",
        "qkvvbrgbzzfhzizulssaxupyqwniqradvkjivedckjrinrlxgi",
        "itjudnlqncbspswkbcwldkwujlshwsgziontsobirsvskmjbrq",
        "nmfgxfeqgqefxqivxtdrxeelsucufkhivijmzgioxioosmdpwx",
        "ihygxkykuczvyokuveuchermxceexajilpkcxjjnwmdbwnxccl",
        "etvcfbmadfxlprevjjnojxwonnnwjnamgrfwohgyhievupsdqd",
        "ngskodiaxeswtqvjaqyulpedaqcchcuktfjlzyvddfeblnczmh",
        "vnmntdvhaxqltluzwwwwrbpqwahebgtmhivtkadczpzabgcjzx",
        "yjqqdvoxxxjbrccoaqqspqlsnxcnderaewsaqpkigtiqoqopth",
        "wdytqvztzbdzffllbxexxughdvetajclynypnzaokqizfxqrjl",
        "yvvwkphuzosvvntckxkmvuflrubigexkivyzzaimkxvqitpixo",
        "lkdgtxmbgsenzmrlccmsunaezbausnsszryztfhjtezssttmsr",
        "idyybesughzyzfdiibylnkkdeatqjjqqjbertrcactapbcarzb",
        "ujiajnirancrfdvrfardygbcnzkqsvujkhcegdfibtcuxzbpds",
        "jjtkmalhmrknaasskjnixzwjgvusbozslrribgazdhaylaxobj",
        "nizuzttgartfxiwcsqchizlxvvnebqdtkmghtcyzjmgyzszwgi",
        "egtvislckyltpfogtvfbtxbsssuwvjcduxjnjuvnqyiykvmrxl",
        "ozvzwalcvaobxbicbwjrububyxlmfcokdxcrkvuehbnokkzala",
        "azhukctuheiwghkalboxfnuofwopsrutamthzyzlzkrlsefwcz",
        "yhvjjzsxlescylsnvmcxzcrrzgfhbsdsvdfcykwifzjcjjbmmu",
        "tspdebnuhrgnmhhuplbzvpkkhfpeilbwkkbgfjiuwrdmkftphk",
        "jvnbeqzaxecwxspuxhrngmvnkvulmgobvsnqyxdplrnnwfhfqq",
        "bcbkgwpfmmqwmzjgmflichzhrjdjxbcescfijfztpxpxvbzjch",
        "bdrkibtxygyicjcfnzigghdekmgoybvfwshxqnjlctcdkiunob",
        "koctqrqvfftflwsvssnokdotgtxalgegscyeotcrvyywmzescq",
        "boigqjvosgxpsnklxdjaxtrhqlyvanuvnpldmoknmzugnubfoa",
        "jjtxbxyazxldpnbxzgslgguvgyevyliywihuqottxuyowrwfar",
        "zqsacrwcysmkfbpzxoaszgqqsvqglnblmxhxtjqmnectaxntvb",
        "izcakfitdhgujdborjuhtwubqcoppsgkqtqoqyswjfldsbfcct",
        "rroiqffqzenlerchkvmjsbmoybisjafcdzgeppyhojoggdlpzq",
        "xwjqfobmmqomhczwufwlesolvmbtvpdxejzslxrvnijhvevxmc",
        "ccrubahioyaxuwzloyhqyluwoknxnydbedenrccljoydfxwaxy",
        "jjoeiuncnvixvhhynaxbkmlurwxcpukredieqlilgkupminjaj",
        "pdbsbjnrqzrbmewmdkqqhcpzielskcazuliiatmvhcaksrusae",
        "nizbnxpqbzsihakkadsbtgxovyuebgtzvrvbowxllkzevktkuu",
        "hklskdbopqjwdrefpgoxaoxzevpdaiubejuaxxbrhzbamdznrr",
        "uccnuegvmkqtagudujuildlwefbyoywypakjrhiibrxdmsspjl",
        "awinuyoppufjxgqvcddleqdhbkmolxqyvsqprnwcoehpturicf"};

    System.out.println(numMatchingSubseq(s, words));
  }

  public static int numMatchingSubseq(String s, String[] words) {

    Map<Character, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      List<Integer> positions = map.get(s.charAt(i));
      if (positions != null) {
        positions.add(i);
      } else {
        List<Integer> ps = new ArrayList<>();
        ps.add(i);
        map.put(s.charAt(i), ps);
      }
    }

    System.out.println(map);

    int res = 0;
    Map<Character, List<Integer>> m1 = new HashMap<>(map);
    for (String w : words) {
      res += check(w, m1);
      m1 = new HashMap<>(map);
    }

    return res;
  }

  private static int check(String w, Map<Character, List<Integer>> m1) {
    for (int i = 0; i < w.length(); i++) {
      List<Integer> pss = m1.get(w.charAt(i)) != null ? new ArrayList<>(m1.get(w.charAt(i))) : null;

      if (pss == null || pss.isEmpty()) {
        return 0;
      } else {
        if (!checkInner(i, pss, w.charAt(i), m1)) {
          return 0;
        }
      }

    }
    return 1;
  }

  private static boolean checkInner(int i, List<Integer> pss, char c,
      Map<Character, List<Integer>> m1) {
    for (int k = 0; k < pss.size(); k++) {
      if (i <= pss.get(k)) {
        pss.remove(k);
        m1.put(c, pss);
        return true;
      }
    }
    return false;
  }
}

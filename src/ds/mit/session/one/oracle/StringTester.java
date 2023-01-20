package ds.mit.session.one.oracle;

public class StringTester {

  public static void main(String[] args) {
    String str = "01";
    System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
  }

  public static boolean validWordAbbreviation(String word, String abbr) {
    int count = 0;
    int idx = 0;
    int len = word.length();
    for (int i = 0; i < abbr.length(); i++) {
      char c = abbr.charAt(i);

      if (c >= 'a' && c <= 'z') {
        if (count > 0) {
          idx += count;
          count = 0;
        }
        if (idx >= len || c != word.charAt(idx)) {
          return false;
        }

        idx++;
      } else {
        if (count == 0 && c == '0') {
          return false;
        }
        count = count * 10 + (c - '0');
      }
    }
    return idx + count == len;
  }

}

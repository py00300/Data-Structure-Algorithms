package coursera.algorithms.week.one;

public class Roman2Int {

  public static void main(String[] args) {
    System.out.println(romanToInt("III"));
  }

  public static int romanToInt(String s) {
    s = s.replace("IV", "4,");
    s = s.replace("IX", "9,");
    s = s.replace("XL", "50,");
    s = s.replace("XC", "90,");
    s = s.replace("CD", "400,");
    s = s.replace("CM", "900,");
    s = s.replace("I", "1,");
    s = s.replace("V", "5,");
    s = s.replace("X", "10,");
    s = s.replace("L", "50,");
    s = s.replace("C", "100,");
    s = s.replace("D", "500,");
    s = s.replace("M", "1000,");

    String[] all = s.split(",");

    int result = 0;
    for (String str: all) {
      result += Integer.parseInt(str);
    }
    return result;
  }
}

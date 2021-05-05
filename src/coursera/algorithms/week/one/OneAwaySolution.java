package coursera.algorithms.week.one;

/**
 * One Away: There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class OneAwaySolution {

  public static void main(String[] args) {

    System.out.println(isOneAway("pale", "ple"));
    System.out.println(isOneAway("pales", "pale"));
    System.out.println(isOneAway("pale", "bale"));
    System.out.println(isOneAway("pale", "bake"));
    System.out.println(isOneAway("hello", "hollo"));
  }

  private static boolean isOneAway(String s1, String s2) {
     if (s1.length() != s2.length() && s1.length() + 1 < s2.length() ) {
       return false;
     }
     int[] s1Chars = new int[128];
     for (char ch :s1.toCharArray()) {
       s1Chars[ch]++;
     }

    // int[] s2Chars = new int[128];
    for (char ch :s2.toCharArray()) {
      s1Chars[ch]--;
    }

    int counter = 0;
    for (int i = 0 ; i < s1Chars.length ; i++) {
      if (s1Chars[i] > 1 || s1Chars[i] < -1) {
        return false;
      }
      if (s1Chars[i] == 1 || s1Chars[i] == -1) {
        counter++;
      }

    }

    if (counter <= 2) {
      return true;
    }
    return false;
  }
}

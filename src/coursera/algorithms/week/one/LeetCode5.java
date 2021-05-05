package coursera.algorithms.week.one;

import java.util.Stack;

public class LeetCode5 {

  public static void main(String[] args) {
    LeetCode5 leetCode5 = new LeetCode5();
    String s1 = "racecar";
    String s2 = "raccarz";
    Stack<Integer> stack = new Stack<>();
    System.out.println(leetCode5.longestPalindrome(s2));
  }

  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) {
      return "";
    }
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
      System.out.println(String
          .format("i: %s, len1: %s, len2: %s, len: %s, start: %s, end: %s", i, len1, len2, len,
              start, end));
      System.out.println("--------------------------------------------");
    }
    return s.substring(start, end + 1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      System.out.println(String.format("L: %s, R: %s, char(L): %s, s.charAt(R): %s", L, R, s.charAt(L), s.charAt(R)));
      L--;
      R++;
    }
    return R - L - 1;
  }
}

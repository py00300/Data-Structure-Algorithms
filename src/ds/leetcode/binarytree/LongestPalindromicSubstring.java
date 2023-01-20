package ds.leetcode.binarytree;

public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    String str = "abcdedfg";
    allSubStrings(str);
  }

  private static void allSubStrings(String str) {
    for (int i = 0; i <= str.length(); i++) {
      for (int j = i + 1; j <= str.length(); j++) {
        System.out.println(str.substring(i, j));
      }
    }
  }
}

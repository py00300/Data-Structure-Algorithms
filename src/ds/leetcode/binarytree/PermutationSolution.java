package ds.leetcode.binarytree;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationSolution {

  public static void main(String[] args) {
    permutation("abc");
  }

  public static List<String> permutation(String str) {

    List<String> result = new ArrayList<>();

    Set<Character> seen = new HashSet<>();

    preRecur(str, result, "", seen);

    return result;

  }

  private static void preRecur(String str, List<String> result, String curr, Set<Character> seen) {

    if (curr.length() == str.length()) {
      result.add(curr);
      System.out.println(curr);
      return;
    }

    for (int i = 0; i < str.length(); i++) {

      if (seen.contains(str.charAt(i))) {
        continue;
      }

      curr += str.charAt(i);

      seen.add(str.charAt(i));

      preRecur(str, result, curr, seen);

      curr = curr.substring(0, curr.length() - 1);

      seen.remove(str.charAt(i));
    }

  }
}

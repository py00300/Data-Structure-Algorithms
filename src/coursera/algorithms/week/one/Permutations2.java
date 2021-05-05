package coursera.algorithms.week.one;

import java.util.HashSet;
import java.util.Set;

public class Permutations2 {

  public static void perm(Set<String> res, String prefix, String s) {
    int n = s.length();
    if (n == 0) {
       res.add(prefix);
      System.out.println(prefix);
    } else {
      for (int i = 0; i < n; i++) {
        perm(res, prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
      }
    }
  }

  public static void main(String[] args) {
    Set<String> permutations = new HashSet<>();
    perm(permutations, "", "abc");

    System.out.println(permutations);
  }
}

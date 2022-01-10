package coursera.algorithms.week.two.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode3 {

  public static void main(String[] args) {
    String str = "aabaab!bb";
    System.out.println(str);
  }

  public String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

    Map<String, Integer> result = new HashMap<>();

    for (int i = 0 ; i < competitions.size() ; i++) {
      List<String> teams = competitions.get(i);
      String home = teams.get(0);
      String away = teams.get(1);
      int res = results.get(i);
      if (res == 1) {
        result.put(home, result.getOrDefault(home, 0) + 1);
      } else {
        result.put(away, result.getOrDefault(away, 0) + 1);
      }

    }

    int max = 0;
    String winner = "";
    for (String k: result.keySet()) {
      if (result.get(k) > max) {
        winner = k;
        max = result.get(k);
      }
    }

    return winner;
  }
}

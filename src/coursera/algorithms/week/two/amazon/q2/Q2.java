package coursera.algorithms.week.two.amazon.q2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {

  public static void main(String[] args) throws IOException {
    String s = "|**|*||**|";
    List<Integer> startIndices = Arrays.asList(1, 1, 1, 1);
    List<Integer> endIndices = Arrays.asList(5, 6, 9, 10);

    List<Integer> result = Result.numberOfItems(s, startIndices, endIndices);
    System.out.println(result);
  }

  static class Result {

    /*
     * Complete the 'numberOfItems' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY startIndices
     *  3. INTEGER_ARRAY endIndices
     */

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices,
        List<Integer> endIndices) {
      // Write your code here
      List<Integer> result = new ArrayList<>();
      for (int i = 0; i < startIndices.size(); i++) {
        int startIndex = startIndices.get(i) - 1;
        int endIndex = endIndices.get(i);

        boolean isOpen = false;
        boolean isClose = false;
        int counter = 0;
        int tmp = 0;
        for (int j = startIndex; j < endIndex; j++) {

          if (s.charAt(j) == '|' && !isOpen) {
            isOpen = true;
          } else if (s.charAt(j) == '|' && isOpen) {
            // isOpen = false;
            counter += tmp;
            tmp = 0;
          } else if (s.charAt(j) == '*') {
            tmp++;
          }
          System.out.print(s.charAt(j));
        }
        result.add(counter);
        System.out.println();
      }

      return result;
    }

  }
}

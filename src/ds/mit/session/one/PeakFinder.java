package ds.mit.session.one;

import java.util.Arrays;

/**
 * Complexity O(log n) bas of log is 2.
 */

public class PeakFinder {

  public static void main(String[] args) {
    int[] numbers = {1,2,3,1};
    int peak = findPeak(numbers);
    System.out.println(peak);

    int[] numbers2 = {1,2,1,3,5,6,4};
    int peak2 = findPeak(numbers2);
    System.out.println(peak2);
  }

  private static int findPeak(int[] numbers) {
    int n = numbers.length;
    if (numbers[n/2] < numbers[(n/2) - 1]) {
       return findPeak(Arrays.copyOfRange(numbers, 0, (n/2) - 1));
    } else if (numbers[n/2] < numbers[(n/2) + 1]) {
      return findPeak(Arrays.copyOfRange(numbers, n/2, n));
    }
    return numbers[n/2];
  }
}

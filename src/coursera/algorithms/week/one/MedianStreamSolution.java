package coursera.algorithms.week.one;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MedianStreamSolution {
  // Add any helper functions you may need here
  int[] findMedian(int[] arr) {
    // Write your code here
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int[] result = new int[arr.length];
    for (int i = 0 ; i < arr.length ; i++) {
      q.add(arr[i]);


      int qSize = q.size();
      Iterator<Integer> it = q.iterator();

      if (qSize % 2 == 0) {
        int index = qSize / 2;
        int counter = 0;
        int k = 0, j = 0;
        while (counter < index) {
          // k = it.next();
          k = q.poll();
          counter++;
        }
        j = q.poll();

        result[i] = (k + j) /2;
      } else {
        int index = qSize / 2;
        int counter = 0;
        int k = 0;
        while (counter <= index) {
         // k = it.next();
          k = q.poll();
          counter++;
        }

        result[i] = k;
      }

    }
   return result;
  }



  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;
  void check(int[] expected, int[] output) {
    int expected_size = expected.length;
    int output_size = output.length;
    boolean result = true;
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected);
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }
  void printIntegerArray(int[] arr) {
    int len = arr.length;
    System.out.print("[");
    for(int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }
  public void run() {
    int[] arr_1 = {5, 15, 1, 3};
    int[] expected_1 = {5, 10, 5, 4};
    int[] output_1 = findMedian(arr_1);
    check(expected_1, output_1);

    int[] arr_2 = {2, 4, 7, 1, 5, 3};
    int[] expected_2 = {2, 3, 4, 3, 4, 3};
    int[] output_2 = findMedian(arr_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }
  public static void main(String[] args) {
    new MedianStreamSolution().run();
  }
}

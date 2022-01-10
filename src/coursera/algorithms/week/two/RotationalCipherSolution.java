package coursera.algorithms.week.two;

import java.util.HashMap;
import java.util.Map;

public class RotationalCipherSolution {



    // Add any helper functions you may need here


    String rotationalCipher(String input, int rotationFactor) {
      // Write your code here
      char[] chars = input.toCharArray();
      Map<String, String> map = new HashMap<>();
      // 65 - 90 97 - 122 48 - 57
      for (int i = 0 ; i < chars.length ; i++) {
         if (chars[i] >= 48 && chars[i] <= 57) {
           int rotation = rotationFactor % 10;
           chars[i] = (char) ((chars[i] - '0' + rotation) % 10 + '0');
        } else if (chars[i] >= 65 && chars[i] <= 90) {
           int rotation = rotationFactor % 26;
           chars[i] = (char) ((chars[i] - 'A' + rotation) % 26 + 'A');
         }  else if (chars[i] >= 97 && chars[i] <= 122) {
           int rotation = rotationFactor % 26;
           chars[i] = (char) ((chars[i] - 'a' + rotation) % 26 + 'a');
         }
      }

      return new String(chars);
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
      boolean result = (expected.equals(output));
      char rightTick = '\u2713';
      char wrongTick = '\u2717';
      if (result) {
        System.out.println(rightTick + " Test #" + test_case_number);
      }
      else {
        System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
        printString(expected);
        System.out.print(" Your output: ");
        printString(output);
        System.out.println();
      }
      test_case_number++;
    }
    void printString(String str) {
      System.out.print("[\"" + str + "\"]");
    }

    public void run() {
      String input_1 = "All-convoYs-9-be:Alert1.";
      int rotationFactor_1 = 4;
      String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
      String output_1 = rotationalCipher(input_1, rotationFactor_1);
      check(expected_1, output_1);

      String input_2 = "abcdZXYzxy-999.@";
      int rotationFactor_2 = 200;
      String expected_2 = "stuvRPQrpq-999.@";
      String output_2 = rotationalCipher(input_2, rotationFactor_2);
      check(expected_2, output_2);

      // Add your own test cases here

    }

    public static void main(String[] args) {
      new RotationalCipherSolution().run();
    }
  }


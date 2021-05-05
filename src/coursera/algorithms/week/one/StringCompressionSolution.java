package coursera.algorithms.week.one;

/**
 * String Compression: Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * Hints:#92, #110
 */
public class StringCompressionSolution {

  public static void main(String[] args) {
    System.out.println(stringCompression("aabcccccaaa"));
    System.out.println(stringCompression("abcd"));
    System.out.println(stringCompression("abcdd`"));
  }

  private static String stringCompression(String str) {

    StringBuilder sb = new StringBuilder();
    int counter = 0;

    boolean shouldBeSame = true;
    for (int i = 0 ; i < str.length(); i++) {
      counter++;

      if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
        sb.append(str.charAt(i));
        sb.append(counter);
        if (counter > 1) {
          shouldBeSame = false;
        }
        counter = 0;
      }
    }

    return shouldBeSame ? str : sb.toString();
  }
}

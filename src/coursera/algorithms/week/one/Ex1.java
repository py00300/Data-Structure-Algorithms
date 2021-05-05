package coursera.algorithms.week.one;

public class Ex1 {

  public static void main(String[] args) {
    String s ="FlaG";
    System.out.println(detectCapitalUse(s));
  }

  public static boolean detectCapitalUse(String word) {

    int counter = 0;
    for (char ch: word.toCharArray()) {
      if (ch - 65 >= 0 && ch - 65 <= 26) {
        counter++;
      }
    }
    if (word.charAt(0) - 65 >= 0 || word.charAt(0) - 65 <= 26) {

      if (counter == 1 || counter == word.length()) {
        System.out.println(counter);
        return true;
      }

    } else {
      if (counter == 0) {
        return false;
      }
    }
    return false;
  }


}

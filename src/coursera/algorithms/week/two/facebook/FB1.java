package coursera.algorithms.week.two.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * //Given a string (with possible repeating letters) find all the words in a given dictionary
 * // that can be made with any subset of that string. e.g string = "aaabdnn" -> example of possible words : "banana", "and", "bad", ...
 *
 *
 * //e.g. S: 'aaabdnn' , dict ['and', 'bad', 'banana', 'cat'...] ->
 * // return ['and', 'bad', 'banana']
 *
 * // n * (n-1) * (n-2) ... 1
 * //
 *
 * public List<String> finder(String s, List<String> words) {
 *   List<String> result = new ArrayList<>();
 *
 *   if (s == null || s.isEmpty() || words == null || words.isEmpty()) {
 *     return result;
 *   }
 *
 *   Map<Character, Integer> chars = new HashMap<>();
 *   for (char c: s.toCharArray()) {
 *       Integer count = chars.get(c);
 *       if (count == null) {
 *         chars.put(c, 1);
 *       } else {
 *         chars.put(c, ++count);
 *       }
 *   }
 *   // chars {[a, 3], [b, 1], [d, 1], [n, 2]}
 *
 *   for (String word: words) {
 *      Map<Character, Integer> tmp = new HashMap<>(chars);
 *     for (char c: word.toCharArray()) {
 *
 *        Integer count = tmp.get(c);
 *       if (count == null) {
 *         break;
 *       } else {
 *         if (count - 1 >= 0 ) {
 *           tmp.put(c, --count);
 *         } else {
 *           break;
 *         }
 *
 *       }
 *       result.add(word);
 *     }
 *   }
 *
 *
 *   return result;
 *
 * }
 *
 *
 * // S 'face', T 'facefceafook' ->  [0, 4, 5]
 * // O(length of S + length of T)
 *
 * // put the s and all chars in S as a Map of chars and integrs which integres will be count of chars
 * // start from index 0 of t to index of length of S
 * // up to length of t - length of s
 */
public class FB1 {

  public static void main(String[] args) {
    System.out.println(finder("aaabdnn", Arrays.asList("and", "bad", "banana", "cat")));
  }

  public static List<String> finder(String s, List<String> words) {
    List<String> result = new ArrayList<>();

    if (s == null || s.isEmpty() || words == null || words.isEmpty()) {
      return result;
    }

    Map<Character, Integer> chars = new HashMap<>();
    for (char c: s.toCharArray()) {
      Integer count = chars.get(c);
      if (count == null) {
        chars.put(c, 1);
      } else {
        chars.put(c, ++count);
      }
    }
    // chars {[a, 3], [b, 1], [d, 1], [n, 2]}

    for (String word: words) {
      Map<Character, Integer> tmp = new HashMap<>(chars);
      boolean shouldAdd = true;
      for (char c: word.toCharArray()) {

        Integer count = tmp.get(c);
        if (count == null) {
          shouldAdd = false;
          break;
        } else {
          if (count - 1 >= 0 ) {
            tmp.put(c, --count);
          } else {
            shouldAdd = false;
            break;
          }

        }

      }

      if (shouldAdd) {
        result.add(word);
      }
    }
    return result;

  }
}

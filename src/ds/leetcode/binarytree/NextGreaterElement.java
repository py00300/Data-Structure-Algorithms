package ds.leetcode.binarytree;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

  public static void main(String[] args) {
    int[] array = {2, 5, -3, -4, 6, 7, 2};
    nextGreaterElement(array);
  }

  public static int[] nextGreaterElement(int[] array) {
    int[] res = new int[array.length];
    Arrays.fill(res, -1);

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < array.length * 2; i++) {
      int idx = i % array.length;

      while (!stack.isEmpty() && array[stack.peek()] < array[idx]) {
        int top = stack.pop();
        res[top] = array[idx];
        System.out.println(
            "i:" + i + ", idx: " + idx + ", top: " + top + ", array[idx]: " + array[idx]);
      }

      stack.push(idx);

    }

    return res;
  }
}

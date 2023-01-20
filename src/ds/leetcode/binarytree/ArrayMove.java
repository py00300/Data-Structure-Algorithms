package ds.leetcode.binarytree;

import java.util.Arrays;

public class ArrayMove {

  public static void main(String[] args) {
    //  int[] arr = new int[]{1, 2, 3, 4, 5};
    // System.out.println(Arrays.toString(arr));
    // move(arr, 4, 1);
    //  System.out.println(Arrays.toString(arr));

    int[] arr2 = new int[]{1, 0, 0, -1, -1, 0, 1, 1};
    int[] order = new int[]{0, 1, -1};

    System.out.println(Arrays.toString(threeNumberSort(arr2, order)));
  }

  private static void move(int[] arr, int start, int end) {
    while (start - 1 >= end) {
      swap(arr, start, start - 1);
      start--;
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  public static int[] threeNumberSort(int[] array, int[] order) {

    int place = 0;
    int newPlace = 0;
    for (int i = 0; i < order.length; i++) {
      place = newPlace;
      for (int j = 0; j < array.length; j++) {
        if (array[j] == order[i]) {
          move(array, j, place);
          newPlace++;
        }
      }
    }
    return array;
  }
}

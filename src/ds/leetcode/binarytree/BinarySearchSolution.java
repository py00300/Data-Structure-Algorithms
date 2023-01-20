package ds.leetcode.binarytree;

public class BinarySearchSolution {

  public static void main(String[] args) {
    int[] arr = new int[]{1, 5, 8, 23, 45, 101, 247, 250};
    int target = 1;
    System.out.println(binarySearchIt(arr, target));
    System.out.println(binarySearchRec(arr, target, 0, arr.length - 1));
  }

  private static boolean binarySearchIt(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int mid = right + left / 2;
      if (arr[mid] == target) {
        return true;
      }

      if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }

  private static boolean binarySearchRec(int[] arr, int target, int left, int right) {

    if (left > right) {
      return false;
    }

    int mid = right + left / 2;
    if (arr[mid] == target) {
      return true;
    }

    if (arr[mid] < target) {

      return binarySearchRec(arr, target, mid + 1, right);
    } else {

      return binarySearchRec(arr, target, left, mid - 1);
    }

    //return false;
  }

}

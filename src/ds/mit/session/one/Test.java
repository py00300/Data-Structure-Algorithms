package ds.mit.session.one;

public class Test {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 4, 6, 8, 9, 10, 15};
    int target = 222;

    int found = binarySearch(nums, target, 0, nums.length);
    System.out.println(found);
  }

  private static int binarySearch(int[] nums, int target, int start, int end) {
    int mid = (start + end - 1) / 2;
    if (nums[mid] == target) {
      return mid;
    }

    if (start == end) {
      return -1;
    }

    if (target > nums[mid]) {
      return binarySearch(nums, target, mid + 1, end);
    } else if (target < nums[mid]) {
      return binarySearch(nums, target, start, mid - 1);
    }

    return -1;
  }

}

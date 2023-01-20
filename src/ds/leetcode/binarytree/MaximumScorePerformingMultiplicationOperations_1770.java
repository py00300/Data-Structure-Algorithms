package ds.leetcode.binarytree;

public class MaximumScorePerformingMultiplicationOperations_1770 {

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    int[] multipliers = {3, 2, 1};
    System.out.println(maximumScore2(nums, multipliers));

  }

  public static int maximumScore(int[] nums, int[] multipliers) {
    int n = nums.length;
    int m = multipliers.length;
    int[][] dp = new int[m + 1][m + 1];

    for (int i = m - 1; i >= 0; i--) {
      for (int left = i; left >= 0; left--) {
        int mult = multipliers[i];
        int right = n - 1 - (i - left);
        dp[i][left] = Math.max(mult * nums[left] + dp[i + 1][left + 1],
            mult * nums[right] + dp[i + 1][left]);

        System.out.println("Right: " + right + ", left: " + left);
        // System.out.println(Arrays.toString(dp));
      }
    }

    return dp[0][0];
  }

  public static int maximumScore2(int[] nums, int[] multipliers) {
    int[][] memo = new int[multipliers.length + 1][multipliers.length + 1];

    for (int i = multipliers.length - 1; i >= 0; i--) {
      for (int left = 0; left <= i; left++) {
        int right = nums.length - 1 - i + left;
        int resultOfAddLeft = multipliers[i] * nums[left] + memo[left + 1][i + 1];
        int resultOfAddRight = multipliers[i] * nums[right] + memo[left][i + 1];
        memo[left][i] = Math.max(resultOfAddLeft, resultOfAddRight);
      }
    }

    return memo[0][0];
  }

}

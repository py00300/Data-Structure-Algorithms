package ds.leetcode.binarytree;

public class MaximalSquare_221 {

  public static void main(String[] args) {
    char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

    char[][] matrix2 = {{'1', '1'}, {'1', '0'}};

    System.out.println(maximalSquare4(matrix));
  }

  public static int maximalSquare1(char[][] matrix) {
    int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
    int maxsqlen = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (matrix[i][j] == '1') {
          int sqlen = 1;
          boolean flag = true;
          while (sqlen + i < rows && sqlen + j < cols && flag) {
            for (int k = j; k <= sqlen + j; k++) {
              if (matrix[i + sqlen][k] == '0') {
                flag = false;
                break;
              }
            }
            for (int k = i; k <= sqlen + i; k++) {
              if (matrix[k][j + sqlen] == '0') {
                flag = false;
                break;
              }
            }
            if (flag) {
              sqlen++;
            }
          }
          if (maxsqlen < sqlen) {
            maxsqlen = sqlen;
          }
        }
      }
    }
    return maxsqlen * maxsqlen;
  }

  public static int maximalSquare2(char[][] matrix) {
    int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
    int[][] dp = new int[rows + 1][cols + 1];
    int maxsqlen = 0;
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
          maxsqlen = Math.max(maxsqlen, dp[i][j]);
        }
      }
    }
    return maxsqlen * maxsqlen;
  }

  public static int maximalSquare4(char[][] matrix) {

    if (matrix.length == 0) {
      return 0;
    }
    if (matrix[0].length == 1 && matrix[0][0] == 0) {
      return 0;
    }
    if (matrix[0].length == 1 && matrix[0][0] == 1) {
      return 1;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;

    int[][] dp = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        dp[i][j] = -1;
      }
    }

    helper(matrix, dp, 0, 0, rows, cols);

    int max = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        // System.out.println(dp[i][j]);
        max = Math.max(max, dp[i][j]);
      }
    }

    return max * max;
  }

  private static int helper(char[][] matrix, int[][] dp, int i, int j, int rows, int cols) {
    //System.out.println(dp[i][j]);
    if (i >= rows || j >= cols) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }

    int right = helper(matrix, dp, i, j + 1, rows, cols);
    int down = helper(matrix, dp, i + 1, j, rows, cols);
    int diag = helper(matrix, dp, i + 1, j + 1, rows, cols);
    dp[i][j] = 0;

    if (matrix[i][j] == '1') {

      dp[i][j] = 1 + Math.min(right, Math.min(down, diag));
    }

    return dp[i][j];
  }

  public int maximalSquare3(char[][] matrix) {
    int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
    int[] dp = new int[cols + 1];
    int maxsqlen = 0, prev = 0;
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        int temp = dp[j];
        if (matrix[i - 1][j - 1] == '1') {
          dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
          maxsqlen = Math.max(maxsqlen, dp[j]);
        } else {
          dp[j] = 0;
        }
        prev = temp;
      }
    }
    return maxsqlen * maxsqlen;
  }
}

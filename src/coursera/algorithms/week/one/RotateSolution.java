package coursera.algorithms.week.one;

import java.util.Arrays;

public class RotateSolution {

  public static void main(String[] args) {
    int[][] matrix =
        {{1,2,3},
        {4,5,6},
        {7,8,9}};
    rotate(matrix);
    print2D(matrix);
  }
  public static void rotate(int[][] matrix) {

    int n = matrix.length;

    for (int i = 0 ; i < n ; i++) {
      for (int j = i; j < n ; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n/2 ; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][n-1-j];
        matrix[i][n-1-j] = tmp;
      }
    }
  }
  public static void print2D(int mat[][])
  {
    // Loop through all rows
    for (int[] row : mat)

      // converting each row as string
      // and then printing in a separate line
      System.out.println(Arrays.toString(row));
  }

}

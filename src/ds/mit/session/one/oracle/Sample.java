package ds.mit.session.one.oracle;

/*
 * Click `Run` to execute the snippet below!
 */

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
public class Sample {

  public static void main(String[] args) {
    //For the given array {3, 9, 50, 15, 99, 7, 98, 65} return the distance between the two closest numbers
    int arr[] = {3, 9, 50, 15, 99, 7, 90, 65, 101, 151, 155};
    int closetNumber = findMinDistance(arr);
    System.out.println(closetNumber);

  }

  private static int findMinDistance(int[] numbers) {
    int n = numbers.length;
    int result = Integer.MAX_VALUE;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - 1; j++) { // j = 0 to n -1,


        int temp = Math.abs(numbers[i] - numbers[j]);
        // numbers[j+1]= temp;
        System.out.println(i+ " ,j:" + j + ", "+ numbers[j]+ "," + numbers[j + 1] + " ,res: " + result + " ,tmp: " +temp);
        if (result > temp && i != j) {
          result = temp;
        }
      }
    }

    return result;
  }
}

package algorithms_datastructures.cses._02_Missing_Number;

import java.util.Arrays;

public class MissingNumber {

  private static final int N = 8;
  private static final Integer[] array = new Integer[] {2, 5, 4, 1, 6, 7, 8};

  public static void main(String[] args) {
    var mn = new MissingNumber();
    mn.solution(N, Arrays.stream(array).mapToInt(i -> i).toArray());
  }

  private void solution(int n, int[] arr) {
    // total of the items in the array within the missing number should be below by the consecutive
    // numbers law
    var total = (n * (n + 1) / 2);
    for (int number : arr) {
      total -= number;
    }
    System.out.println(total);
  }
}

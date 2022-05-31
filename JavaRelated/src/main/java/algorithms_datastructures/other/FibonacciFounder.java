package algorithms_datastructures.other;

import java.util.Arrays;

public class FibonacciFounder {
  public static void main(String[] args) {
    var founder = new FibonacciFounder();
    System.out.println(Arrays.toString(founder.getFibonacci(8)));
  }

  // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89
  private int[] getFibonacci(int length) {
    int[] array = new int[length];
    array[0] = 0;
    array[1] = 1;
    for (int i = 2; i < length; i++) {
      array[i] = array[i - 1] + array[i - 2];
    }
    return array;
  }
}

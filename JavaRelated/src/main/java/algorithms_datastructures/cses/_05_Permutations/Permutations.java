package algorithms_datastructures.cses._05_Permutations;

import java.util.Arrays;

public class Permutations {
  // constraint: 1 ≤ n ≤ 10pow6
  // beautiful permutation if there are no adjacent elements whose difference is 1.

  public static void main(String[] args) {
    var permutations = new Permutations();
    permutations.solution(5);
  }

  // solution method
  // 4
  // 1 3 2 4

  // 6
  // 1 3 5 2 4 6
  // 5 3 6 1 4 2

  // 7
  // 1 3 5 7 2 4 6

  // 8
  // 1 3 5 7 2 4 6 8

  private void solution(int n) {
    if (n <= 1 || n >= Math.pow(10, 6)) {
      System.out.println("NO SOLUTION");
      return;
    }

    var beautifulPermutation = new int[n];
    int oddStart = 0;
    int evenStart = n % 2 == 0 ? n / 2 : (n + 1) / 2;
    int median = evenStart;
    for (int i = 1; i <= n; i++) {
      if (i % 2 == 1) {
        beautifulPermutation[oddStart] = i;
        oddStart++;
      } else {
        beautifulPermutation[evenStart] = i;
        evenStart++;
      }
    }
    if (beautifulPermutation[median - 1] - beautifulPermutation[median] <= 1) {
      System.out.println("NO SOLUTION");
    } else {
      System.out.println(Arrays.toString(beautifulPermutation));
    }
  }
}

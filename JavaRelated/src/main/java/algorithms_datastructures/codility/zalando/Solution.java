package algorithms_datastructures.codility.zalando;

import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    var solution = new Solution();

    // 3
    System.out.println(solution.solution3("abbabba"));

    // 2
    System.out.println(solution.solution2(solution.getWord("A2Le"), solution.getWord("2pL1")));
    System.out.println(solution.solution2(solution.getWord("ba1"), solution.getWord("2Ad")));

    // 1
    var array = Arrays.stream(new Integer[] {-1, 1, 2, -2}).mapToInt(i -> i).toArray();
    System.out.println(solution.solution1(array));

    // test
    System.out.println(solution.findSmallest(array));
  }

  int solution1(int[] A) {
    int ans = A[0];
    for (int i = 1; i < A.length; i++) {
      if (ans > A[i]) {
        ans = A[i];
      }
    }
    return ans;
  }

  public int solution3(String S) {
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    String longest = "";
    for (int i = 0; i < S.length(); i++) {
      sb1.append(S.charAt(i));
      sb2.insert(0, S.charAt(S.length() - i - 1));
      if (sb1.toString().contentEquals(sb2.toString()) && sb1.length() < S.length()) {
        longest = sb1.toString();
      }
    }
    return longest.length();
  }

  // a??le == ??pl?
  private boolean solution2(String first, String second) {
    if (first.length() != second.length()) return false;
    for (int i = 0; i < first.length(); i++) {
      if (!isValid(first, second, i)) {
        return false;
      }
    }
    return true;
  }

  private boolean isValid(String first, String second, int i) {
    return first.charAt(i) == second.charAt(i) || first.charAt(i) == '?' || second.charAt(i) == '?';
  }

  public String getWord(String S) {
    var builder = new StringBuilder();
    var numberHolder = new StringBuilder();
    var i = 0;
    while (i < S.length()) {
      if (!Character.isDigit(S.charAt(i))) {
        builder.append(S.charAt(i));
        i++;
        continue;
      }

      numberHolder.setLength(0);
      while (i < S.length() && Character.isDigit(S.charAt(i))) {
        numberHolder.append(S.charAt(i));
        i++;
      }
      var number = Integer.parseInt(numberHolder.toString());
      builder.append("?".repeat(number));
    }

    return builder.toString();
  }

  int findSmallest(int[] arr) {
    int smallestInt = 1;

    if (arr.length == 0) return smallestInt;

    Arrays.sort(arr);

    if (arr[0] > 1) return smallestInt;
    if (arr[arr.length - 1] <= 0) return smallestInt;

    for (int j : arr) {
      if (j == smallestInt) {
        smallestInt++;
      }
    }

    return smallestInt;
  }
}

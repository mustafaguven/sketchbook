package algorithms_datastructures.leetcode._4_First_Bad_Version;

public class FirstBadVersion {

  // constraints: 1 <= bad <= n <= 231 - 1
  // meaning left starts with 1 and n may be 230 max
  private static final int BAD = 4;

  public int firstBadVersion(int n) {
    int left = 1, right = n;
    while (left < right) {
      int median = left + ((right - left) / 2);
      if (isBadVersion(median)) {
        right = median;
      } else {
        left = median + 1;
      }
    }
    return left;
  }

  boolean isBadVersion(int bad) {
    return bad >= BAD;
  }

  public static void main(String[] args) {
    var solution = new FirstBadVersion();
    System.out.println(solution.firstBadVersion(10));
  }
}

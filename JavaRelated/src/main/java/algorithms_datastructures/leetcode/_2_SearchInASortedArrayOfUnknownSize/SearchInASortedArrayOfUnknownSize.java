package algorithms_datastructures.leetcode._2_SearchInASortedArrayOfUnknownSize;

public class SearchInASortedArrayOfUnknownSize implements ArrayReader {

  private static final Integer[] secret = {-1, 0, 3, 5, 9, 12, 921, 1646, 23217, 123123};
  private static final int target = 2;

  /*
  To speed up, one could use here bitwise shifts:
  Left shift: x << 1. The same as multiplying by 2: x * 2.
  Right shift: x >> 1. The same as dividing by 2: x / 2.
  */

  public static void main(String[] args) {
    var searchInASortedArrayOfUnknownSize = new SearchInASortedArrayOfUnknownSize();
    var result =
        searchInASortedArrayOfUnknownSize.search(searchInASortedArrayOfUnknownSize, target);
    System.out.println(result);
  }

  public int search(ArrayReader reader, int target) {
    int median,
        left = 0,
        right = 1,
        counterForFoundingTheRightBoundary = 0,
        counterForFoundingTheMedian = 0;
    while (reader.get(right) < target) {
      left = right;
      right += 1;
      counterForFoundingTheRightBoundary++;
    }
    System.out.println(
        " right boundary is found at " + counterForFoundingTheRightBoundary + " iteration");

    while (left <= right) {
      median = left + ((right - left) / 2);
      if (reader.get(median) == target) {
        System.out.println(" median is found at " + counterForFoundingTheMedian + " iteration");
        return median;
      }
      if (reader.get(median) < target) {
        left = median + 1;
      } else {
        right = median - 1;
      }
      counterForFoundingTheMedian++;
    }
    return -1;
  }

  @Override
  public int get(int index) {
    return secret[index];
  }
}

package algorithms_datastructures.leetcode._1_BinarySearch;

public class BinarySearch {

  public static void main(String[] args) {
    var binarySearch = new BinarySearch();
    var result = binarySearch.solution(new int[] {-1, 0, 3, 5, 9, 12}, 0);
    System.out.println(result);
  }

  public int solution(int[] nums, int target) {
    int median, left = 0, right = nums.length - 1;
    while (left <= right) {
      median = left + ((right - left) / 2);
      if (nums[median] == target) {
        return median;
      }
      if (nums[median] < target) {
        left = median + 1;
      } else {
        right = median - 1;
      }
    }
    return -1;
  }
}

package algorithms_datastructures.leetcode._3_FindTheIndexOfTheLargeInteger;

public interface ArrayReader {
  // Compares the sum of arr[l..r] with the sum of arr[x..y]
  // return 1 if sum(arr[l..r]) > sum(arr[x..y])
  // return 0 if sum(arr[l..r]) == sum(arr[x..y])
  // return -1 if sum(arr[l..r]) < sum(arr[x..y])
  int compareSub(int l, int r, int x, int y);

  // Returns the length of the array
  int length();
}

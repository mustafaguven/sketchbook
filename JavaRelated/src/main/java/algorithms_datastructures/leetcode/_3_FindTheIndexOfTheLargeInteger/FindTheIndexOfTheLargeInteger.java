package algorithms_datastructures.leetcode._3_FindTheIndexOfTheLargeInteger;

public class FindTheIndexOfTheLargeInteger implements ArrayReader {

  /*
    1 if arr[l]+arr[l+1]+...+arr[r] > arr[x]+arr[x+1]+...+arr[y].
    0 if arr[l]+arr[l+1]+...+arr[r] == arr[x]+arr[x+1]+...+arr[y].
    -1 if arr[l]+arr[l+1]+...+arr[r] < arr[x]+arr[x+1]+...+arr[y].
  */

  /*Input: arr = [7,7,7,7,10,7,7,7]
    Output: 4
    Explanation: The following calls to the API
  reader.compareSub(0, 0, 1, 1) // returns 0 this is a query comparing the sub-array (0, 0) with the sub array (1, 1), (i.e. compares arr[0] with arr[1]).
    Thus we know that arr[0] and arr[1] doesn't contain the largest element.
            reader.compareSub(2, 2, 3, 3) // returns 0, we can exclude arr[2] and arr[3].
            reader.compareSub(4, 4, 5, 5) // returns 1, thus for sure arr[4] is the largest element in the array.
    Notice that we made only 3 calls, so the answer is valid.*/

  private static final Integer[] array0 = {7, 7, 7, 7, 10, 7, 7, 7};
  private static final Integer[] array2 = {6, 6, 12};
  private static final Integer[] array3 = {
    1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 17, 1, 1, 1, 1, 1
  };
  private static final Integer[] array4 = {75, 75, 96, 75, 75, 75, 75, 75, 75, 75, 75, 75, 75, 75};
  private static final Integer[] array = {
    35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35,
    35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 95, 35, 35, 35, 35, 35, 35, 35, 35,
    35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35
  };

  public int getIndex(ArrayReader reader) {
    int left = 0, right = reader.length() - 1;
    var counter = 0;

    while (left <= right) {
      counter++;
      int median = left + ((right - left) / 2);
      if (right - left > 1) {
        if (this.compareSub(left, median, ((right - left) % 2 == 0) ? median : median + 1, right)
            > 0) {
          right = median;
        } else {
          left = median;
        }

      } else {
        System.out.println("compare sub has been run " + counter + " times");
        var result = compareSub(left, left, right, right);
        return result < 0 ? right : left;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    var solution = new FindTheIndexOfTheLargeInteger();
    System.out.println(solution.getIndex(solution));
  }

  @Override
  public int compareSub(int l, int r, int x, int y) {
    var sum1 = getSumOfSubArray(l, r);
    var sum2 = getSumOfSubArray(x, y);
    return Integer.compare(sum1, sum2);
  }

  private int getSumOfSubArray(int begin, int end) {
    int sum = 0;
    for (var i = begin; i <= end; i++) {
      sum += array[i];
    }
    return sum;
  }

  @Override
  public int length() {
    return array.length;
  }
}

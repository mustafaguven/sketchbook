package algorithms_datastructures.cses._04_IncreasingArray;

import java.util.Arrays;

public class IncreasingArray {

  public final Integer[] array = new Integer[] {3, 2, 5, 1, 7, 4, 9, 1, 12};

  public static void main(String[] args) {
    var ia = new IncreasingArray();
    ia.nestedSolution(0, 0, Arrays.stream(ia.array).mapToInt(it -> it).toArray());
    System.out.println("------");
    ia.solution(0, Arrays.stream(ia.array).mapToInt(it -> it).toArray());
  }

  private void solution(int i, int[] array) {
    var move = 0;
    while (i < array.length) {
      if (i == array.length - 1) return;
      var first = array[i];
      var second = array[i + 1];
      if (first > second) {
        array[i + 1] = second + 1;
        move++;
        System.out.println("move: " + move + ", array: " + Arrays.toString(array));
      } else {
        i++;
      }
    }
  }

  private void nestedSolution(int i, int move, int[] array) {
    if (i == array.length - 1) return;
    var first = array[i];
    var second = array[i + 1];
    if (first > second) {
      array[i + 1] = second + 1;
      move++;
      System.out.println("move: " + move + ", array: " + Arrays.toString(array));
    } else {
      i++;
    }
    nestedSolution(i, move, array);
  }
}

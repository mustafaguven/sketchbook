package algorithms_datastructures.cses._06_NumberSpiral;

import java.util.Arrays;

public class NumberSpiral {

  public static final int N = 10;

  public static void main(String[] args) {
    var numberSpiral = new NumberSpiral();
    numberSpiral.solution();
  }

  private void solution() {
    int[][] spiral = new int[N][N];
    spiral[0][0] = 1;
    spiral[0][1] = 2;
    spiral[1][1] = 3;
    spiral[1][0] = 4;
    spiral[2][0] = 5;
    // sablon
    // hareket sayisi cift ise hareket sayisi kadar saga ve yukari git sonra 1 saga gec
    // hareket sayisi tek ise hareket sayisi kadar asagi ve sola git

    // template starts below
    int move = 2, counter = 5;
    for (int i = 2; i < N; i++) {
      if (move % 2 == 0) {
        // move kadar saga
        for (int j = 0; j <= move; j++) {
          spiral[i][j] = counter;
          counter++;
        }
        // move kadar yukariya
        for (int j = 1; j <= move; j++) {
          spiral[move - j][move] = counter;
          counter++;
        }

        // tekrar saga
        if (move < N - 1) {
          spiral[0][move + 1] = counter;
          counter++;
        }

      } else {
        // move kadar asagiya
        for (int j = 0; j < move; j++) {
          spiral[j + 1][move] = counter;
          counter++;
        }

        // move kadar sola
        for (int j = 1; j <= move; j++) {
          spiral[i][move - j] = counter;
          counter++;
        }
      }
      move += 1;
    }
    System.out.println(Arrays.deepToString(spiral));
  }
}

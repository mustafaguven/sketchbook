package algorithms_datastructures.cses._02_Missing_Number;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CSESSubmitTrying {

  public static void main(String[] args) throws IOException {
    var br = new BufferedReader(new InputStreamReader(System.in));
    var inputParameters = br.readLine().split(" ");
    int n = Integer.parseInt(inputParameters[0]);
    int[] arr = new int[n - 1];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(inputParameters[i + 1]);
    }

    var total = (n * (n + 1) / 2);
    for (int number : arr) {
      total -= number;
    }
    System.out.println(total);
  }
}

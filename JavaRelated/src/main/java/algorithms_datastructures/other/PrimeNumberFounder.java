package algorithms_datastructures.other;

public class PrimeNumberFounder {
  public static void main(String[] args) {
    var founder = new PrimeNumberFounder();
    System.out.println(founder.isPrimeNumber(31));
  }

  private boolean isPrimeNumber(int number) {
    if (number < 2) return false;
    if (number == 2) return true;
    if (number % 2 == 0) return false;
    for (int i = 3; i < (number / 2); i += 2) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }
}

package algorithms_datastructures.cses._03_Repetitions;

public class Repetitions {

  public static final String STR = "ATTTTCCCCCCGGGAGGAAAAA";

  public static void main(String[] args) {
    var r = new Repetitions();
    r.solution();
  }

  private void solution() {
    int counter = 1, max = 0;
    char previousChar = 0, maxChar = 0;
    for (char c : STR.toCharArray()) {
      counter = c == previousChar ? counter + 1 : 1;
      if (counter > max) {
        max = counter;
        maxChar = c;
      }
      previousChar = c;
    }
    System.out.println(maxChar + " is repeating " + max + " times");
  }
}

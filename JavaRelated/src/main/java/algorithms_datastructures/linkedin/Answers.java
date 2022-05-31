package algorithms_datastructures.linkedin;

import java.util.ArrayList;
import java.util.List;

public class Answers {
  public static void main(String[] args) {
    // question1();
    // question2();
    // question3();
  }

  private static void question3() {
    List list = new ArrayList();
    list.add("hello");
    list.add(2);
    System.out.print(list.get(0) instanceof Object);
    System.out.print(list.get(1) instanceof Integer);
  }

  /*  private static void question2() {
    try {
      System.out.print("hello world");
    } catch (Exception e) {
      System.out.println("e");
    } catch (ArithmeticException e) {
      System.out.println("e");
    }  finally {
      System.out.println("!");
    }
  }*/

  private static void question1() {
    for (int i = 0; i < 10; i = i++) {
      i = ++i;
      System.out.println(i);
    }
  }
}

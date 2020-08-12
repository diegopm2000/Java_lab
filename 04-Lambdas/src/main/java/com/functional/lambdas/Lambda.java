package com.functional.lambdas;

import java.util.stream.IntStream;

public class Lambda 
{
  public void test(String selection) {
    // Odd / Even
    switch(selection) {
      case "ODD":
        IntStream.of(1, 2, 3, 4, 5, 6, 7).filter((var i) -> i % 2 == 0).forEach(System.out::println);
        break;
      case "EVEN":
        IntStream.of(1, 2, 3, 4, 5, 6, 7).filter((var i) -> i % 2 != 0).forEach(System.out::println);
        break;
    }
  }

  public void sum() {
    IOperation operation = (var x, var y) -> (x + y);
    double result = operation.calculate(2, 2.0);
    System.out.println(result);
  }
}

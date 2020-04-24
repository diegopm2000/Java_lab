package com.newfeatures.opts;

import java.util.Optional;

public class Demo {

  // JDK 11
  public void isEmpty(Person per) {
    Optional<Person> op = Optional.ofNullable(per);
    if (op.isEmpty()) {
      System.out.println("[11] It is Empty");      
    } else {
      System.out.println("[11] It is Full " + op.get());
    }
  }

  // JDK 8
  public void isPresent(Person per) {
    Optional<Person> op = Optional.ofNullable(per);
    if (!op.isPresent()) {
      System.out.println("[8] It is Empty");      
    } else {
      System.out.println("[8] It is Full " + op.get());
    }
  }
}
package com.newfeatures.opts;

public class Person {

  private int id;
  private String name;

  public Person() {

  }
  
  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }
}
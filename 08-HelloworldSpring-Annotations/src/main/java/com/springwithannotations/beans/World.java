package com.springwithannotations.beans;

import org.springframework.beans.factory.annotation.Value;

public class World {

  @Value("Hello World Spring")
  private String greetings;

  public String getGreetings() {
    return greetings;
  }

  public void setGreetings(String greetings) {
    this.greetings = greetings;
  }
}

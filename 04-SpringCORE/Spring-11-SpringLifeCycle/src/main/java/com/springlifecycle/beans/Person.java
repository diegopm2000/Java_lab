package com.springlifecycle.beans;

public class Person {

  private int id;
  private String name;
  private String surname;
  private Country country;

  // Getters & Setters

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Country getCountry() {
    return this.country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  // Life cycle

  public void init() {
    System.out.println("Initialization of Bean Person");
  }

  public void destroy() {
    System.out.println("Destruction of Bean Person");
  }
}
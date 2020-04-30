package com.springlifecycleinterfaces.beans;

public class Country {

  private String name;
  private City city;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public City getCity() {
    return this.city;
  }

  public void setCity(City city) {
    this.city = city;
  }
    
}